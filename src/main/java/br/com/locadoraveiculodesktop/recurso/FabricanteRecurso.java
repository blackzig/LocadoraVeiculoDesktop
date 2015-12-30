/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadoraveiculodesktop.recurso;

/**
 * update pg_database set encoding = pg_char_to_encoding('ISO-8859-1') where
 * datname = 'locadora'
 *
 * @author Michel A. Medeiros
 * http://examples.javacodegeeks.com/enterprise-java/rest/restful-java-client-with-java-net-url/
 */
import br.com.locadoraveiculodesktop.classes.Fabricante;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FabricanteRecurso {

    public int salvar(String input, String urlPart) {
        //casa
        //  String targetURL = "http://localhost:43230/locadoraveiculo/rest/"+urlPart;
        //servi�o
        String targetURL = "http://localhost:2411/locadoraveiculo/rest/" + urlPart;
        try {

            URL targetUrl = new URL(targetURL);

            HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type", "application/json");

            OutputStream outputStream = httpConnection.getOutputStream();
            outputStream.write(input.getBytes());
            outputStream.flush();

            int resposta = httpConnection.getResponseCode();

            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + httpConnection.getResponseCode());

            }

            BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
                    (httpConnection.getInputStream())));

            String output;
            System.out.println("Output from Server:\n");
            while ((output = responseBuffer.readLine()) != null) {
                System.out.println(output);
            }

            httpConnection.disconnect();

            System.out.println("resposta servidor " + resposta);

            return resposta;
        } catch (IOException | RuntimeException e) {
            System.out.println("erro " + e.getMessage());
        }
        return 0;

    }//fim enviar
    
    public int excluir(String urlPart) {
        //casa
        //  String targetURL = "http://localhost:43230/locadoraveiculo/rest/"+urlPart;
        //servi�o
        String targetURL = "http://localhost:2411/locadoraveiculo/rest/" + urlPart;
        try {

            URL targetUrl = new URL(targetURL);

            HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setRequestMethod("DELETE");
            httpConnection.setRequestProperty("Content-Type", "application/json");


            int resposta = httpConnection.getResponseCode();

            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + httpConnection.getResponseCode());

            }

            BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
                    (httpConnection.getInputStream())));

            String output;
            System.out.println("Output from Server:\n");
            while ((output = responseBuffer.readLine()) != null) {
                System.out.println(output);
            }

            httpConnection.disconnect();

            System.out.println("resposta servidor " + resposta);

            return resposta;
        } catch (IOException | RuntimeException e) {
            System.out.println("erro " + e.getMessage());
        }
        return 0;

    }//fim enviar

    public List<Fabricante> pesquisar(String urlPart) {
        //casa
        //  String targetURL = "http://localhost:43230/locadoraveiculo/rest/"+urlPart;
        //servi�o
        String targetURL = "http://localhost:2411/locadoraveiculo/rest/" + urlPart;

        List<Fabricante> listaFabricante = new ArrayList<>();

        try {

            URL targetUrl = new URL(targetURL);

            HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
            httpConnection.setRequestMethod("GET");
            httpConnection.setRequestProperty("Accept", "application/json");

            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : "
                        + httpConnection.getResponseCode());
            }

            BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
                    (httpConnection.getInputStream())));

            String output;
            System.out.println("Output from Server:  \n");

            while ((output = responseBuffer.readLine()) != null) {
                System.out.println(output);
                TypeToken<List<Fabricante>> token = new TypeToken<List<Fabricante>>(){};
                listaFabricante = new Gson().fromJson(output, token.getType());
                System.out.println("listaFabricante "+listaFabricante.size());
            }

            httpConnection.disconnect();

        } catch (IOException | RuntimeException e) {
            System.out.println("erro " + e.getMessage());
        }
        return listaFabricante;
    }//fim trazerTodosOsFabricantes   

}//fim
