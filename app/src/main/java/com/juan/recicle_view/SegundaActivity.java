package com.juan.recicle_view;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juan.recicle_view.databinding.ActivitySegundaBinding;

public class SegundaActivity extends AppCompatActivity {

    private ActivitySegundaBinding binding;
    private TextView txt_dscripcion;
    private ImageView imagenview3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySegundaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;

        txt_dscripcion = findViewById(R.id.txt_descripcion);
        imagenview3 = findViewById(R.id.imageView3);
        Intent intent = getIntent();

        int poscion = intent.getIntExtra("Posicion",0);
        Anime anime = Datos.lista_Anime.get(poscion);
        toolBarLayout.setTitle(anime.nombre());
        txt_dscripcion.setText(anime.getDescripcion());
        imagenview3.setImageResource(anime.imagen());

        FloatingActionButton fab = binding.fab1;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}