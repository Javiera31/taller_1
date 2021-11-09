/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;
import Logica.ListaSkins;
/**
 *
 * @author camil
 */
/*existen 5 calidades de skins con sus respectivos precios:
• Mítica (M) -> 3250 RP
• Definitiva(D) -> 2750 RP
• Legendaria(L) ->1820 RP
• Épica (E) -> 1350 RP
• Normal (N) -> 975 RP*/

public class Skin {
    private String nomSkin;
    private String calidad;
    private int precio;
    
    public Skin(String nomSkin, String calidad) {
        this.nomSkin = nomSkin;
        this.calidad = calidad;
    }

    public String getNomSkin() {
        return nomSkin;
    }

    public void setNomSkin(String nomSkin) {
        this.nomSkin = nomSkin;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }
   
   
}
