package com.leotorrealba.petagramv2.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.leotorrealba.petagramv2.R;
import com.leotorrealba.petagramv2.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdaptador2 extends RecyclerView.Adapter<MascotaAdaptador2.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador2(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
        }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listado_mascotas2,parent,false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvCantidadLikesCV.setText(Integer.toString(mascota.getLikes()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvCantidadLikesCV;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgFoto             = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvCantidadLikesCV   = (TextView) itemView.findViewById(R.id.tvCantidadLikesCV);
        }
    }
}
