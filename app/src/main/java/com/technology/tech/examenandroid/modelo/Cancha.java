package com.technology.tech.examenandroid.modelo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by usuario on 02-12-2017.
 */

public class Cancha {
    @SerializedName("canchas")
    private ResponseCancha[] response;

    public Cancha(ResponseCancha[] response) {
        this.response = response;
    }

    public Cancha() {
    }

    public ResponseCancha[] getResponse() {
        return response;
    }

    public void setResponse(ResponseCancha[] response) {
        this.response = response;
    }
}
