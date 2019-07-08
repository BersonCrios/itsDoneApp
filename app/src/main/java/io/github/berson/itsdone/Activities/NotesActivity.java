package io.github.berson.itsdone.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import io.github.berson.itsdone.Adapters.NotesAdapter;
import io.github.berson.itsdone.Controller.RetrofitInit;
import io.github.berson.itsdone.Models.Notes.Nota;
import io.github.berson.itsdone.Models.Notes.Notes;
import io.github.berson.itsdone.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotesActivity extends AppCompatActivity {

    private RecyclerView notesRv;
    private ArrayList<Nota> notas = new ArrayList<>();
    private NotesAdapter adapterNotes;

    private Button novaNotaBtn;
    private TextView usuarioTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_notes);

        listNotes();

        widgets();
    }

    private void widgets() {
        notesRv = findViewById(R.id.notesRv);
        novaNotaBtn = findViewById(R.id.novaNotaBtn);
        usuarioTv = findViewById(R.id.usuarioTv);
        vaiParaNovaNota();
        getUser();
    }

    private void vaiParaNovaNota() {
        novaNotaBtn.setOnClickListener(v->{
            Intent i = new Intent(NotesActivity.this, CreateNoteActivity.class);
            startActivity(i);
            finish();
        });
    }


    private void listNotes() {
        Call<Notes> call = RetrofitInit.getService().listNotes();
        call.enqueue(new Callback<Notes>() {
            @Override
            public void onResponse(@NonNull Call<Notes> call, @NonNull Response<Notes> response) {
                if (response.isSuccessful()){
                Log.e("notas", response.body().getNotas()+"");
                notas.addAll(response.body().getNotas());
                adapterNotes = new NotesAdapter(NotesActivity.this, notas, item -> {
                    Log.e("NOta", item.getTitle());
                    Toast.makeText(NotesActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
                });
                notesRv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                notesRv.setAdapter(adapterNotes);
                }
            }

            @Override
            public void onFailure(Call<Notes> call, Throwable t) {
                Log.e("failure", t.getMessage());
            }
        });
    }

    private void getUser() {
        Call<JsonObject> call = RetrofitInit.getService().userDatas();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(@NonNull Call<JsonObject> call, @NonNull Response<JsonObject> response) {
                if (response.isSuccessful()){
                    usuarioTv.setText(response.body().get("username").toString().trim().replace("\"", "").toUpperCase());
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("failure", t.getMessage());
            }
        });
    }
}
