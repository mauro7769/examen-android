package com.technology.tech.examenandroid;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.technology.tech.examenandroid.adaptadores.ListaAdapter;
import com.technology.tech.examenandroid.interfaces.IService;
import com.technology.tech.examenandroid.modelo.Cancha;
import com.technology.tech.examenandroid.modelo.ResponseCancha;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListadoActivity extends AppCompatActivity {
    private ListView lvListado;
    private ListaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        lvListado=(ListView)findViewById(R.id.lvPartidos);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        IService service = retrofit.create(IService.class);
        Call<Cancha> repos = service.listarPartidos();
        repos.enqueue(new Callback<Cancha>() {
            @Override
            public void onResponse(Call<Cancha> call, Response<Cancha> response) {
                if (response.code() == 200) {

                    ResponseCancha[] values = response.body().getResponse();
                    List<ResponseCancha> partidos;
                    partidos=new ArrayList<>();

                    for (ResponseCancha item:values){
                        if (item!=null){
                            partidos.add(item);
                        }
                    }

                    adapter = new ListaAdapter(ListadoActivity.this, partidos);
                    lvListado.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Cancha> call, Throwable t) {
                Toast.makeText(ListadoActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

        lvListado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView nom,tip,img,tel,web;
                nom = (TextView)view.findViewById(R.id.tvNombreItem);
                tip =(TextView)view.findViewById(R.id.tvTipoItem);
                img =(TextView)view.findViewById(R.id.tvImgItem);
                tel =(TextView)view.findViewById(R.id.tvTelefonoItem);
                web =(TextView)view.findViewById(R.id.tvWebItem);

                String n=nom.getText().toString(),
                        t=tip.getText().toString(),
                        im=img.getText().toString(),
                        te = tel.getText().toString(),
                        w = web.getText().toString();

                Intent i = new Intent(ListadoActivity.this,DetalleActivity.class);
                i.putExtra("nombre",n);
                i.putExtra("tipo", t);
                i.putExtra("banner", im);
                i.putExtra("telefono", te);
                i.putExtra("web", w);
                startActivity(i);
            }
        });
    }
}
