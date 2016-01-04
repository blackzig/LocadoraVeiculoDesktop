/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadoraveiculodesktop.util;

/**
 *
 * @author Michel A. Medeiros
 */
public class ConfServidor {
    
    //casa
    static String urlServidorCasa = "http://localhost:43230/";

    public static String getUrlServidorCasa() {
        return urlServidorCasa;
    }

    public static void setUrlServidorCasa(String urlServidorCasa) {
        ConfServidor.urlServidorCasa = urlServidorCasa;
    }
    
    
    
}
