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

        lista_Anime.add(new Anime("Naruto: ", R.drawable.naruto_fondo_1,"Naruto.... (ナルト?), romanizada como NARUTO, es una serie de manga escrita e ilustrada por Masashi Kishimoto. La obra narra la historia de un ninja adolescente llamado Naruto Uzumaki, quien aspira a convertirse en Hokage, líder de su aldea, con el propósito de ser reconocido como alguien importante dentro de la aldea y entre sus compañeros.\n" +
                "" +
                "La serie está basada en un one-shot que Kishimoto realizó en agosto de 1996 para la revista Akamaru Jump.3 A partir de noviembre de 1999, Naruto es publicado por la editorial Shūeisha en la revista semanal japonesa Shōnen Jump,4\u200B siendo recopilado desde entonces en setenta y dos volúmenes. El éxito del manga hizo que su trama fuera adaptada a un anime producido por Pierrot y distribuido por Aniplex, el cual fue transmitido por la cadena televisiva TV Tokyo el 3 de octubre de 2002. La primera temporada duró 220 episodios,", fecha));
        fecha.set(1990, 10, 9);
        fecha.set(2017, 10, 3);
        lista_Anime.add(new Anime("Black clover: ", R.drawable.black_clover_1,"'Black Clover.... ('Burakku Kurōbā' es el nombre original) es un anime japonés basado en el manga del mismo nombre, obra de Yuki Tabata. Dirigido por Tatsuya Yoshihara, nos sitúa en un mundo en el que la magia es de vital importancia: todo el mundo tiene 'poder mágico' y una habilidad natural para controlarlo.", fecha));
        fecha.set(2021, 01, 14);
        lista_Anime.add(new Anime("Dr. Stone: ", R.drawable.dr_stone, "Dr Stone.... cuenta la historia de dos adolescentes, Senku y Taiju; Senku se caracteriza por ser sumamente inteligente además de pertenecer al club de química de su escuela mientras que Taiju, no es demasiado inteligente como él, pero lo compensa con su gran fuerza física y que está enamorado de una linda estudiante de nombre ...", fecha));
        fecha.set(2013, 07, 13);
        lista_Anime.add(new Anime("Attak of titan: ", R.drawable.ataque_1, "Attack on Titan (進撃の巨人 Shingeki no Kyojin) es un manga serializado escrito e ilustrado por Hajime Isayama.\n" +
                "\n" +
                "Cuenta la historia de la humanidad en una época con estética germana del siglo 19, luchando por sobrevivir durante los ataques de unos seres humanoides gigantes llamados titanes. Los titanes se dedican a comer humanos por puro gusto. Luego de una larga espera, los fanáticos pudieron presenciar cómo continuaba la historia de Eren, Levi y su grupo de soldados.", fecha));
        fecha.set(2021, 02, 25);
        lista_Anime.add(new Anime("Invasion en las Alturas: ", R.drawable.invasion, "La premisa de Invasión de altura es, en un principio, bastante simple: nos presentan un juego de supervivencia en el que Yūri Honjō, una chica de instituto, se encuentra de repente en un mundo totalmente diferente al suyo en el que tiene como misión encontrar a su hermano Rika. Este espacio está lleno de rascacielos que están unidos entre ellos por puentes colgantes, de forma que cualquiera puede ir moviéndose entre las azoteas. Sin embargo, no será tan sencillo, porque varias personas enmascaradas van a intentar matarla o hacer que caiga en desesperación y se suicide.", fecha));
        fecha.set(2017, 07, 1);
        lista_Anime.add(new Anime("Kakeguruy: ", R.drawable.kakeguruy_1, "La historia.... sigue a Yumeko una estudiante de segundo año que se traslada a la academia y que demuestra ser una jugadora compulsiva que ama apostar. Gracias a su gran inteligencia y la ayuda de su compañero Suzui intentará derrotar al consejo estudiantil mediante juegos y estrategias. " +
                "" +
                "La temporada 2 de la serie Kakegurui se estrenó el día 09 de Enero de 2019. En esta 2 temporada se realizaron un total de 12 capítulos.                                  蛇喰 夢子 Jabami Yumeko Sinopsis. Jóvenes de familias influyentes en la política y negocios importantes asisten a la Academia Privada Hyakkaou. Allí, la jerarquía de los estudiantes se clasifica por una serie de juegos. Si ganas podrás entrar al cielo, pero si pierdes, al infierno.", fecha));
        fecha.set(2021, 04, 3);
        lista_Anime.add(new Anime("La Masmorra : ", R.drawable.masmorra_1," Las mazmorras.... ocultas son un lugar de leyendas donde se esconden tesoros y objetos raros. Noir, el tercer hijo de una familia noble menor que adquiere una habilidad excepcional que le proporciona un gran conocimiento pero le provoca dolorosos dolores de cabeza. Noir tuvo la suerte de encontrar una mazmorra y descubre a una aventurera legendaria Olivia Servant, que ha estado atrapada en el laberinto durante siglos, y ella le da tres poderosas habilidades.  Noir (ノ ル, Noru)\n" +
                "Expresado por: Ryōta Ōsaka[4]\n" +
                "El protagonista principal, Noir, es un noble del rango más bajo que está ansioso por convertirse en héroe. Durante una exploración de una mazmorra secreta, conoce a Olivia, quien le otorga el poder de mejorar libremente sus poderes y los de otras personas gastando LP (Life Points) que se obtienen al tener experiencias alegres pero con el riesgo de morir si su LP está completamente agotado.", fecha));
        fecha.set(2018, 8, 18);
        lista_Anime.add(new Anime("Los 7 pecados capitasles: ", R.drawable.pecados_1, "Los Siete Pecados Capitales.... representan a un grupo de caballeros que fueron acusados injustamente de intentar en un momento derrocar al rey de Britania. Durante la revuelta, lograron ser derrotados por los caballeros sagrados desapareciendo del reino. Una década después, los mismos caballeros sagrados organizaron un golpe de estado, tomando prisionero al rey y autodenominándose como los nuevos dueños de Britania. La princesa Elizabeth logró escapar y se puso como meta buscar a los siete pecados capitales, los únicos capaces de hacer frente a los Caballeros Sagrados", fecha));
        fecha.set(2016, 12, 25);
        lista_Anime.add(new Anime("Seint Seia: ", R.drawable.sain_1,"La trama de Saint Seiya.... nos narraba la historia de unos guerreros, los caballeros de Atenea, capaces de desgarrar el cielo con sus puños y romper la tierra con sus patadas. Estos guerreros eran entrenados desde pequeños para entrar en armonía con sus constelaciones protectoras, de las que recibían el nombre, y dominar los misterios de sus cosmos interiores, con los que eran capaces de desarrollar técnicas de ataque y defensa inimaginables para un humano normal. Una vez terminada su formación, serían nombrados caballeros, se les entregaría una armadura y se les asignaría la protección de la diosa Atenea y de toda la humanidad.", fecha));
        fecha.set(2021, 02, 25);
        lista_Anime.add(new Anime("Invasion en las Alturas: ", R.drawable.invacion_1,"Matar o morir...." +
                "La premisa de Invasión de altura es, en un principio, bastante simple: nos presentan un juego de supervivencia en el que Yūri Honjō, una chica de instituto, se encuentra de repente en un mundo totalmente diferente al suyo en el que tiene como misión encontrar a su hermano Rika. Este espacio está lleno de rascacielos que están unidos entre ellos por puentes colgantes, de forma que cualquiera puede ir moviéndose entre las azoteas. Sin embargo, no será tan sencillo, porque varias personas enmascaradas van a intentar matarla o hacer que caiga en desesperación y se suicide.", fecha));
        fecha.set(2013, 07, 13);
        lista_Anime.add(new Anime("Ataque alos Titanes: ", R.drawable.ataque, "Shingeki no Kyojin.... avanza con una cuarta y última temporada que está más atrapante que nunca. La serie de animé estrenó este domingo su séptimo capítulo y quedan sólo tres para conocer el cierre definitivo de la historia. El último lanzamiento dejó revelaciones y preguntas de cara al final. Repasa tanto teorías como explicaciones de lo que sucedió y lo que vendrá en la serie. ¡Imperdible!\n" +
                "\n" +
                "\"Asalto\", el estreno de este domingo, fue un episodio audaz completo de escenas de acción que incluyeron balas, sangre y guerra. El ataque de Eren a Marley continúa con la ayuda de los exploradores. Zeke usa su titán Bestia con el resto de los guerreros para defenderse mientras la batalla alcanza su clímax", fecha));
        fecha.set(2021, 01, 14);
        lista_Anime.add(new Anime("Dr. Stone: ", R.drawable.dr_st,"Dr. Stone.... cuenta la historia de dos adolescentes, Senku y Taiju; Senku se caracteriza por ser sumamente inteligente además de pertenecer al club de química de su escuela mientras que Taiju, no es demasiado inteligente como él, pero lo compensa con su gran fuerza física y que está enamorado de una linda estudiante de nombre Yuzuriha, de la que pretende confesarse. Cuando está por declarar su amor a su compañera de clases, una luz cegadora de origen desconocido provoca que los seres humanos sin excepciones y las golondrinas se conviertan en piedra. Como consecuencia, la sociedad tal como la conocemos y la civilización se desmorona. Pasan miles de años y Taiju finalmente logra liberarse de la petrificación gracias a su amigo Senku el cual pudo liberarse medio año antes y gracias a eso, ahora sabe que están en el 5 de octubre del año 5738, 3700 años después de la petrificación de la raza humana. ",fecha));
        fecha.set(1999, 9, 21);
        lista_Anime.add(new Anime("Naruto: ", R.drawable.naruto_fondo_2, "Boruto Uzumaki (うずまきボルト, Uzumaki Boruto) es el protagonista del manga y anime Boruto: Naruto Next Generations. Es un habitante de Konohagakure miembro del Clan Uzumaki y descendiente directo del Clan Hyūga por parte materna, hijo del Séptimo Hokage, Naruto Uzumaki y Hinata Hyūga, así como el hermano mayor de Himawari Uzumaki. Actualmente es un Genin que forma parte del Equipo Konohamaru junto a Sarada Uchiha y Mitsuki. Aunque inicialmente tenía un resentimiento contra su padre por no pasar tiempo con su familia debido a su puesto como Hokage, Boruto eventualmente se reconcilió con él y lo empezó a respetar, tomando también la meta de volverse como su maestro, Sasuke Uchiha, un soporte para el Hokage y la aldea.",  fecha));


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