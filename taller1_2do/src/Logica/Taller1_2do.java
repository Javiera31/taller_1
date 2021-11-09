/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.Skin;
import Dominio.Personaje;

import java.io.IOException;
import java.util.*;
import java.io.*;
import java.util.Scanner;
import ucn.*;

/**
 *
 * @author camil
 */
public class Taller1_2do {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Interface sistema = new SystemImpl();
        leerPersonajes(sistema);
        leerClientes(sistema);
        leerEstadisticas(sistema);
        //ActualizarArchivos((SystemImpl) sistema);

        BufferedReader bf;
        bf = new BufferedReader(new InputStreamReader(System.in));

        Scanner scanner = new Scanner(System.in);
        int opcion2 = 0;
        int opcion1 = 0;
        int opcion = 0;
        String clave = null, nick = null;
        while (opcion != 2) {
            System.out.println("Bienvenido!");
            System.out.println("1-Iniciar Sesion");
            System.out.println("2-Salir del sistema");

            do {

                try {
                    System.out.println("");
                    System.out.println("Ingrese opcion: ");
                    opcion = Integer.parseInt(bf.readLine());
                    System.out.println("");

                } catch (Exception error) {
                    System.out.println("");
                    System.out.println("ERROR: El programa ha detectado inválido lo ingresado.");
                    System.out.println("");
                    opcion = 0;
                }
                if (opcion != 1 && opcion != 2) {
                    System.out.println("opcion ingresada no es valida");
                }
            } while (opcion < 1 || opcion > 2);
            switch (opcion) {

                case 1:
           
                    try {
                    System.out.println("ingrese nick: ");
                    nick = StdIn.readString();
                } catch (Exception error) {
                    System.out.println("El formato ingresado no es el correcto, vuelve a intentarlo.");

                }
                StdOut.print("Ingrese su clave: ");
                clave = StdIn.readString();

                //Menu administrador
                if (nick.equals("ADMIN") && clave.equals("ADMIN")) {
                    System.out.println("Bienvenido al Menu de ADMIN!");
                    System.out.println();

                    StdOut.println("1- Recaudado por Rol");
                    StdOut.println("2- Recaudado por Region");
                    StdOut.println("3- Recaudado por Personaje");
                    StdOut.println("4- Cantidad de Personajes por Rol");
                    StdOut.println("5- Agregar un personaje al juego");
                    StdOut.println("6- Agregar una skin al juego");
                    StdOut.println("7- Bloquear un jugador");
                    StdOut.println("8- Cuentas ordenadas");
                    StdOut.println("9- Salir del menu ADMIN");
                    System.out.println();
                    do {

                        try {
                            System.out.println("");
                            System.out.println("Ingrese opcion: ");
                            opcion = Integer.parseInt(bf.readLine());
                            System.out.println("");

                        } catch (Exception error) {
                            System.out.println("");
                            System.out.println("ERROR: El programa ha detectado inválido lo ingresado.");
                            System.out.println("");
                            opcion = 0;
                        }
                        if (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4 && opcion != 5 && opcion != 6 && opcion != 7 && opcion != 8 && opcion != 9) {
                            System.out.println("opcion ingresada no es valida");
                        }
                    } while (opcion < 1 || opcion > 9);

                    // para ingresar a las distintas opciones de menu admin
                    switch (opcion) {
                        case 1:
                            //FUNCIONA
                            System.out.println("");
                            System.out.println("INGRESANDO A RECAUDACION POR ROL");
                            System.out.println(sistema.obtenerRecaudacionRol());
                            System.out.println("");
                            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                            break;
                        case 2:

                            System.out.println("");
                            System.out.println("INGRESANDO A RECAUDACION POR REGION");
                            System.out.println(sistema.obtenerRecaudacionRegion());
                            System.out.println("");
                            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                            break;
                        case 3:
                            System.out.println("");
                            System.out.println("INGRESANDO A RECAUDACION POR PERSONAJE");
                            System.out.println(sistema.obtenerRecaudacionPersonaje());
                            System.out.println("");
                            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                            break;
                        case 4:
                            System.out.println("");
                            System.out.println("INGRESANDO A CANTIDAD DE PERSONAJES POR ROL");
                            System.out.println("");

                            System.out.println("");
                            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                            break;
                        case 5:
                            System.out.println("");
                            System.out.println("INGRESANDO AGREGAR UN PERSONAJE AL JUEGO");
                            System.out.println(sistema.agregarNuevoPersonaje());
                            System.out.println("");
                            System.out.println("");
                            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                            break;
                        case 6:
                            System.out.println("");
                            System.out.println("INGRESANDO AGREGAR SKIN AL JUEGO");
                            System.out.println(sistema.agregarNuevoSkin());
                            System.out.println("");
                            System.out.println("");
                            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                            break;
                        case 7:
                            System.out.println("");
                            System.out.println("INGRESAR A BLOQUEAR A JUGADOR");
                            String nickI = scanner.nextLine();
                            System.out.println(sistema.bloquearUsuario());
                            System.out.println("");
                            System.out.println("");
                            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                            break;
                        case 8:
                            System.out.println("");
                            System.out.println("INGRESAR A CUENTAS ORDENADAS");
                            System.out.println("");
                            System.out.println("");
                            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                            break;
                        case 9:
                            System.out.println("");
                            System.out.println("SALIENDO DEL MENU TRABAJADOR");
                            System.out.println("");
                            System.out.println("");
                            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                            break;

                    }
                } else if (!(nick.equals("ADMIN")) && !(clave.equals("ADMIN"))) {
                    System.out.println(sistema.BuscarUsuario(nick, clave));

                    while (sistema.BuscarUsuario(nick, clave) != false) {
                        System.out.println("Bienvenido al menu CLIENTE!");
                        System.out.println("");
                        System.out.println("");
                        StdOut.println("1-Comprar skin ");
                        StdOut.println("2-Comprar personaje");
                        StdOut.println("3-Ver skins disponibles");
                        StdOut.println("4-Mostrar inventario");
                        StdOut.println("5-Comprar rp");
                        StdOut.println("6-Mostrar datos personales ");
                        StdOut.println("7-Salir del menu cliente ");
                        do {

                            try {
                                System.out.println("");
                                System.out.println("Ingrese opcion: ");
                                opcion2 = Integer.parseInt(bf.readLine());
                                System.out.println("");

                            } catch (Exception error) {
                                System.out.println("");
                                System.out.println("ERROR: El programa ha detectado inválido lo ingresado.");
                                System.out.println("");
                                opcion2 = 0;
                            }
                            if (opcion2 != 1 && opcion2 != 2 && opcion2 != 3 && opcion2 != 4 && opcion2 != 5 && opcion2 != 6 && opcion2 != 7) {
                                System.out.println("opcion ingresada no es valida");
                            }
                        } while (opcion2 < 1 || opcion2 > 7);
                        switch (opcion2) {
                            case 1:
                                System.out.println("");
                                System.out.println("INGRESANDO A COMPRAR SKIN");
                                System.out.println("");
                                System.out.println(sistema.comprarSkin(nick));// FALTA ARREGLAR 
                                System.out.println("");
                                System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                                break;
                            case 2:
                                //FUNCIONA
                                System.out.println("");
                                System.out.println("INGRESANDO A COMPRAR PERSONAJE");
                                System.out.println(sistema.comprarPersonaje(nick));
                                System.out.println("");
                                System.out.println("");
                                System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                                break;
                            case 3:
                                System.out.println("");
                                System.out.println("INGRESANDO A VER SKINS DISPONIBLES");
                                System.out.println(sistema.mostrarSkins(nick));
                                System.out.println("");
                                System.out.println("");
                                System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                                break;

                            case 4:
                                //revisar por que no me imprime la lista completa de personajes y tambien por que no me imprime las skins
                                System.out.println("");
                                System.out.println("MOSTRAR INVENTARIO");
                                System.out.println(sistema.obtenerInventario(nick));
                                System.out.println("");
                                System.out.println("");
                                System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                                break;
                            case 5:
                                //FUNCIONA
                                System.out.println("");
                                System.out.println("COMPRAR RP");
                                System.out.println("ingrese la cantidad de rp que desea comprar: ");
                                int rp = scanner.nextInt();
                                System.out.println(sistema.RecargarRp(rp, nick));
                                System.out.println("");
                                System.out.println("");
                                System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                                break;
                            case 6:
                                //POR QUE NO ME IMPRIME LOS DATOS DEL CLIENTE
                                System.out.println("");
                                System.out.println("MOSTRAR DATOS DE CUENTA-CAMBIAR CLAVE");
                                System.out.println(sistema.obtenerDatosClientes(nick, clave));
                                System.out.println("");
                                System.out.println("");
                                System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                                break;

                            case 7:
                                System.out.println("");
                                System.out.println("SALIENDO DEL MENU CLIENTE....");

                                System.out.println("");
                                System.out.println("");
                                System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                                break;
                        }

                    }
                    while (sistema.BuscarUsuario(nick, clave) == false) {
                        System.out.println();
                        System.out.println("¿Desea crear una cuenta? 1)Si;2)No");
                        System.out.print("Ingrese una opcion: ");
                        opcion = StdIn.readInt();

                        if (opcion == 1) {
                            sistema.agregarNuevoUsuario();
                            System.out.println("");
                            System.out.println("");
                            break;
                        }

                        if (opcion1 > 2 || opcion1 < 1) {
                            System.out.println("Elija una opcion valida: ");
                            opcion = StdIn.readInt();
                            break;
                        }
                    }
                }

                case 2:
                    System.out.println();
                    System.out.println("¿Desea hacer algo mas? 1)Si;2)No");
                    System.out.print("Ingrese una opcion: ");
                    opcion = StdIn.readInt();

                    if (opcion == 1) {
                        System.out.println("Volviendo a menu principal");
                        System.out.println("");
                        System.out.println("");
                        break;
                    }

                    if (opcion1 > 2 || opcion1 < 1) {
                        System.out.println("Elija una opcion valida: ");
                        opcion = StdIn.readInt();
                        break;

                    }
            }
        }
    }

    public static void leerClientes(Interface sistema) throws IOException {
        ArchivoEntrada arch = new ArchivoEntrada("Cuentas.txt");
        while (!arch.isEndFile()) {
            Registro reg = arch.getRegistro();
            String nomCliente = reg.getString();
            String contrasena = reg.getString();
            String nick = reg.getString();
            int nivel = reg.getInt();
            int rp = reg.getInt();
            int cantPersonaje = reg.getInt();
            ListaPersonajes listaPersonajeP;
            listaPersonajeP = new ListaPersonajes(155);
            ListaSkins listaSkinP;
            listaSkinP = new ListaSkins(1000);

            if (cantPersonaje > 0) {
                for (int j = 0; j < cantPersonaje; j++) {
                    String nomPersonaje = reg.getString();
                    String rol = sistema.encontrado(nomPersonaje);

                    if (rol != "") {
                        int cantSkin = reg.getInt();

                        for (int i = 0; i < cantSkin; i++) {
                            String nomSkin = reg.getString();

                            listaSkinP = sistema.ingresarSkin(nomSkin, "calidad", listaSkinP);//las skin ya quedaron asociadas con la cuenta

                        }
                    }
                    Personaje personajeP = new Personaje(nomPersonaje, rol, listaSkinP);
                    listaPersonajeP.ingresarPersonaje(personajeP);
                }
            }
            String region = reg.getString();
            sistema.ingresarCliente(nomCliente, contrasena, nick, nivel, rp, listaPersonajeP, region);
        }
    }

    public static void leerPersonajes(Interface sistema) throws IOException {
        ArchivoEntrada arch = new ArchivoEntrada("Personajes.txt");
        while (!arch.isEndFile()) {
            Registro reg = arch.getRegistro();
            String nomPersonaje = reg.getString();
            String rol = reg.getString();
            int cantSkin = reg.getInt();
            ListaSkins listaSkin;
            listaSkin = new ListaSkins(1000);

            for (int i = 0; i < cantSkin; i++) {

                String nomSkin = reg.getString();
                String calidad = reg.getString();
                sistema.ingresarSkin(nomSkin, calidad, listaSkin);
            }
            sistema.ingresarPersonaje(nomPersonaje, rol, listaSkin);
        }

    }

    public static void leerEstadisticas(Interface sistema) throws IOException {
        ArchivoEntrada arch = new ArchivoEntrada("Estadisticas.txt");
        while (!arch.isEndFile()) {
            Registro reg = arch.getRegistro();
            String nomPersonaje = reg.getString();
            int recaudacion = reg.getInt();

            sistema.enviarRecaudacion(nomPersonaje, recaudacion);
        }
        //private static void ActualizarArchivos(SystemImpl sistema) throws IOException {
        //sistema.actualizarArchivos("Clientes.txt");
        //sistema.actualizarArchivos("Personajes.txt");

    }
