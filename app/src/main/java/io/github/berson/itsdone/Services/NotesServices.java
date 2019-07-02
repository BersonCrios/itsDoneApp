package io.github.berson.itsdone.Services;

import io.github.berson.itsdone.Models.UserCreatted.User;
import io.github.berson.itsdone.Models.UserCreatted.UserCreatted;
import io.github.berson.itsdone.Models.UserLogged;
import io.github.berson.itsdone.Models.UserToLogin;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NotesServices {
    @Headers("Content-Type: application/json")
    @POST("user/login")
    Call<UserLogged> doLogin(@Body UserToLogin user);

    @Headers("Content-Type: application/json")
    @POST("user/create")
    Call<UserCreatted> createUser(@Body User user);
}
