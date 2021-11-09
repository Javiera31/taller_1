/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Logica.ListaPersonajes;
import Logica.ListaSkins;

/**
 *
 * @author camil
 */
public class Personaje {

    private String nomPersonaje;
    private String rol;
    private int recaudacion;

    private ListaSkins listaSkins;

    public Personaje(String nomPersonaje, String rol, ListaSkins listaSkins) {
        this.nomPersonaje = nomPersonaje;
        this.rol = rol;
        this.recaudacion = 0;//
        this.listaSkins = listaSkins;

    }

    public String getNomPersonaje() {
        return nomPersonaje;
    }

    public void setNomPersonaje(String nomPersonaje) {
        this.nomPersonaje = nomPersonaje;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(int recaudacion) {
        this.recaudacion = recaudacion;
    }

    public ListaSkins getListaSkins() {
        return listaSkins;
    }

    public void setListaSkins(ListaSkins listaSkins) {
        this.listaSkins = listaSkins;
    }
    

}
