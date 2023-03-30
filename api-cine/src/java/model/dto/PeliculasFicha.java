/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

import java.util.List;

/**
 *
 * @author S1-PC54
 */
public class PeliculasFicha {
    private int idPelicula;
    private String titulo;
    private String sinopsis;
    private String categoria;
    private String trailer;
    private int edadRecomendada;
    private double valoracion;
    private int duracion;
    private String imagen;
    private List<Salas> salas;

    public PeliculasFicha() {
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public int getEdadRecomendada() {
        return edadRecomendada;
    }

    public void setEdadRecomendada(int edadRecomendada) {
        this.edadRecomendada = edadRecomendada;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Salas> getSalas() {
        return salas;
    }

    public void setSalas(List<Salas> salas) {
        this.salas = salas;
    }

    @Override
    public String toString() {
        return "PeliculasFicha{" + "idPelicula=" + idPelicula + ", titulo=" + titulo + ", sinopsis=" + sinopsis + ", categoria=" + categoria + ", trailer=" + trailer + ", edadRecomendada=" + edadRecomendada + ", valoracion=" + valoracion + ", duracion=" + duracion + ", imagen=" + imagen + ", salas=" + salas + '}';
    }
    
    
}
