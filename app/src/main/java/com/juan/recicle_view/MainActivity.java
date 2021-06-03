package com.juan.recicle_view;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.juan.recicle_view.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private ArrayList<Anime> lista_Anime;
    RecyclerView recycle;
    PalabrasAdpter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        lista_Anime = Datos.lista_Anime;
        Calendar fecha = Calendar.getInstance();

        fecha.set(1990, 10, 9);
        lista_Anime.add(new Anime("Naruto: ", R.drawable.naruto_fondo_2, "Naruto es un ninja de Konoha y forma parte del «Equipo 7», compuesto por Sasuke Uchiha, Sakura Haruno y su líder y sensei, Kakashi Hatake.", fecha));
        fecha.set(2017, 10, 3);
        lista_Anime.add(new Anime("Black clover: ", R.drawable.black_clover_1,"'Black Clover' nos sitúa en un mundo en el que la magia es de vital importancia:", fecha));
        fecha.set(2021, 01, 14);
        lista_Anime.add(new Anime("Dr. Stone: ", R.drawable.dr_stone, "Dr. Stone  La historia cuenta las aventuras de Senku y Taiju, ", fecha));
        fecha.set(2013, 07, 13);
        lista_Anime.add(new Anime("Attak of titan: ", R.drawable.ataque_1, "Cuenta la historia de la humanidad luchando por sobrevivir los ataques de unos seres humanoides gigantes llamados titanes.", fecha));
        fecha.set(2021, 02, 25);
        lista_Anime.add(new Anime("Invasion en las Alturas: ", R.drawable.invasion, "La joven Yuri se encuentra en la cima de un rascacielos en un mundo extraño, donde debe sobrevivir los embates de atacantes enmascarados que buscan matar a sus presas.", fecha));
        fecha.set(2017, 07, 1);
        lista_Anime.add(new Anime("Kakeguruy: ", R.drawable.kakeguruy_1, "umeko Jabami es una gran apostadora y planea limpiar Hyakkaou, una academia privada que evalúa a los estudiantes solo por sus habilidades en los juegos de azar.", fecha));
        fecha.set(2021, 04, 3);
        lista_Anime.add(new Anime("La Masmorra : ", R.drawable.masmorra_1," La mazmorra oculta solo yo puedo entrar es una fantasía japonesa novela ligera serie escrita por Meguru Seto e ilustrada por Note Takehana. ", fecha));
        fecha.set(2018, 8, 18);
        lista_Anime.add(new Anime("Los 7 pecados capitasles: ", R.drawable.pecados_1, "Nanatsu  no Taizai, Los Siete Pecados Capitales es la orden de caballeros más poderosa de toda Britannia, ", fecha));
        fecha.set(2016, 12, 25);
        lista_Anime.add(new Anime("Seint Seia: ", R.drawable.sain_1,"Saint Seiya conocida como Los Caballeros del Zodiaco, es una serie de manga escrita e ilustrada por Masami Kurumada.", fecha));
        fecha.set(2021, 02, 25);
        lista_Anime.add(new Anime("Invasion en las Alturas: ", R.drawable.invacion_1," Invasión de altura, también conocido como High-Rise Invasion o Tenkū Shinpan (天空侵犯).", fecha));
        fecha.set(2013, 07, 13);
        lista_Anime.add(new Anime("Ataque alos Titanes: ", R.drawable.ataque, "Shingeki no Kyojin) es un manga serializado escrito e ilustrado por Hajime Isayama. ", fecha));
        fecha.set(2021, 01, 14);
        lista_Anime.add(new Anime("Dr. Stone: ", R.drawable.dr_st," Dr. STONE, La historia cuenta las aventuras de Senku y Taiju, dos adolescentes que se ven atrapados en un mundo post-apocalíptico en el cual, la raza humana se ha convertido en piedra ",fecha));
        fecha.set(1999, 9, 21);
        lista_Anime.add(new Anime("Naruto: ", R.drawable.naruto_fondo_1,"NARUTO, es una serie de manga escrita e ilustrada por Masashi Kishimoto. La obra narra la historia de un ninja adolescente llamado Naruto Uzumaki, ", fecha));

        recycle = findViewById(R.id.Recicle_1);
        adapter = new PalabrasAdpter(this, lista_Anime);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));
        binding.fab1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            }
        });


        ItemTouchHelper helper = new ItemTouchHelper(new SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(lista_Anime, from, to);
                adapter.notifyItemMoved(from, to);
                return true;

            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder,
                                 int direction) {
                lista_Anime.remove(viewHolder.getAdapterPosition());
                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

        helper.attachToRecyclerView(recycle);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}