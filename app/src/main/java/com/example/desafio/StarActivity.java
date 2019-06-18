package com.example.desafio;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.desafio.starwarsAPI.models.People;
import com.example.desafio.starwarsAPI.sw.StarWarsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class StarActivity extends AppCompatActivity {

    private ImageView imgC3po,imgR2d2, imgLeia, imgDarth, imgLuke;
    private TextView txtC3po,txtR2d2, txtLeia, txtDarth, txtLuke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);

        StarWarsApi.init();  // se for usar a api padrão tera q inicializar aqui

        imgLuke = findViewById(R.id.imgLuke);
        txtLuke = findViewById(R.id.txtLuke);

        try {

            descLukeApi();
            descDarth();
            descLeia();
            descR2d2();
            descC3po();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void descLukeApi() {
        StarWarsApi.getApi().getPeople(1, new Callback<People>() {
            @Override
            public void success(People people, Response response) {
                String descricao = "";

                descricao += "Nome: "+people.name+"\n";
                descricao += "Idade: "+people.birthYear+"\n";
                descricao += "sexo: "+people.gender+"\n";
                descricao += "Cor do cabelo: "+people.hairColor+"\n";
                descricao += "Altura: "+people.height+"\n";
                descricao += "Peso: "+people.mass+"\n";
                descricao += "Nome real: Mark Hamill"+"\n";

                txtLuke.setText(descricao);

                if (MainActivity.progressDialog.isShowing()){
                    MainActivity.progressDialog.dismiss();
                }

            }

            @Override
            public void failure(RetrofitError error) {
                Log.w("ERRO",error.toString());
            }
        });
    }

    private void descC3po() {

        StarWarsApi.getApi().getPeople(2, new Callback<People>() {
            @Override
            public void success(People people, Response response) {
                String descricao = "";

                descricao += "Nome: "+people.name+"\n";
                descricao += "Idade: "+people.birthYear+"\n";
                descricao += "sexo: "+people.gender+"\n";
                descricao += "Cor do cabelo: "+people.hairColor+"\n";
                descricao += "Altura: "+people.height+"\n";
                descricao += "Peso: "+people.mass+"\n";
                descricao += "Nome real: Mark Hamill"+"\n";

                txtLuke.setText(descricao);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.w("ERRO",error.toString());
            }
        });

    }

    private void descR2d2() {

    }

    private void descLeia() {

    }

    private void descDarth() {

    }

    public void imgVoltar(View view) {
        finish();
    }

}
