/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.IOException;

/**
 *
 * @author camil
 */
public interface Interface {

    public boolean ingresarCliente(String nomCliente, String contrasena, String nick, int nivel, int rp, ListaPersonajes listaPersonajeP, String region);

    public ListaSkins ingresarSkin(String nomSkin, String calidad, ListaSkins listaSkin);

    public boolean ingresarPersonaje(String nomPersonaje, String rol, ListaSkins listaSkin);

    public String encontrado(String nombre);

    public boolean BuscarUsuario(String nick, String contrasenaI);

    public boolean agregarNuevoUsuario();

    public String obtenerDatosClientes(String nick, String contrasena);

    public boolean RecargarRp(int rp, String nick);

    public String obtenerInventario(String nick);

    public boolean comprarPersonaje(String nick);

    public boolean comprarSkin(String nick);

    public String obtenerRecaudacionRol();

    public String obtenerRecaudacionPersonaje();

    public boolean agregarNuevoPersonaje();

    public String mostrarSkins(String nick);

    public String bloquearUsuario();

    public void actualizarArchivos(String nombreArchivo) throws IOException;

    public boolean agregarNuevoSkin();

    public void enviarRecaudacion(String nomPersonaje, int recaudacion);
    public String obtenerRecaudacionRegion();
}
