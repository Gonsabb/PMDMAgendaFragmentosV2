package com.example.gonzalo.pmdmagendafragmentosv2;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gonzalo.pmdmagendafragmentosv2.gestoragenda.Contacto;

public class ActividadSecundaria extends AppCompatActivity {

    private Contacto contactoaux;
    private Contacto contacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contactoaux =null;

        String valor = null;
        if(savedInstanceState!=null){
            contactoaux = (Contacto) savedInstanceState.getSerializable("contactoaux");
        }
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.activity_actividad_secundaria);

            contacto = (Contacto) getIntent().getExtras().getSerializable("contacto");
            Intent i=new Intent (this,ActividadSecundaria.class);
            Bundle b= new Bundle();
            b.putSerializable("contacto", contacto);
            i.putExtras(b);

            FragmentDetail fragmento= (FragmentDetail) getFragmentManager().findFragmentById(R.id.fragmentDetail);
            fragmento.setDatos(contacto);
        }else{
            Intent i = new Intent(this, ActividadSecundaria.class);
            Bundle bundle = new Bundle();
            contacto = (Contacto) getIntent().getExtras().getSerializable("contacto");

            bundle.putSerializable("contacto", contacto);
            i.putExtras(bundle);

            setResult(Principal.APLIC, i);
            finish();
        }

    }
}
