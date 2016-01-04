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
        System.out.println("resposta res " + resposta);
        String r = null;
        switch (resposta) {
            case 200:
                r = "Tarefa executada com sucesso.";
                break;
            case 204:
                r = "Preencha todos os campos necess�rios.";
                break;
            case 401:
                r = "Voc� n�o tem autoriza��o para realizar est� tarefa.";
                break;
            case 404:
                r = "Servidor fora do ar ou caminho de comunica��o incorreto.";
                break;
            case 500:
                r = "Erro no servidor.";
                break;
            default:
                r = "Erro desconhecido";
                break;
        }
        return r;
    }

}
