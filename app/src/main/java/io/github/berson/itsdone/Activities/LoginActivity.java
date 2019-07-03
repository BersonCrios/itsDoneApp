package io.github.berson.itsdone.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import io.github.berson.itsdone.Application.App;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import io.github.berson.itsdone.Controller.RetrofitInit;
import io.github.berson.itsdone.Models.UserCreatted.User;
import io.github.berson.itsdone.Models.UserCreatted.UserCreatted;
import io.github.berson.itsdone.Models.UserLogged;
import io.github.berson.itsdone.Models.UserToLogin;
import io.github.berson.itsdone.R;
import io.github.berson.itsdone.Utils.CustomSharedPreference;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText usuarioEt, senhaEt;
    private TextView novaContaTv;
    private Button entrarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        widgets();
    }


    private void widgets(){
        usuarioEt = findViewById(R.id.usuarioEt);
        senhaEt = findViewById(R.id.senhaEt);
        novaContaTv = findViewById(R.id.novaContaTv);
        entrarBtn = findViewById(R.id.entrarBtn);

        logar();
        vaiParaCadastro();
    }

    private void vaiParaCadastro() {
        novaContaTv.setOnClickListener(v ->{
            Intent i = new Intent(this, CreateUserActivity.class);
            startActivity(i);
        });
    }

    private void logar() {
        entrarBtn.setOnClickListener(v ->{
            UserToLogin user = new UserToLogin();
            user.setUsername(usuarioEt.getText().toString());
            user.setPassword(senhaEt.getText().toString());
            doLogin(user);
        });
    }


    public void doLogin(UserToLogin userzin) {
        Call<UserLogged> call = RetrofitInit.getService().doLogin(userzin);
        call.enqueue(new Callback<UserLogged>() {
            @Override
            public void onResponse(@NonNull Call<UserLogged> call, @NonNull Response<UserLogged> response) {
                if (response.isSuccessful()){
                    Log.e("Logadooo", response.body().getToken());
                    CustomSharedPreference.setToken(response.body().getToken());
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserLogged> call, Throwable t) {
                Log.e("erro", t.getMessage());
            }
        });
    }
}
