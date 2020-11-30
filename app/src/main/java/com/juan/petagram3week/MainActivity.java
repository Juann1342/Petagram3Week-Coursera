package com.juan.petagram3week;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    public MascotaAdaptador adaptador;
    //declaro recycler view
    private RecyclerView listaMascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFab();
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBAr);
        setSupportActionBar(miActionBar);
        final ActionBar ab =getSupportActionBar();
        // .setDefaultDisplayHomeAsUpEnabled(true)
        ab.setDisplayShowHomeEnabled(false);
        ab.setDisplayHomeAsUpEnabled(false);
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        //ab.setTitle(R.string.titulo_toolbar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        //defino de que forma quiero mostrar el recyclerview
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
        mascotas.add(new Mascota("Pilo",R.drawable.pet1,"5"));
        mascotas.add(new Mascota("Luki",R.drawable.pet2,"4"));
        mascotas.add(new Mascota("Fuxy",R.drawable.pet3,"2"));
        mascotas.add(new Mascota("Pyt",R.drawable.pet4,"3"));
        mascotas.add(new Mascota("Shampy",R.drawable.pet5,"4"));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.item_favs:
                Intent intent = new Intent(this, Mascotas_Favoritas.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void agregarFab(){
        FloatingActionButton miFAB = (FloatingActionButton) findViewById(R.id.miFab);
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), ":)", Toast.LENGTH_LONG).show();

            }
        });
    }
}