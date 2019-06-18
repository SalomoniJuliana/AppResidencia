package com.example.desafio;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    static ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(this);
    }

    public void onClickCao(View view) {
        progressDialog.setMessage("Carregando...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        Intent i = new Intent(this,CachorroActivity.class);
        startActivity(i);
    }

    public void onClickGato(View view) {
        progressDialog.setMessage("Carregando...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        Intent i = new Intent(this, GatoActivity.class);
        startActivity(i);
    }

    public void onClickStar(View view) {
        progressDialog.setMessage("Carregando...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        Intent i = new Intent(this, StarActivity.class);
        startActivity(i);
    }
}
