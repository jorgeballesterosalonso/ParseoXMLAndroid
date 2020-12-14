package com.example.xmlandroidjava;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class AccesoDatos {
    static Provinciero pr = null;
    static Municipiero mr = null;

    public static Provinciero pedirDatosXML(Actualizacion a) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://ovc.catastro.meh.es/ovcservweb/ovcswlocalizacionrc/")
                .addConverterFactory(SimpleXmlConverterFactory.create()).build();

        ServicioProvincia service = retrofit.create(ServicioProvincia.class);

        Call<Provinciero> llamada = service.getProvinciero();
        llamada.enqueue(new Callback<Provinciero>() {

            @Override
            public void onResponse(Call<Provinciero> call, Response<Provinciero> response) {
                pr = response.body();
                a.recuperarDatos(pr);
                // System.out.println(p);

            }

            @Override
            public void onFailure(Call<Provinciero> call, Throwable t) {
                System.out.println(t.getLocalizedMessage());
            }
        });
        return pr;
    }

    public static Municipiero pedirDatosXMLMuni(ActualizacionMuni a,String provincia) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://ovc.catastro.meh.es/ovcservweb/ovcswlocalizacionrc/")
                .addConverterFactory(SimpleXmlConverterFactory.create()).build();

        ServicioMunicipio service = retrofit.create(ServicioMunicipio.class);

        Call<Municipiero> llamada = service.getMunicipiero(provincia);
        llamada.enqueue(new Callback<Municipiero>() {

            @Override
            public void onResponse(Call<Municipiero> call, Response<Municipiero> response) {
                mr = response.body();
                Log.d("Mensaje",mr.toString());
                a.recuperarDatosMuni(mr);


            }

            @Override
            public void onFailure(Call<Municipiero> call, Throwable t) {
                System.out.println(t.getLocalizedMessage());
            }
        });
        return mr;
    }

}
