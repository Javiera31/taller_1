/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Logica.ListaClientes;
import Logica.ListaPersonajes;

/**
 *
 * @author camil
 */
public class Cliente {

    private String nomCliente;
    private String contrasena;
    private String nick;
    private int nivel;
    private int rp;
    private String region;
    boolean bloqueado;
    private ListaPersonajes listaPersonajeP;
    
    

    public Cliente(String nomCliente, String contrasena, String nick, int nivel, int rp,ListaPersonajes listaPersonajeP, String region) {
        this.nomCliente = nomCliente;
        this.contrasena = contrasena;
        this.nick = nick;
        this.nivel = nivel;
        this.rp = rp;
        this.bloqueado=false;
        this.region = region;
        this.listaPersonajeP=listaPersonajeP;
       
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getRp() {
        return rp;
    }

    public void setRp(int rp) {
        this.rp = rp;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public ListaPersonajes getListaPersonajeP() {
        return listaPersonajeP;
    }

    public void setListaPersonajeP(ListaPersonajes listaPersonajeP) {
        this.listaPersonajeP = listaPersonajeP;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

 

}
