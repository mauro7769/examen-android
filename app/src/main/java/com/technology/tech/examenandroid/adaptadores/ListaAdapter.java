package com.technology.tech.examenandroid.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.technology.tech.examenandroid.R;
import com.technology.tech.examenandroid.modelo.Cancha;
import com.technology.tech.examenandroid.modelo.ResponseCancha;

import java.util.List;

/**
 * Created by usuario on 02-12-2017.
 */

public class ListaAdapter extends ArrayAdapter<ResponseCancha> {
    private List<ResponseCancha> list;
    private Context context;

    public ListaAdapter(Context context,List<ResponseCancha> list) {
        super(context, R.layout.items, list);
        this.list=list;
        this.context=context;
    }

    static class ViewHolder{
        protected ImageView imgPartido;
        protected TextView tvNombre;
        protected TextView tvDireccion;
        protected TextView tvTipo;
        protected TextView tvCantidad;
        protected TextView tvimg;
        protected TextView tvTelefono;
        protected TextView tvWeb;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;

        ViewHolder holder;
        if (v == null) {
            LayoutInflater infla = LayoutInflater.from(context);
            v = infla.inflate(R.layout.items,null);
            holder = new ViewHolder();

            //Picasso.with(v.getContext()).load(getItem(position).getUrlAvatar()).into(holder.imgPartido);

            holder.imgPartido=(ImageView) v.findViewById(R.id.imgPartidoItem);
            holder.tvNombre=(TextView)v.findViewById(R.id.tvNombreItem);
            holder.tvDireccion=(TextView)v.findViewById(R.id.tvDireccionItem);
            holder.tvTipo=(TextView)v.findViewById(R.id.tvTipoItem);
            holder.tvCantidad=(TextView)v.findViewById(R.id.tvCantidadItem);
            holder.tvimg=(TextView)v.findViewById(R.id.tvImgItem);
            holder.tvTelefono=(TextView)v.findViewById(R.id.tvTelefonoItem);
            holder.tvWeb=(TextView)v.findViewById(R.id.tvWebItem);

            v.setTag(holder);
        }
        else{

            holder = (ViewHolder) v.getTag();
        }
        Picasso.with(v.getContext()).load(getItem(position).getUrlAvatar()).into(holder.imgPartido);
        holder.tvNombre.setText(list.get(position).getNombreRecinto());
        holder.tvDireccion.setText(list.get(position).getDireccion());
        holder.tvTipo.setText(list.get(position).getDescripcion());

        String cant;
        cant = String.valueOf(list.get(position).getCantidadCanchas());
        holder.tvCantidad.setText(cant);

        holder.tvimg.setText(list.get(position).getUrlBanner());
        holder.tvTelefono.setText(list.get(position).getTelefono());
        holder.tvWeb.setText(list.get(position).getUrlSitio());

        return v;
    }
}
