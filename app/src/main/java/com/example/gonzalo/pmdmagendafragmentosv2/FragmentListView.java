package com.example.gonzalo.pmdmagendafragmentosv2;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gonzalo.pmdmagendafragmentosv2.gestoragenda.Contacto;
import com.example.gonzalo.pmdmagendafragmentosv2.gestoragenda.GestorAgenda;

import java.util.ArrayList;
import java.util.Collections;


public class FragmentListView extends Fragment {

    private View fragmentView;
    private ArrayList<Contacto> contactos;
    private ListView lv;
    private GestorAgenda ga;
    private Adaptador adap;
    private OnFragmentoInteraccionListener listener;

    public FragmentListView() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView= inflater.inflate(R.layout.fragment_fragment_list_view, container, false);
        init();
        return fragmentView;
    }

    private void init() {
        ga= new GestorAgenda(getActivity());
        contactos = ga.getGestion();

        for(Contacto aux:contactos){
            aux.setTelefonos((ArrayList<String>) ga.getListaTelefonos(getActivity(),aux.getId()));
        }
        Collections.sort(contactos);

        for(int z =0; z<contactos.size(); z++ ){
            contactos.get(z).setId(z);
        }

        /********************************************************/
//        ArrayList<Contacto> c= new ArrayList<>();
//        Contacto a = new Contacto(1, "pepe", null);
//        ArrayList<String>tf= new ArrayList<>();
//        tf.add("97237643");
//        tf.add("92764774");
//        Contacto b = new Contacto(2, "Juan", tf);
//        c.add(a);
//        c.add(b);
        /***********************************************/

        lv=(ListView)fragmentView.findViewById(R.id.listView);

        adap = new Adaptador(getActivity(), R.layout.item, contactos);
        lv.setAdapter(adap);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.OnInteraccion1(contactos.get(position));
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentoInteraccionListener){
            listener=(OnFragmentoInteraccionListener)context;
        }else{
            throw new ClassCastException("Solo acepto OnFragmentoInteraccionListener");
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof OnFragmentoInteraccionListener){
            listener=(OnFragmentoInteraccionListener)activity;
        }else{
            throw new ClassCastException("Solo acepto OnFragmentoInteraccionListener");
        }
    }

}
