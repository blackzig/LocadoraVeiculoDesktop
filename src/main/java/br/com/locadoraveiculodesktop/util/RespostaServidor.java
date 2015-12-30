/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadoraveiculodesktop.util;

/**
 *
 * @author michel
 */
public class RespostaServidor {

    public String retornarResposta(int resposta) {
        System.out.println("resposta " + resposta);
        String r = null;
        if (resposta == 200) {
            r = "Tarefa executada com sucesso.";
        } else if (resposta == 0) {
            r = "Preencha todos os campos necessários";
        } else if (resposta == 404) {
            r = "Servidor fora do ar ou caminho de comunicação incorreto.";
        } else {
            r = "Erro desconhecido";
        }
        return r;
    }

}
