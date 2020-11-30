package com.juan.petagram3week;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Mascotas_Favoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    public MascotaAdaptador adaptador;
    private RecyclerView listaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas__favoritas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBAr);
        setSupportActionBar(miActionBar);
        final ActionBar ab =getSupportActionBar();
        ab.setDisplayShowHomeEnabled(false);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

    }
        public void inicializarAdaptador(){
                adaptador = new MascotaAdaptador(mascotas, this);
                listaMascotas.setAdapter(adaptador);
    }

        public void inicializarListaMascotas(){
                mascotas = new ArrayList<Mascota>();
                mascotas.add(new Mascota("Shampy",R.drawable.pet5,"4"));
                mascotas.add(new Mascota("Luki",R.drawable.pet2,"4"));
                mascotas.add(new Mascota("Fuxy",R.drawable.pet3,"2"));
                mascotas.add(new Mascota("Pyt",R.drawable.pet4,"3"));
                mascotas.add(new Mascota("Pilo",R.drawable.pet1,"5"));

    }
}
