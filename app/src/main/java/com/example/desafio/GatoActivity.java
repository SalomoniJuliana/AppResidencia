package com.example.desafio;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;
import java.util.concurrent.ExecutionException;

public class GatoActivity extends AppCompatActivity {

    private ImageView imgGato;
    private TextView txtGato,txtDesc;
    private ProgressDialog progress;

    private final String[] tipos = {"abys","beng","aege","sphy","esho"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gato);

        progress = new ProgressDialog(this);
        progress.setMessage("Atualizando...");
        progress.setCancelable(false);

        imgGato = findViewById(R.id.imgGato1);
        Glide.with(getApplicationContext()).load(R.drawable.giphy).asGif().into(imgGato);
        txtGato = findViewById(R.id.txtGato);
        txtDesc = findViewById(R.id.txtDesc);

        try {

            carregarImagem();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void carregarImagem() throws ExecutionException, InterruptedException, JSONException {

        int i = new Random().nextInt(5);

        HttpService httpService = new HttpService("https://api.thecatapi.com/v1/images/search?breed_ids="+tipos[i]);
        StringBuilder resposta = httpService.execute().get();

        String aux = resposta.substring(1,resposta.length()-1);

        JSONObject json = new JSONObject(aux);
        String url = json.getString("url");

        JSONArray breeds = json.getJSONArray("breeds");
        JSONObject breed = breeds.getJSONObject(0);
        Log.w("name",breed.getString("name"));

        String descricao = "";
        descricao += "Name: "+breed.getString("name")+"\n";
        descricao += "Temperament: "+breed.getString("temperament")+"\n";
        descricao += "Origin: "+breed.getString("origin")+"\n";
        descricao += "Life Span: "+breed.getString("life_span")+"\n";
        descricao += "Child Friendly: "+breed.getString("child_friendly")+"\n";

        txtGato.setText(descricao);
        String d = "Description: "+breed.getString("description");
        txtDesc.setText(d);

        Glide.with(getApplicationContext()).load(url).into(imgGato);

        if (MainActivity.progressDialog.isShowing()){
            MainActivity.progressDialog.dismiss();
        }

        if (progress.isShowing()){
            progress.dismiss();
        }

    }

    public void imgVoltar(View view) {
        finish();
    }

    public void imgRecarregar(View view) throws Exception {

        progress.show();
        carregarImagem();

    }
}
