package com.example.gonzalo.pmdmagendafragmentosv2;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gonzalo.pmdmagendafragmentosv2.gestoragenda.Contacto;

import java.util.ArrayList;


public class FragmentDetail extends Fragment {
    private View fragmentView;
    private ImageView iv;
    private TextView nombre, telefonos;


    public FragmentDetail() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView= inflater.inflate(R.layout.fragment_fragment_detail, container, false);
        nombre =(TextView)fragmentView.findViewById(R.id.tvNombreDetail);
        telefonos = (TextView)fragmentView.findViewById(R.id.tvTfnosDetail);
        iv = (ImageView)fragmentView.findViewById(R.id.ivDetail);
        return fragmentView;
    }

    public void setDatos(Contacto contacto){
        nombre.setText("");
        telefonos.setText("");
        nombre.setText(contacto.getNombre().trim());
        telefonos.setText(getNumeros(contacto));
    }

    public String getNumeros(Contacto contact){
        ArrayList<String> numeros = contact.getTelefonos();
        String a = "";
        for (String tfn : numeros) {
            a+= tfn + "\n";
        }

        return a;
    }

}
