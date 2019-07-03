package io.github.berson.itsdone.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import io.github.berson.itsdone.Controller.RetrofitInit;
import io.github.berson.itsdone.Models.UserCreatted.User;
import io.github.berson.itsdone.Models.UserCreatted.UserCreatted;
import io.github.berson.itsdone.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateUserActivity extends AppCompatActivity {

    private TextInputEditText nomeEt, usuarioEt, emailEt, senhaEt;
    private Button salvarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_create_user);

        widgets();
    }

    private void widgets(){
        usuarioEt = findViewById(R.id.usuarioEt);
        senhaEt = findViewById(R.id.senhaEt);
        nomeEt = findViewById(R.id.nomeEt);
        emailEt = findViewById(R.id.EmailEt);
        salvarBtn = findViewById(R.id.salvarBtn);
        cadastrar();
    }

    private void cadastrar() {
        salvarBtn.setOnClickListener(v -> {
            User userzinhu = new User();
            userzinhu.setName(nomeEt.getText().toString());
            userzinhu.setUsername(usuarioEt.getText().toString());
            userzinhu.setEmail(emailEt.getText().toString());
            userzinhu.setPassword(senhaEt.getText().toString());
            createUser(userzinhu);
        });
    }

    public void createUser(User u) {
        Call<UserCreatted> call = RetrofitInit.getService().createUser(u);
        call.enqueue(new Callback<UserCreatted>() {
            @Override
            public void onResponse(@NonNull Call<UserCreatted> call, @NonNull Response<UserCreatted> response) {
                if (response.isSuccessful()){
                    Log.e("User ae", response.body().getUser()+"");
                    Intent i = new Intent(CreateUserActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserCreatted> call, Throwable t) {
                Log.e("erro", t.getMessage());
            }
        });
    }
}
