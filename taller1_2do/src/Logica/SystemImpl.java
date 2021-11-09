/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.Cliente;
import Dominio.Personaje;
import Dominio.PersonajePoseido;
import Dominio.Skin;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import ucn.StdIn;

/**
 *
 * @author camil
 */
public class SystemImpl implements Interface {

    private final ListaClientes listaclientes;
    private final ListaPersonajes listapersonajes;

    /**
     * The contructor of the class SystemImpl
     */
    public SystemImpl() {
        listaclientes = new ListaClientes(1000);
        listapersonajes = new ListaPersonajes(155);

    }

    /**
     * This method is used to enter a user into the system
     *
     * @param nomCliente
     * @param contrasena
     * @param nick
     * @param nivel
     * @param rp
     * @param listaPersonajeP
     * @param region
     * @return if the object is entered or not to the system
     */
    @Override
    public boolean ingresarCliente(String nomCliente, String contrasena, String nick, int nivel, int rp, ListaPersonajes listaPersonajeP, String region) {
        Cliente cliente = new Cliente(nomCliente, contrasena, nick, nivel, rp, listaPersonajeP, region);
        boolean ingreso = listaclientes.ingresarCliente(cliente);
        return ingreso;

    }

    //aca se esta creando la skin y se esta agregando a la lista app, este es de la lista general 
    /**
     * This method is used to enter a skin into the system
     *
     * @param nomSkin
     * @param calidad
     * @param listaSkin
     * @return if the object is entered or not to the system
     */
    @Override
    public ListaSkins ingresarSkin(String nomSkin, String calidad, ListaSkins listaSkin) {
        Skin skin = new Skin(nomSkin, calidad);
        listaSkin.ingresarSkin(skin);
        return listaSkin;

    }

    public void enviarRecaudacion(String nomPersonaje, int recaudacion) {
        Personaje personaje = listapersonajes.buscarPersonaje(nomPersonaje);
        if (personaje != null) {
            personaje.setRecaudacion(recaudacion);
        }

    }

    /**
     * This method is used to enter a skin(user) into the system
     *
     * @param nomSkin
     * @param calidad
     * @param listaSkin
     * @return if the object is entered or not to the system
     */
    public ListaSkins ingresarSkinP(String nomSkin, String calidad, ListaSkins listaSkin) {
        Skin skin = new Skin(nomSkin, calidad);
        listaSkin.ingresarSkin(skin);
        return listaSkin;

    }

    /**
     * This method is used to enter a champ into the system
     *
     * @param nomPersonaje
     * @param rol
     * @param listaSkin
     * @return if the object is entered or not to the system
     */
    @Override
    public boolean ingresarPersonaje(String nomPersonaje, String rol, ListaSkins listaSkin) {
        Personaje personaje = new Personaje(nomPersonaje, rol, listaSkin);
        boolean ingreso = listapersonajes.ingresarPersonaje(personaje);

        return ingreso;
    }

    /**
     * This method is used to find a champ
     *
     * @param nombre
     * @return
     *
     */
    @Override
    public String encontrado(String nombre) {
        String salida = "";
        Personaje personaje = listapersonajes.buscarPersonaje(nombre);
        if (personaje != null) {
            salida = personaje.getRol();
        }
        return salida;
    }

//ARREGLAR LISTA PERSONAJES
    public boolean asociarPersonajeCuenta(String nomCuenta, String nomPersonaje, String rol, ListaSkins listaskins) {
        Personaje personaje = listapersonajes.buscarPersonaje(nomPersonaje);
        Cliente cliente = listaclientes.buscarCliente(nomCuenta);
        if (cliente != null && personaje != null) {
            Personaje PP = new Personaje(nomPersonaje, rol, listaskins);
            cliente.getListaPersonajeP().ingresarPersonaje(PP);
            return true;
        } else {
            throw new NullPointerException("El cliente y/o el dentista no se encuentra en el sistema");
        }
    }

    /**
     * this method is used to find a user
     *
     * @param nick
     * @param contrasenaI
     * @return user founded
     */
    @Override
    public boolean BuscarUsuario(String nick, String contrasenaI) {
        String salida = "";
        Cliente cliente = listaclientes.buscarCliente(nick);
        Cliente clave = listaclientes.buscarClave(contrasenaI);
        if (cliente != null && clave != null) {
            if (cliente.getNick().equals(nick) && cliente.getContrasena().equals(contrasenaI)) {
                System.out.println("Sesion Ingresada con exito");
            }
            return true;
        } else {
            System.out.println("Usuario no encontrado");
        }
        return false;

    }

