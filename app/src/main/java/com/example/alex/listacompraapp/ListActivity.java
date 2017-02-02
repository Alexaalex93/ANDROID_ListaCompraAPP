package com.example.alex.listacompraapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

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

        ListAdapter listAdapter = null;

        if(savedInstanceState == null) //Si esta vacio el nundle lo creo
             listAdapter = new Adapter(this, R.layout.celda, nombreProductos, descripcionProductos);
        else //Si no le meto el valor del array
        {
            boolean a [] = savedInstanceState.getBooleanArray("checked");
            listAdapter = new Adapter(this, R.layout.celda, nombreProductos, descripcionProductos,a );
        }




        ListView listView = (ListView) findViewById(R.id.listViewProductos);
        listView.setAdapter(listAdapter);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) { //Guardamos la lista de checked para poder usarlo al cambiar de orientacion
        outState.putBooleanArray("checked", Adapter.getChecked() ); //static
    }
}
