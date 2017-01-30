package com.example.alex.listacompraapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {


    private int[] checked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        String[] nombreProductos = new String[] {

                "Tomates",
                "Manzanas",
                "Lechuga",
                "Patatas",
                "Cebolla",
                "Zanahorias",
                "Pimientos",
                "Coliflor",
                "Pepinillos",
                "Salsa César",
                "Galletas",
                "Cereales",
                "Colacao",
                "Nesquick",
                "Café",
                "Bombones",
                "Pollo",
                "Queso",
                "Yogures",
                "Ajo"

        };

        String[] descripcionProductos = new String[] {

                "Tomates1",
                "Manzanas1",
                "Lechuga1",
                "Patatas1",
                "Cebolla1",
                "Zanahorias1",
                "Pimientos1",
                "Coliflor1",
                "Pepinillos1",
                "Salsa César1",
                "Galletas1",
                "Cereales1",
                "Colacao1",
                "Nesquick1",
                "Café1",
                "Bombones1",
                "Pollo1",
                "Queso1",
                "Yogures1",
                "Ajo1"

        };


        ListAdapter listAdapter = new Adapter(this, R.layout.celda, nombreProductos, descripcionProductos);


        ListView listView = (ListView) findViewById(R.id.listViewProductos);
        listView.setAdapter(listAdapter);

     //   checked = new int[nombreProductos.length];
     //   CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(Menu.NONE,8,8,"Lista seleccionados");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return super.onOptionsItemSelected(item);
    }
}
