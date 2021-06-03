package com.juan.recicle_view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PalabrasAdpter extends RecyclerView.Adapter<PalabrasAdpter.PalabrasHolder>{
    Context context;
    ArrayList <Anime> lista_Anime;
    LayoutInflater inflater;

    public PalabrasAdpter(Context context, ArrayList<Anime> lista_Anime) {
        this.context = context;
        this.lista_Anime = lista_Anime;
        this.inflater = LayoutInflater.from(this.context);
    }

    @Override
    public PalabrasHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View item = inflater.inflate(R.layout.item, parent,false);
        PalabrasHolder holder = new PalabrasHolder(item);

        return holder;
    }

    @Override
    public void onBindViewHolder(PalabrasAdpter.PalabrasHolder holder, int position) {
          Anime anime = lista_Anime.get(position);
          holder.textView.setText(anime.nombre());
          holder.imageView.setImageResource(anime.imagen());
    }

    @Override
    public int getItemCount() {
        return lista_Anime.size();
    }

    class PalabrasHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView textView;
    ImageView imageView;


        public PalabrasHolder( View itemView) {
            super(itemView);
             textView = itemView.findViewById(R.id.txt_item);
             imageView = itemView.findViewById(R.id.imageView);


             itemView.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View v) {
            int pososion = getLayoutPosition();
            Intent intent = new Intent(context,SegundaActivity.class);
            intent.putExtra("Posicion", pososion);

            context.startActivity(intent);

        }
    }
}
