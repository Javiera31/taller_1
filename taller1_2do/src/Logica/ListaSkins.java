/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.Skin;
import Dominio.Personaje;
/**
 *
 * @author camil
 */
public class ListaSkins {
    private int max;
    private int cantidadSkins;
    private Skin[] lista;

   

    public ListaSkins(int max) {
        this.max = max;
        cantidadSkins = 0;
        lista = new Skin[max];
        
    }


    public boolean ingresarSkin(Skin skin) {
        if (cantidadSkins < max) {
            lista[cantidadSkins] = skin;
            cantidadSkins++;
            return true;
        } else {
            return false;
        }
    }

    public Skin buscarSkin(String nomSkin) {
        int i = 0;
        while (i < cantidadSkins && !lista[i].getNomSkin().equals(nomSkin)) {
            i++;
        }
        if (i == cantidadSkins) {
            return null;
        } else {
            return lista[i];
        }
    }

    public int getCantidadSkins() {
        return cantidadSkins;
    }

    public Skin getSkinI(int i) {
        if (i >= 0 && i < cantidadSkins) {
            return lista[i];
        } else {
            return null;
        }
    }

    public boolean eliminarSkin(String nomSkin) {

        int j;
        for (j = 0; j < cantidadSkins; j++) {
            if (lista[j].getNomSkin().equals(nomSkin)) {
                break;
            }
        }
        if (j == cantidadSkins) {
            return false;
        } else {
            for (int k = j; k < cantidadSkins - 1; k++) {
                lista[k] = lista[k + 1];
            }
            cantidadSkins--;
            return true;
        }
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public Skin[] getLista() {
        return lista;
    }

    public void setLista(Skin[] lista) {
        this.lista = lista;
    }
    
    public String desplegarSkins() {
        String texto = "";
        for (int i = 0; i < cantidadSkins; i++) {
            texto += "Lista Skins: " + lista[i].getNomSkin()+ "\n" ;
        }
        return texto;
    }

    @Override
    public String toString() {
        return "ListaClientes{" + "max=" + max + ", cantidadClientes=" + cantidadSkins + ", lista=" + lista + '}';
    }

}

