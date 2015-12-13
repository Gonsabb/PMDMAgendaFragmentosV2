package com.example.gonzalo.pmdmagendafragmentosv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.gonzalo.pmdmagendafragmentosv2.gestoragenda.Contacto;

import java.util.ArrayList;

public class Principal extends AppCompatActivity implements OnFragmentoInteraccionListener {

    public static final int APLIC=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);
        String valor = null;
        if(savedInstanceState!=null){
            valor=savedInstanceState.getString("valor");
        }
        if(valor!= null){
            Intent i = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("valor", valor);
            i.putExtras(bundle);
        }
    }


    @Override
    public void OnInteraccion1(Contacto contacto) {
        FragmentDetail fragmento= (FragmentDetail) getFragmentManager().findFragmentById(R.id.fragmentDetailLand);

        if (fragmento == null || !fragmento.isInLayout())  {
            //vertical
            Intent i = new Intent(this, ActividadSecundaria.class);
            Bundle b= new Bundle();

            b.putSerializable("contacto", contacto);
            i.putExtras(b);
            startActivityForResult(i, APLIC);

        }else{
            //horizontal
            fragmento.setDatos(contacto);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == APLIC){
            Contacto x = (Contacto) data.getExtras().getSerializable("contacto");
            OnInteraccion1(x);
        }

    }
}
