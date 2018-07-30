package com.leotorrealba.petagramv2.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leotorrealba.petagramv2.R;
import com.leotorrealba.petagramv2.adapter.MascotaAdaptador;
import com.leotorrealba.petagramv2.adapter.MascotaAdaptador2;
import com.leotorrealba.petagramv2.pojo.Mascota;

import java.util.ArrayList;

public class SecondActivity extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvOtrosPerros;
    public MascotaAdaptador2 adaptador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_second, container, false);

        View view = inflater.inflate(R.layout.fragment_second, container, false);

        rvOtrosPerros = (RecyclerView) view.findViewById(R.id.rvOtrosPerros);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        rvOtrosPerros.setLayoutManager(glm);

        inicilizarListaMascotas();
        inicializarAdaptador();

        return view;
    }

    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador2(mascotas, getActivity());
        rvOtrosPerros.setAdapter(adaptador);

    }

    public void inicilizarListaMascotas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota("Fifi",R.drawable.dog2,8));
        mascotas.add(new Mascota("Gold",R.drawable.dog3,1));
        mascotas.add(new Mascota("Silver",R.drawable.dog4,2));
        mascotas.add(new Mascota("Snoopy",R.drawable.dog5,10));
        mascotas.add(new Mascota("Pluto",R.drawable.dog6,17));
        mascotas.add(new Mascota("Scooby Doo",R.drawable.dog7,5));

    }

}
