package com.example.desafio;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;
import java.util.concurrent.ExecutionException;

public class CachorroActivity extends AppCompatActivity {

    private final int[] id = {226, 1, 2, 3, 4, 5, 6, 7, 8, 9, 55, 10, 11, 116};
    private ImageView imagem1;
    private TextView txtCao;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cachorro);

        imagem1 = findViewById(R.id.imgDog1);
        txtCao = findViewById(R.id.txtCao);
        progress = new ProgressDialog(this);
        progress.setMessage("Atualizando...");
        progress.setCancelable(false);
        pegarImagens();


    }

    private void pegarImagens() {

        int i = new Random().nextInt(id.length);
        System.out.println(i);

        HttpService cao = new HttpService("https://api.thedogapi.com/v1/images/search?breed_ids=" + id[i]);
        try {

            StringBuilder resposta = cao.execute().get();


            JSONArray jsonArray = new JSONArray(resposta.toString());
            JSONObject jsonObject = jsonArray.getJSONObject(0);

            String url = jsonObject.getString("url");

            JSONArray breeds = jsonObject.getJSONArray("breeds");
            JSONObject breed = breeds.getJSONObject(0);

            String descricao = "";
            descricao += "Name: " + breed.getString("name") + "\n";
            descricao += "Temperament: " + breed.getString("temperament") + "\n";
            //descricao += "Origin: "+breed.getString("origin")+"\n";
            descricao += "Life Span: " + breed.getString("life_span") + "\n";
            descricao += "Bred for: " + breed.getString("bred_for") + "\n";

            txtCao.setText(descricao);


            Glide.with(getApplicationContext()).load(url).into(imagem1);

            if (MainActivity.progressDialog.isShowing()){
                MainActivity.progressDialog.dismiss();
            }

            if (progress.isShowing()){
                progress.dismiss();
                Toast.makeText(getApplicationContext(), "A imagem pode demorar alguns segundos para carregar", Toast.LENGTH_LONG).show();
            }


        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void imgVoltar(View view) {

        finish();

    }

    public void imgRecarregar(View view) {

        progress.show();
        pegarImagens();

    }
}
