package io.github.berson.itsdone.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import io.github.berson.itsdone.Controller.RetrofitInit;
import io.github.berson.itsdone.Models.NoteCreate.NotesCreate;
import io.github.berson.itsdone.Models.NoteCreatted.NoteCreatted;
import io.github.berson.itsdone.Models.UserCreatted.User;
import io.github.berson.itsdone.Models.UserCreatted.UserCreatted;
import io.github.berson.itsdone.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateNoteActivity extends AppCompatActivity {

    private TextInputEditText titleEt;
    private EditText textEt;
    private Button salvarNotaBtn;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_create_note);
        
        widgets();
    }

    private void widgets() {
        titleEt = findViewById(R.id.titleEt);
        textEt = findViewById(R.id.textEt);  
        salvarNotaBtn = findViewById(R.id.salvarNotaBtn);

        salvarNota();
    }

    private void salvarNota() {
        salvarNotaBtn.setOnClickListener(v->{
            NotesCreate notinha = new NotesCreate();
            notinha.setTitle(titleEt.getText().toString());
            notinha.setText(textEt.getText().toString());
            notinha.setIsActive(true);
            salvaNota(notinha);
        });
    }

    private void salvaNota(NotesCreate note) {
        Call<NoteCreatted> call = RetrofitInit.getService().createNote(note);
        call.enqueue(new Callback<NoteCreatted>() {
            @Override
            public void onResponse(@NonNull Call<NoteCreatted> call, @NonNull Response<NoteCreatted> response) {
                if (response.isSuccessful()){
                    Log.e("notinha ae", response.body().getNote().getTitle()+"");
                    Intent i = new Intent(CreateNoteActivity.this, NotesActivity.class);
                    startActivity(i);
                    finish();
                }
            }

            @Override
            public void onFailure(@NonNull Call<NoteCreatted> call, Throwable t) {
                Log.e("erro", t.getMessage());
            }
        });
    }


}
