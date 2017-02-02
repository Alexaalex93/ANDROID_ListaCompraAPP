package com.example.alex.listacompraapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

/**
 * Created by Alex on 30/01/2017.
 */

public class Adapter extends BaseAdapter{

    private Context mContext;
    private int mIdLayoutCelda;
    private String[] mNombreProductos;
    private String[] mDescripcionProductos;
    private static boolean[] checked;

    public Adapter(Context mContext, int mIdLayoutCelda, String[] mNombreProductos, String[] mDescripcionProductos) {
        this.mContext = mContext;
        this.mIdLayoutCelda = mIdLayoutCelda;
        this.mNombreProductos = mNombreProductos;
        this.mDescripcionProductos = mDescripcionProductos;
        checked = new boolean[mNombreProductos.length];
        Arrays.fill(checked, Boolean.FALSE);
    }
    public Adapter(Context mContext, int mIdLayoutCelda, String[] mNombreProductos, String[] mDescripcionProductos, boolean[] checked){

        this.mContext = mContext;
        this.mIdLayoutCelda = mIdLayoutCelda;
        this.mNombreProductos = mNombreProductos;
        this.mDescripcionProductos = mDescripcionProductos;
        this.checked = checked;

    }

    int getResult(boolean... checked) {
        int count = 0;
        for (boolean check : checked) {
            count += (check ? 1 : 0);
        }

        return count;
    }

    public static boolean[] getChecked() {
        return checked;
    }

    @Override
    public int getCount() {
        return mNombreProductos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) { //Aquí meter la imagen tambien

        if( convertView == null){ //Si es la primera vez que se muestra

            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(mIdLayoutCelda, null);

        }
        final CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);
        checkBox.setChecked(checked[position]);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checked[position] = ((CheckBox) view).isChecked(); //Devuelve boolean
                int a = getResult(checked);
                System.out.println(a);

            }
        });


        TextView textView_NombreProductos = (TextView) convertView.findViewById(R.id.nombreProductoText);
        TextView textView_DescripcionProductos = (TextView) convertView.findViewById(R.id.descripcionProductoText);

        textView_NombreProductos.setText(mNombreProductos[position]);
        textView_DescripcionProductos.setText(mDescripcionProductos[position]);

        return convertView;
    }
}
