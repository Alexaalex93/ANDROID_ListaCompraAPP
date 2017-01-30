package com.example.alex.listacompraapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Arrays;

/**
 * Created by Alex on 30/01/2017.
 */

public class Adapter extends BaseAdapter{

    private Context mContext;
    private int mIdLayoutCelda;
    private String[] mNombreProductos;
    private String[] mDescripcionProductos;
    private Boolean[] checked;

    public Adapter(Context mContext, int mIdLayoutCelda, String[] mNombreProductos, String[] mDescripcionProductos) {
        this.mContext = mContext;
        this.mIdLayoutCelda = mIdLayoutCelda;
        this.mNombreProductos = mNombreProductos;
        this.mDescripcionProductos = mDescripcionProductos;
        checked = new Boolean[mNombreProductos.length];
        Arrays.fill(checked, Boolean.FALSE);
    }

    public Boolean[] getChecked() {
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
    public View getView(int position, View convertView, ViewGroup parent) {

        if( convertView == null){ //Si es la primera vez que se muestra

            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(mIdLayoutCelda, null);

        }
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);

        if(checkBox.isChecked()){
            checked[position] = true;
        }
        else{
            checked[position] = false;
        }

        TextView textView_NombreProductos = (TextView) convertView.findViewById(R.id.nombreProductoText);
        TextView textView_DescripcionProductos = (TextView) convertView.findViewById(R.id.descripcionProductoText);

        textView_NombreProductos.setText(mNombreProductos[position]);
        textView_DescripcionProductos.setText(mDescripcionProductos[position]);

        return convertView;
    }
}
