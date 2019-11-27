package com.example.pruebaretrofit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Formulario4 extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        test();
    }
    public void test () {
        tv = (TextView)findViewById(R.id.textView);


        Call<List<Respuesta>> call = RetrofitClient.getInstance().getApi().createuser("dsadsa", "dsadsa");
        call.enqueue(new Callback<List<Respuesta>>() {
                @Override
                public void onResponse(Call<List<Respuesta>> call, retrofit2.Response<List<Respuesta>> response) {

                    List<Respuesta> postUsuarioRegistrados = response.body();

                    for (Respuesta postUsuarioRegistrado : postUsuarioRegistrados) {

                        String content = "";
                        content += "ID: " + postUsuarioRegistrado.getFail() + "\n";
                        tv.append(content);
                    }
                }
            @Override
            public void onFailure(Call<List<Respuesta>> call, Throwable t) {
                tv.setText(t.getMessage());
            }
            });
        }
}