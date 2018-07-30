package com.leotorrealba.petagramv2.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.leotorrealba.petagramv2.DetalleMascota;
import com.leotorrealba.petagramv2.R;
import com.leotorrealba.petagramv2.adapter.MascotaAdaptador;
import com.leotorrealba.petagramv2.pojo.Mascota;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvPerros;
    public MascotaAdaptador adaptador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_main, container, false);
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        rvPerros = (RecyclerView) view.findViewById(R.id.rvPerros);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvPerros.setLayoutManager(llm);

        inicilizarListaMascotas();
        inicializarAdaptador();

        return view;
    }

    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, getActivity());
        rvPerros.setAdapter(adaptador);

    }

    public void inicilizarListaMascotas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota("Rocky",R.drawable.dog1,4));
        mascotas.add(new Mascota("Fifi",R.drawable.dog2,8));
        mascotas.add(new Mascota("Gold",R.drawable.dog3,1));
        mascotas.add(new Mascota("Silver",R.drawable.dog4,2));
        mascotas.add(new Mascota("Snoopy",R.drawable.dog5,10));
        mascotas.add(new Mascota("Pluto",R.drawable.dog6,17));
        mascotas.add(new Mascota("Scooby Doo",R.drawable.dog7,5));

    }
}
