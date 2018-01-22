package com.technology.tech.examenandroid.modelo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by usuario on 02-12-2017.
 */

public class ResponseCancha {
    private int id;
    @SerializedName("nombre_recinto")
    private String NombreRecinto;
    private String direccion;
    @SerializedName("tipo_cancha")
    private String tipoCancha;
    private String descripcion;
    @SerializedName("cantidad_canchas")
    private int cantidadCanchas;
    private String telefono;
    @SerializedName("url_sitio")
    private String urlSitio;
    @SerializedName("url_avatar")
    private String urlAvatar;
    @SerializedName("url_banner")
    private String urlBanner;

    public ResponseCancha(int id, String nombreRecinto, String direccion, String tipoCancha, String descripcion, int cantidadCanchas, String telefono, String urlSitio, String urlAvatar, String urlBanner) {
        this.id = id;
        NombreRecinto = nombreRecinto;
        this.direccion = direccion;
        this.tipoCancha = tipoCancha;
        this.descripcion = descripcion;
        this.cantidadCanchas = cantidadCanchas;
        this.telefono = telefono;
        this.urlSitio = urlSitio;
        this.urlAvatar = urlAvatar;
        this.urlBanner = urlBanner;
    }

    public ResponseCancha() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreRecinto() {
        return NombreRecinto;
    }

    public void setNombreRecinto(String nombreRecinto) {
        NombreRecinto = nombreRecinto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoCancha() {
        return tipoCancha;
    }

    public void setTipoCancha(String tipoCancha) {
        this.tipoCancha = tipoCancha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadCanchas() {
        return cantidadCanchas;
    }

    public void setCantidadCanchas(int cantidadCanchas) {
        this.cantidadCanchas = cantidadCanchas;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUrlSitio() {
        return urlSitio;
    }

    public void setUrlSitio(String urlSitio) {
        this.urlSitio = urlSitio;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public String getUrlBanner() {
        return urlBanner;
    }

    public void setUrlBanner(String urlBanner) {
        this.urlBanner = urlBanner;
    }
}
