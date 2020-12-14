package com.example.xmlandroidjava;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServicioMunicipio {
    @GET("ovccallejero.asmx/ConsultaMunicipio?&Municipio=")
    Call<Municipiero> getMunicipiero(@Query("Provincia") String prov);
}
