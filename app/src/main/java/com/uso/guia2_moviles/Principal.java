package com.uso.guia2_moviles;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;


public class Principal extends AppCompatActivity {

    private EditText txtURL;
    private EditText txtNuevoN;
    private TextView lblEstado;
    private Button btnDescargar;
    private RadioButton cbnombre;
    private RadioButton ncbnombre;
    private ProgressBar prgCargar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //inicializar
        txtURL       = (EditText) findViewById(R.id.txtURL);
        lblEstado    = (TextView) findViewById(R.id.lblEstado);
        btnDescargar = (Button)   findViewById(R.id.btnDescargar);
        cbnombre = (RadioButton) findViewById(R.id.cbnombre);
        ncbnombre = (RadioButton) findViewById(R.id.ncbnombre);
        prgCargar = (ProgressBar) findViewById(R.id.prgCargar);

        //evento onClick
        btnDescargar.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
         //  if(estaChequeado())
           //    txtNuevoN.visibility = true;
                   new Descargar(Principal.this, lblEstado, btnDescargar, prgCargar).execute(txtURL.getText().toString());
           //else{
             //  new Descargar(Principal.this, lblEstado, btnDescargar, prgCargar).execute(txtURL.getText().toString());

//            }
        }

    });

    verifyStoragePermissions(this);
}

    //esto es para activar perimiso de escritura y lectura en versiones de android 6 en adelante
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };


//persmission method.
public static void verifyStoragePermissions(Activity activity) {

        // Check if we have read or write permission
        int writePermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int readPermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (writePermission != PackageManager.PERMISSION_GRANTED || readPermission != PackageManager.PERMISSION_GRANTED) {

        // We don't have permission so prompt the user
        ActivityCompat.requestPermissions(activity,
        PERMISSIONS_STORAGE,
        REQUEST_EXTERNAL_STORAGE);
        }
     }

//obtener el Valor
/*    private int getValor() {
        if (cbnombre.isChecked()) {
            return 30;
        }
        if (ncbnombre.isChecked()) {
            return 60;
        }
        //default
        return 0;
    }

//Verificar si esta chequeado
    boolean estaChequeado() {
        if(cbnombre.isChecked() ||ncbnombre.isChecked()) return  true;
        else return false;
    }*/
}