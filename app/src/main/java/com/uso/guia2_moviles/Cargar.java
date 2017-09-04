package com.uso.guia2_moviles;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by admin on 25/8/17.
 */


public class Cargar extends AsyncTask<Integer, Integer, String> {

    Context context;
    ProgressBar barra;
    TextView lblValor;
    public Cargar(Context context,ProgressBar barra,TextView lblValor){
        this.context = context;
        this.barra   = barra;
        this.lblValor= lblValor;
    }

    @Override
    protected String doInBackground(Integer... params) {
        for(Integer contador=0;contador<=params[0];contador++){
            try {
                Thread.sleep(70);//milisegundos
                publishProgress(contador);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Tarea completada";
    }

    @Override
    protected void onPreExecute() {
        barra.setProgress(0);
        lblValor.setText("0%");
        super.onPreExecute();
    }
    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(context,"Tarea completada",Toast.LENGTH_SHORT).show();
        super.onPostExecute(s);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        barra.setProgress(values[0]);
        lblValor.setText(values[0]+"%");
        super.onProgressUpdate(values);
    }
}