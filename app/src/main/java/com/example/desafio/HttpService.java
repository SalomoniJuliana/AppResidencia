package com.example.desafio;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public class HttpService extends AsyncTask<Void,Void,StringBuilder> {

    private String url;

    public HttpService(String url) {
        this.url = url;
    }

    @Override
    protected StringBuilder doInBackground(Void... voids) {

        StringBuilder resposta = new StringBuilder();

        try {

            URL url = new URL(this.url);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setConnectTimeout(10000);
            connection.connect();

            Scanner sc = new Scanner(url.openStream());

            while (sc.hasNext()) {
                resposta.append(sc.nextLine());
            }

            Log.w("resposta",resposta.toString());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return resposta;
    }
}
