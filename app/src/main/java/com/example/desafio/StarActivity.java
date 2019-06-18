package com.example.desafio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.desafio.starwarsAPI.models.People;
import com.example.desafio.starwarsAPI.sw.StarWarsApi;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class StarActivity extends AppCompatActivity {

    private TextView txtR2d2, txtDarth, txtLuke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);

        StarWarsApi.init();  // se for usar a api padrão tera q inicializar aqui

        txtLuke = findViewById(R.id.txtLuke);
        txtDarth = findViewById(R.id.txtDarth);
        txtR2d2 = findViewById(R.id.txtR2d2);

        try {

            descLukeApi();
            descDarth();
            descR2d2();


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
                descricao += "Interpretado por: Mark Hamill" + "\n";

                txtLuke.setText(descricao);

                if (MainActivity.progressDialog.isShowing()){
                    MainActivity.progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "A imagem pode demorar alguns segundos para carregar", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void failure(RetrofitError error) {
                Log.w("ERRO",error.toString());
            }
        });
    }

    private void descR2d2() {

        StarWarsApi.getApi().getPeople(3, new Callback<People>() {
            @Override
            public void success(People people, Response response) {
                String descricao = "";

                descricao += "Nome: " + people.name + "\n";
                descricao += "Idade: " + people.birthYear + "\n";
                descricao += "sexo: " + people.gender + "\n";
                descricao += "Cor do cabelo: " + people.hairColor + "\n";
                descricao += "Altura: " + people.height + "\n";
                descricao += "Peso: " + people.mass + "\n";
                descricao += "Interpretado por: Kenny Baker em O despertar da força & Jimmy Vee em Os ultimos Jedi's" + "\n";

                txtR2d2.setText(descricao);

                if (MainActivity.progressDialog.isShowing()) {
                    MainActivity.progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "A imagem pode demorar alguns segundos para carregar", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void failure(RetrofitError error) {
                Log.w("ERRO", error.toString());
            }
        });

    }

    private void descDarth() {

        StarWarsApi.getApi().getPeople(4, new Callback<People>() {
            @Override
            public void success(People people, Response response) {
                String descricao = "";

                descricao += "Nome: " + people.name + "\n";
                descricao += "Idade: " + people.birthYear + "\n";
                descricao += "sexo: " + people.gender + "\n";
                descricao += "Cor do cabelo: " + people.hairColor + "\n";
                descricao += "Altura: " + people.height + "\n";
                descricao += "Peso: " + people.mass + "\n";
                descricao += "Interpretado por: Hayden Christensen em A vingança dos Sith\nDavid Prowse na trilogia original\ne por James Earl Jones em Rogue One" + "\n";

                txtDarth.setText(descricao);

                if (MainActivity.progressDialog.isShowing()) {
                    MainActivity.progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "A descriçao pode demorar alguns segundos para carregar", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void failure(RetrofitError error) {
                Log.w("ERRO", error.toString());
            }
        });

    }

    public void imgVoltar(View view) {
        finish();
    }

}
