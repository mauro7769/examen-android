package com.technology.tech.examenandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class DetalleActivity extends AppCompatActivity {
    private ImageView img;
    private TextView nombre,tipo;

    private Button web,contacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        nombre = (TextView)findViewById(R.id.tvNombreCanchaDetalle);
        tipo = (TextView)findViewById(R.id.tvTipoCanchaDetalle);
        img = (ImageView)findViewById(R.id.imgDetalle);
        web = (Button) findViewById(R.id.btnWeb);
        contacto = (Button)findViewById(R.id.btnContacto);



        String nom = getIntent().getStringExtra("nombre");
        String tip = getIntent().getStringExtra("tipo");
        String im = getIntent().getStringExtra("banner");
        final String fono = getIntent().getStringExtra("telefono");
        final String w = getIntent().getStringExtra("web");

        Picasso.with(this).load(im).into(img);

        nombre.setText(nom);
        tipo.setText(tip);

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(w));
                startActivity(intent);
            }
        });

        contacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_DIAL,Uri.parse("tel:"+fono)); //
                startActivity(i);
            }
        });


    }
}
