package io.github.berson.itsdone.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_notes);

        listNotes();

        widgets();
    }

    private void widgets() {
        notesRv = findViewById(R.id.notesRv);
    }


    private void listNotes() {
        Call<Notes> call = RetrofitInit.getService().listNotes();
        call.enqueue(new Callback<Notes>() {
            @Override
            public void onResponse(@NonNull Call<Notes> call, @NonNull Response<Notes> response) {
                if (response.isSuccessful()){
                Log.e("notas", response.body().getNotas()+"");
                notas.addAll(response.body().getNotas());
                adapterNotes = new NotesAdapter(NotesActivity.this, notas);
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
}
