/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author camil
 */
public class ListaSkinPoseida {
     private int max;
    private int cantidadPersonajes;
    private Personaje[] lista;

    public ListaPersonajes(int max) {
        this.max = max;
        cantidadPersonajes = 0;
        lista = new Personaje[max];
    }


    public boolean ingresarPersonaje(Personaje personaje) {
        if (cantidadPersonajes < max) {
            lista[cantidadPersonajes] = personaje;
            cantidadPersonajes++;
            return true;
        } else {
            return false;
        }
    }

    public Personaje buscarPersonaje(String nomPersonaje) {
        int i = 0;
        while (i < cantidadPersonajes && !lista[i].getNomPersonaje().equals(nomPersonaje)) {
            i++;
        }
        if (i == cantidadPersonajes) {
            return null;
        } else {
            return lista[i];
        }
    }

    public int getCantidadPersonajes() {
        return cantidadPersonajes;
    }

    public Personaje getPersonajeI(int i) {
        if (i >= 0 && i < cantidadPersonajes) {
            return lista[i];
        } else {
            return null;
        }
    }

    public boolean eliminarPersonaje(String nomPersonaje) {

        int j;
        for (j = 0; j < cantidadPersonajes; j++) {
            if (lista[j].getNomPersonaje().equals(nomPersonaje)) {
                break;
            }
        }
        if (j == cantidadPersonajes) {
            return false;
        } else {
            for (int k = j; k < cantidadPersonajes - 1; k++) {
                lista[k] = lista[k + 1];
            }
            cantidadPersonajes--;
            return true;
        }
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public Personaje[] getLista() {
        return lista;
    }

    public void setLista(Personaje[] lista) {
        this.lista = lista;
    }

   }
