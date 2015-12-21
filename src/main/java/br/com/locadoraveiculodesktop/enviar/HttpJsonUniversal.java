/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadoraveiculodesktop.enviar;

/**
 * update pg_database set encoding = pg_char_to_encoding('ISO-8859-1') where
 * datname = 'locadora'
 *
 * @author Michel A. Medeiros
 * http://examples.javacodegeeks.com/enterprise-java/rest/restful-java-client-with-java-net-url/
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpJsonUniversal {

    public void enviar(String input, String urlPart) {
        String targetURL = "http://localhost:43230/locadoraveiculo/rest/"+urlPart;
        try {

            URL targetUrl = new URL(targetURL);

            HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type", "application/json");

            OutputStream outputStream = httpConnection.getOutputStream();
            outputStream.write(input.getBytes());
            outputStream.flush();

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

        } catch (IOException | RuntimeException e) {
            System.out.println("erro " + e.getMessage());
        }

    }//fim enviar

}
