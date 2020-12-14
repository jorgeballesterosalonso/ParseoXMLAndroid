package com.example.xmlandroidjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity implements Actualizacion, ActualizacionMuni {

    Spinner spinnerProvincias;
    Spinner spinnerMunicipios;
    MainActivity contexto;
    static Provinciero pr;
    static Municipiero mr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerProvincias = findViewById(R.id.spinnerProv);
        spinnerMunicipios = findViewById(R.id.spinnerMuni);

        contexto = this;
        AccesoDatos.pedirDatosXML(contexto);

        spinnerProvincias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AccesoDatos.pedirDatosXMLMuni(contexto,spinnerProvincias.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void recuperarDatos(Provinciero p) {
        pr = p;
        List<Provincia> pro = pr.getProvincias();
        Log.d("Mensaje", pro.toString());
        ArrayAdapter<Provincia> Adaptador = new ArrayAdapter<Provincia>(this, R.layout.support_simple_spinner_dropdown_item, pr.getProvincias());
        spinnerProvincias.setAdapter(Adaptador);
        Log.d("Mensaje", spinnerProvincias.getSelectedItem().toString());
        AccesoDatos.pedirDatosXMLMuni(contexto,spinnerProvincias.getSelectedItem().toString());



    }

    @Override
    public void recuperarDatosMuni(Municipiero m) {
        mr = m;
        List<Municipio> mro = mr.getMunicipios();
        Log.d("Mensaje", mro.toString());
        ArrayAdapter<Municipio> Adaptador2 = new ArrayAdapter<Municipio>(this, R.layout.support_simple_spinner_dropdown_item, mr.getMunicipios());
        spinnerMunicipios.setAdapter(Adaptador2);
    }


}