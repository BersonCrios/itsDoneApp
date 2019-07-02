package io.github.berson.itsdone.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        UserToLogin user = new UserToLogin("guilherme", "12345678");

        doLogin(user);
        createUser();
    }



    public void doLogin(UserToLogin userzin) {
        Call<UserLogged> call = RetrofitInit.getBlank().doLogin(userzin);
        call.enqueue(new Callback<UserLogged>() {
            @Override
            public void onResponse(@NonNull Call<UserLogged> call, @NonNull Response<UserLogged> response) {
                assert response.body() != null;
                Log.e("Logadooo", response.body().getToken());
                CustomSharedPreference.setToken(response.body().getToken());
            }

            @Override
            public void onFailure(@NonNull Call<UserLogged> call, Throwable t) {
                Log.e("erro", t.getMessage());
            }
        });
    }

    public void createUser() {
        User userzinhu = new User("Mewthow", "mew", "mew@gmail.com","12345678");

        Call<UserCreatted> call = RetrofitInit.getBlank().createUser(userzinhu);
        call.enqueue(new Callback<UserCreatted>() {
            @Override
            public void onResponse(@NonNull Call<UserCreatted> call, @NonNull Response<UserCreatted> response) {
                assert response.body() != null;
                Log.e("User ae", response.body()+"");

            }

            @Override
            public void onFailure(@NonNull Call<UserCreatted> call, Throwable t) {
                Log.e("erro", t.getMessage());
            }
        });
    }
}
