package com.technology.tech.examenandroid.interfaces;

import com.technology.tech.examenandroid.modelo.Cancha;
import com.technology.tech.examenandroid.modelo.ResponseCancha;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by usuario on 02-12-2017.
 */

public interface IService {
    //https://api.myjson.com/bins/16y5pf
    @GET("16y5pf")
    Call<Cancha> listarPartidos();

}
