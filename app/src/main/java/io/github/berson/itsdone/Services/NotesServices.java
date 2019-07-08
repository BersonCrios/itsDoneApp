package io.github.berson.itsdone.Services;

import com.google.gson.JsonObject;

import io.github.berson.itsdone.Models.NoteCreate.NotesCreate;
import io.github.berson.itsdone.Models.NoteCreatted.NoteCreatted;
import io.github.berson.itsdone.Models.Notes.Nota;
import io.github.berson.itsdone.Models.Notes.Notes;
import io.github.berson.itsdone.Models.UserCreatted.User;
import io.github.berson.itsdone.Models.UserCreatted.UserCreatted;
import io.github.berson.itsdone.Models.UserLogged;
import io.github.berson.itsdone.Models.UserToLogin;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NotesServices {
    @Headers("Content-Type: application/json")
    @POST("user/login")
    Call<UserLogged> doLogin(@Body UserToLogin user);

    @Headers("Content-Type: application/json")
    @GET("user/")
    Call<JsonObject> userDatas();

    @Headers("Content-Type: application/json")
    @POST("user/create")
    Call<UserCreatted> createUser(@Body User user);

    @Headers("Content-Type: application/json")
    @GET("notes/")
    Call<Notes> listNotes();

    @Headers("Content-Type: application/json")
    @POST("notes/create")
    Call<NoteCreatted> createNote(@Body NotesCreate note);

}
