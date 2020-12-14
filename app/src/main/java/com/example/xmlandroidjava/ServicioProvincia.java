package com.example.xmlandroidjava;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicioProvincia {
    @GET("ovccallejero.asmx/ConsultaProvincia")
    Call<Provinciero> getProvinciero();

}
