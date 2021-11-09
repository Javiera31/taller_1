/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.Cliente;

/**
 *
 * @author camil
 */
public class ListaClientes {

    private int max;
    private int cantidadClientes;
    private Cliente[] lista;

    public ListaClientes(int max) {
        this.max = max;
        cantidadClientes = 0;
        lista = new Cliente[max];
    }


    public boolean ingresarCliente(Cliente cliente) {
        if (cantidadClientes < max) {
            lista[cantidadClientes] = cliente;
            cantidadClientes++;
            return true;
        } else {
            return false;
        }
    }

    public Cliente buscarClave(String contrasena) {
        int i = 0;
        while (i < cantidadClientes && !lista[i].getContrasena().equals(contrasena)) {
            i++;
        }
        if (i == cantidadClientes) {
            return null;
        } else {
            return lista[i];
        }
    } 
    public Cliente buscarCliente(String nick) {
        int i = 0;
        while (i < cantidadClientes && !lista[i].getNick().equals(nick)) {
            i++;
        }
        if (i == cantidadClientes) {
            return null;
        } else {
            return lista[i];
        }
    }

    public int getCantidadClientes() {
        return cantidadClientes;
    }

    public Cliente getClienteI(int i) {
        if (i >= 0 && i < cantidadClientes) {
            return lista[i];
        } else {
            return null;
        }
    }

    public boolean eliminarCliente(String Nick) {

        int j;
        for (j = 0; j < cantidadClientes; j++) {
            if (lista[j].getNick().equals(Nick)) {
                break;
            }
        }
        if (j == cantidadClientes) {
            return false;
        } else {
            for (int k = j; k < cantidadClientes - 1; k++) {
                lista[k] = lista[k + 1];
            }
            cantidadClientes--;
            return true;
        }
    }
 
    public Cliente[] getListaC() {
		return lista;
	}

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public Cliente[] getLista() {
        return lista;
    }

    public void setLista(Cliente[] lista) {
        this.lista = lista;
    }
public void setListaC(Cliente[] lista) {
		this.lista = lista;
	}
    @Override
    public String toString() {
        return "ListaClientes{" + "max=" + max + ", cantidadClientes=" + cantidadClientes + ", lista=" + lista + '}';
    }

}
