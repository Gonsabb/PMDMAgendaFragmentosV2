package com.example.gonzalo.pmdmagendafragmentosv2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gonzalo.pmdmagendafragmentosv2.gestoragenda.Contacto;

import java.util.ArrayList;

/**
 * Created by Gonzalo on 13/12/2015.
 */
public class Adaptador extends ArrayAdapter<Contacto> {

    private Context contexto;
    private int recurso;
    private ArrayList<Contacto> lista;
    private LayoutInflater i;

    static class ViewHolder{
        public TextView tvNombre,tvtelefono;
    }

    public Adaptador(Context contexto, int recurso, ArrayList<Contacto> lista) {
        super(contexto, recurso, lista);
        this.contexto=contexto;
        this.recurso=recurso;
        this.lista=lista;
        i = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        TextView tv1, tv2;
        ViewHolder vh;
        Log.v("Adaptador", "Llamada posición: " + position);

        if(convertView==null){
            Log.v("Adaptador", "inflando");
            convertView = i.inflate(R.layout.item, null);
            tv1 = (TextView) convertView.findViewById(R.id.tvNombre);
            tv2= (TextView) convertView.findViewById(R.id.tvTfn);

            vh = new ViewHolder();
            vh.tvNombre =tv1;
            vh.tvtelefono=tv2;
            convertView.setTag(vh);
        }else{
            vh=(ViewHolder)convertView.getTag();
            Log.v("Adaptador", "Aprovechando");
        }

        vh.tvNombre.setText(lista.get(position).getNombre());
        if(lista.get(position).getTelefonos().size()>=1){
            vh.tvtelefono.setText(lista.get(position).getTelefonos().get(0));
        }else{
            vh.tvtelefono.setText("Sin teléfonos.");
        }

        return convertView;
    }


}