    /**
     * This method is used to enter a skin into the system
     *
     * @return
     */
    @Override
    public boolean agregarNuevoUsuario() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese nick para confirmar si se encuentra disponible: ");
        String nick = sc.nextLine();
        Cliente c = listaclientes.buscarCliente(nick);
        if (c == null) {
            System.out.println("Ingrese los datos del nuevo usuario: ");
            System.out.print(" -Nombre: ");
            String nombre = sc.nextLine();
            System.out.print(" -Clave: ");
            String clave = sc.nextLine();
            System.out.print(" -Nick: ");
            String nuevoNick = sc.nextLine();
            System.out.print(" -Region: ");
            String region = sc.nextLine();
            int nivel = 0;
            int rp = 0;
            ListaPersonajes listapersonajesp = null;
            Cliente CN = new Cliente(nombre, clave, nuevoNick, rp, nivel, listapersonajesp, region);
            listaclientes.ingresarCliente(CN);
            System.out.println("Usuario ingresado");
            return true;
        } else {
            throw new NullPointerException("No es posible ingresar el nuevo usuario ya que el nick se encuentra disponible");
        }
    }

    /**
     * this method is used to buy rp
     *
     * @param rp
     * @param nick
     * @return rp buyed
     */
    @Override
    public boolean RecargarRp(int rp, String nick) {
        Cliente c = listaclientes.buscarCliente(nick);
        if (c.getNick().equals(nick)) {
            c.setRp(c.getRp() + rp);
            System.out.println("compra realizada con exito");
            return true;
        } else {
            throw new NullPointerException("no existe el nick");
        }
    }

    /**
     * this method get customer data
     *
     * @param nick
     * @param contrasena
     * @return
     */
    @Override
    public String obtenerDatosClientes(String nick, String contrasena) {
        String salida = "";
        Cliente cliente = listaclientes.buscarCliente(nick);
        if (cliente != null) {

            Scanner scanner = new Scanner(System.in);
            BufferedReader bf;
            bf = new BufferedReader(new InputStreamReader(System.in));
            int opcion = 0;
            int opcion1 = 0;
            salida = salida + "OBTENIENDO DATOS:\n" + "\n nombre=" + cliente.getNomCliente() + "\n nick=" + cliente.getNick() + "\n contrasena=" + cliente.getContrasena();
            System.out.println(salida);
            System.out.println("desea cambiar contrasena?");

            System.out.println("1-Si");
            System.out.println("2-No");
            do {
                try {
                    System.out.println("");
                    System.out.println("Ingrese opcion: ");
                    opcion = Integer.parseInt(bf.readLine());
                    System.out.println("");

                } catch (IOException | NumberFormatException error) {
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
                    String var = "";
                    System.out.println("ingrese contraseña: ");
                    String contraseña = scanner.nextLine();
                    if (cliente.getContrasena().equals(contrasena)) {
                        System.out.println("Ingrese su contraseña nueva: ");
                        String nuevaC = scanner.nextLine();
                        System.out.println("Ingrese nuevamente su contraseña nueva: ");
                        String nuevaConf = scanner.nextLine();
                        if (!nuevaC.equals(nuevaConf)) {
                            while (var != null) {
                                System.out.println("Las contraseñas no coinciden");
                                System.out.println("Ingrese su contraseña nueva: ");
                                nuevaC = scanner.nextLine();
                                System.out.println("Ingrese nuevamente su contraseña nueva: ");
                                nuevaConf = scanner.nextLine();
                                if (nuevaC.equals(nuevaConf)) {
                                    var = var + "Clave cambiada con exito ";
                                }
                            }
                        }

                    }
                    return var;

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
        return salida;
    }

    //funcion lista
    /**
     * get customer inventory
     *
     * @param nick
     * @return
     */
    @Override
    public String obtenerInventario(String nick) {

        String salida = "";
        Cliente cliente = listaclientes.buscarCliente(nick);
        ListaPersonajes listaposeidos = cliente.getListaPersonajeP();
        for (int i = 0; i < listaposeidos.getCantidadPersonajes(); i++) {
            salida = salida + listaposeidos.getPersonajeI(i).getNomPersonaje();
            Personaje personaje = listaposeidos.getPersonajeI(i);
            ListaSkins listaskinsP = personaje.getListaSkins();
            for (int j = 0; j < listaskinsP.getCantidadSkins(); j++) {
                salida = salida + listaskinsP.getSkinI(j).getNomSkin();
            }
        }
        return salida;
    }

    public boolean comprarPersonaje(String nick) {
        Scanner sc = new Scanner(System.in);
        BufferedReader bf;
        bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < listapersonajes.getCantidadPersonajes(); i++) {
            System.out.println(listapersonajes.getPersonajeI(i).getNomPersonaje());
        }
        System.out.println("-------------------------------------------");
        System.out.print("Seleccione un personaje:");
        String personajeI = sc.nextLine();
        Personaje personaje = listapersonajes.buscarPersonaje(personajeI);
        Cliente c = listaclientes.buscarCliente(nick);
        for (int j = 0; j < c.getListaPersonajeP().getCantidadPersonajes(); j++) {
            Personaje personajeP = c.getListaPersonajeP().getPersonajeI(j);
            if (c.getRp() < 975) {
                int opcion = 0;
                System.out.println("no posee saldo suficiente en su cuenta");
                System.out.println("ingrese cuantos rp desea comprar");
                int rp = sc.nextInt();
                Cliente cl = listaclientes.buscarCliente(nick);
                if (cl.getNick().equals(nick)) {
                    c.setRp(c.getRp() + rp);
                    System.out.println("compra realizada con exito");
                    return true;
                } else {
                    throw new NullPointerException("no existe el nick");
                }

            } else {
                int pago = 0;
                pago = (int) (975);
                int nivel = c.getNivel() + 1;

                System.out.println("Valor a pagar: $" + pago);
                int sumaTotal = listaclientes.buscarCliente(nick).getRp() - pago;
                c.setRp(sumaTotal);
                c.setNivel(nivel);
                personaje.setRecaudacion(personaje.getRecaudacion() + 975);
                c.getListaPersonajeP().ingresarPersonaje(personaje);//falta revisar si el personaje comprado queda guardado en la lista de personajes poseidos del cliente
                System.out.println("--------------------------------");
                System.out.println("Pago realizado con éxito");
                return true;
            }
        }

        throw new NullPointerException("El personaje ingresado no existe");

    }

    /**
     *
     * @param nick
     * @return
     */
    @Override
    public String mostrarSkins(String nick) {
        String salida = "";
        Cliente cl = listaclientes.buscarCliente(nick);
        ListaPersonajes listapersonajeP = cl.getListaPersonajeP();//es uno a la vez
        ListaSkins listaskinP;
        int k;
        for (int i = 0; i < listapersonajes.getCantidadPersonajes(); i++) {

            Personaje personaje = listapersonajes.getPersonajeI(i);//es uno a la vez
            ListaSkins listaskin = personaje.getListaSkins();
            for (int j = 0; j < listaskin.getCantidadSkins(); j++) {
                boolean encontrado = true;
                for (k = 0; k < listapersonajeP.getCantidadPersonajes(); k++) {
                    Personaje personajeP = listapersonajeP.getPersonajeI(i);//es uno a la vez
                    listaskinP = personajeP.getListaSkins();
                    if (listaskin.getSkinI(j).getNomSkin().equals(listaskinP.getSkinI(k).getNomSkin())) {
                        encontrado = false;
                    }

                    if (encontrado) {
                        salida = salida + listaskin.getSkinI(i).getNomSkin();
                        encontrado = true;
                    }
                }
            }
        }
        return salida;
    }

    /*
    public boolean comprarSkin(String nick) {
        Scanner sc = new Scanner(System.in);
        BufferedReader bf;
        bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < listaskins.getCantidadSkins(); i++) {
            Skin skin = listaskins.getSkinI(i);
            System.out.println(listaskins.getSkinI(i).getNomSkin());
        }
        System.out.println("-------------------------------------------");
        System.out.print("Seleccione un personaje:");
        String personajeI = sc.nextLine();
        Cliente c = listaclientes.buscarCliente(nick);
        for (int j = 0; j < c.getListaPersonajeP().getCantidadPersonajes(); j++) {
            Personaje personajeP = c.getListaPersonajeP().getPersonajeI(j);
            if (c.getListaPersonajeP().equals(personajeI)) {
                throw new NullPointerException("No hay personajes disponibles para comprar");
            }
            if (c.getRp() < 975) {
                int opcion = 0;
                System.out.println("no posee saldo suficiente en su cuenta");
                System.out.println("ingrese cuantos rp desea comprar");
                int rp = sc.nextInt();
                Cliente cl = listaclientes.buscarCliente(nick);
                if (cl.getNick().equals(nick)) {
                    c.setRp(c.getRp() + rp);
                    System.out.println("compra realizada con exito");
                    return true;
                } else {
                    throw new NullPointerException("no existe el nick");
                }

            } else {
                int pago = 0;
                pago = (int) (975);
                System.out.println("Valor a pagar: $" + pago);
                int sumaTotal = listaclientes.buscarCliente(nick).getRp() - pago;
                listaclientes.buscarCliente(c.getNick()).setRp(sumaTotal);
                listaclientes.buscarCliente(c.getNick()).getListaPersonajeP().ingresarPersonaje(personajeP);//falta revisar si el personaje comprado queda guardado en la lista de personajes poseidos del cliente
                System.out.println("--------------------------------");
                System.out.println("Pago realizado con éxito");
                return true;
            }
        }

        throw new NullPointerException("El personaje ingresado no existe");

    }
     */
    public String obtenerRecaudacionRol() {
        String salida = "";
        int GananciaADC = 0;
        int GananciaMID = 0;
        int GananciaTOP = 0;
        int GananciaJG = 0;
        int GananciaSUP = 0;

        for (int i = 0; i < listapersonajes.getCantidadPersonajes(); i++) {
            Personaje p = listapersonajes.getPersonajeI(i);
            String rol = p.getRol();
            if (rol.equals("ADC")) {
                GananciaADC += GananciaADC + p.getRecaudacion();
            }
            if (rol.equals("MID")) {
                GananciaMID += GananciaMID + p.getRecaudacion();
            }
            if (rol.equals("TOP")) {
                GananciaTOP += GananciaTOP + p.getRecaudacion();
            }
            if (rol.equals("JG")) {
                GananciaJG += GananciaJG + p.getRecaudacion();
            }
            if (rol.equals("SUP")) {
                GananciaSUP += GananciaSUP + p.getRecaudacion();
            }

        }
        salida += "\n ADC= " + GananciaADC + "\n MID= " + GananciaMID + " \nTOP= " + GananciaTOP + " \nJG= " + GananciaJG + " \nSUP= " + GananciaSUP;
        return salida;
    }

    public String obtenerRecaudacionRegion() {
        String salida = "";
        int GananciaLAS = 0;
        int GananciaLAN = 0;
        int GananciaEUW = 0;
        int GananciaKR = 0;
        int GananciaNA = 0;
        int GananciaRU = 0;

        for (int i = 0; i < listaclientes.getCantidadClientes(); i++) {
            Cliente c = listaclientes.getClienteI(i);
            for (int j = 0; j < listapersonajes.getCantidadPersonajes(); j++) {
                Personaje p = listapersonajes.getPersonajeI(i);
                String region = c.getRegion();
                if (region.equals("LAS")) {
                    GananciaLAS += GananciaLAS + p.getRecaudacion();
                }
                if (region.equals("LAN")) {
                    GananciaLAN += GananciaLAN + p.getRecaudacion();
                }
                if (region.equals("EUW")) {
                    GananciaEUW += GananciaEUW + p.getRecaudacion();
                }
                if (region.equals("KR")) {
                    GananciaKR += GananciaKR + p.getRecaudacion();
                }
                if (region.equals("NA")) {
                    GananciaNA += GananciaNA + p.getRecaudacion();
                }
                if (region.equals("RU")) {
                    GananciaRU += GananciaRU + p.getRecaudacion();
                }

            }
           
        }
         salida += "\n LAS= " + GananciaLAS + "\n LAN= " + GananciaLAN + " \nEUW= " + GananciaEUW + " \nKR= " + GananciaKR + " \nNA= " + GananciaNA + " \nRU= " + GananciaRU;
            return salida;
    }
      
    
    public String obtenerRecaudacionPersonaje(){
         String salida = "";
            int ganancias = 0;
            for (int i = 0; i < listapersonajes.getCantidadPersonajes(); i++) {
               Personaje p = listapersonajes.getPersonajeI(i);
                ganancias = ganancias + p.getRecaudacion();
                salida += "Personaje : " + p.getNomPersonaje() + "Ganancias :" + ganancias;

            }
            return salida;

        }
        //revisar para agregar un nuevo personaje y skin

        /**
         *
         * @return
         */
    public boolean agregarNuevoPersonaje() {
        Scanner sc = new Scanner(System.in);
        ListaSkins listaskins = new ListaSkins(1000);
        System.out.println("Ingrese el nuevo personaje: ");
        String nombreI = sc.nextLine();
        Personaje p = listapersonajes.buscarPersonaje(nombreI);
        if (p == null) {
            System.out.println("Ingrese los datos del nuevo personaje: ");
            System.out.println(" -Nombre: ");
            String nombre = sc.nextLine();
            System.out.println(" -Rol: ");
            String rol = sc.nextLine();
            System.out.println(" -Ingrese cantidad de skins a agregar: ");
            int cantSkin = sc.nextInt();
            for (int i = 0; i < cantSkin; i++) {
                System.out.println("  ");
                String prueba = sc.nextLine();
                System.out.println("-Ingrese nombre skin : ");
                String nomskin = sc.nextLine();
                System.out.println("-Ingrese calidad : ");
                String calidad = sc.nextLine();
                Skin SK = new Skin(nomskin, calidad);
                listaskins.ingresarSkin(SK);

            }
            Personaje PN = new Personaje(nombre, rol, listaskins);
            listapersonajes.ingresarPersonaje(PN);
            System.out.println("Personaje Ingresado");
            return true;

        } else {
            throw new NullPointerException("No es posible ingresar el nuevo personaje ya que el nombre se encuentra disponible");
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String bloquearUsuario() {
        @SuppressWarnings("resource")
        String salida = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Usuarios: ");
        for (int i = 0; i < listaclientes.getCantidadClientes(); i++) {
            {
                System.out.println("-" + listaclientes.getClienteI(i).getNick());
            }
        }
        System.out.println("-------------------------------------------");
        System.out.print("Seleccione usuario para ser bloqueado: ");
        String usuarioI = sc.nextLine();
        Cliente c = listaclientes.buscarCliente(usuarioI);
        for (int j = 0; j < c.getListaPersonajeP().getCantidadPersonajes(); j++) {
            Personaje p = c.getListaPersonajeP().getPersonajeI(j);
            for (int k = 0; k < p.getListaSkins().getCantidadSkins(); k++) {
                Skin s = p.getListaSkins().getSkinI(k);

                listaclientes.eliminarCliente(usuarioI);
            }
            p.setListaSkins(null);
        }
        c.setListaPersonajeP(null);
        salida = salida + "Usuario eliminado con exito";
        return salida;
    }

    @Override
    /*  public void actualizarArchivos(String nombreArchivo) throws IOException {
        String nombreA = nombreArchivo;
        if (nombreA.equals("Clientes.txt")) {
            FileWriter file1 = new FileWriter(nombreA);
            PrintWriter escritura1 = new PrintWriter(file1);
            for (int i = 0; i < listaclientes.getCantidadClientes(); i++) {
                Cliente c = listaclientes.getClienteI(i);
                for (int j = 0; j < listapersonajes.getCantidadPersonajes(); j++) {
                    Personaje p = listapersonajes.getPersonajeI(i);
                    escritura1.println(c.getNomCliente() + "," + c.getContrasena() + "," + c.getNick() + "," + c.getNivel() + "," + c.getRp() + "," + c.getRegion());
                }
                file1.close();
            }
        } else {
            if (nombreA.equals("Personajes.txt")) {
                FileWriter file2 = new FileWriter(nombreA);
                PrintWriter escritura2 = new PrintWriter(file2);
                for (int i = 0; i < listapersonajes.getCantidadPersonajes(); i++) {
                    Personaje p = listapersonajes.getPersonajeI(i);
                    escritura2.println(p.getNomPersonaje() + "," + p.getRol() + "," + p.getRecaudacion() + "," + p.getListaSkins());
                }
                file2.close();
            }

        }

    }*/

    public boolean agregarNuevoSkin() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del personaje al cual se le agregara la skin: ");
        String nombreI = sc.nextLine();
        Personaje p = listapersonajes.buscarPersonaje(nombreI);
        if (p.getNomPersonaje().equals(nombreI)) {
            System.out.println("Ingrese el nombre de la nueva skin: ");
            System.out.print(" -Nombre Skin: ");
            String nombreSkin = sc.nextLine();
            System.out.print(" -Calidad: ");
            String calidad = sc.nextLine();

            Skin NK = new Skin(nombreSkin, calidad);
            p.getListaSkins().ingresarSkin(NK);
            System.out.println("Skin Ingresada");
            return true;
        } else {
            throw new NullPointerException("No es posible ingresar la nueva skin ");
        }
    }

    public int obtenerRegion() {

    }
}
