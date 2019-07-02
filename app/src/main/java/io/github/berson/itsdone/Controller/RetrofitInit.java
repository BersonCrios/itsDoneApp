package io.github.berson.itsdone.Controller;

import java.util.concurrent.TimeUnit;

import io.github.berson.itsdone.Services.NotesServices;
import io.github.berson.itsdone.Utils.Constants;
import io.github.berson.itsdone.Utils.CustomSharedPreference;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInit {
    private static Retrofit retrofit = null;

    public static Retrofit getNotes() {
        if (retrofit==null) {
            final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.connectTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.MINUTES);
            httpClient.readTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.MINUTES);
            httpClient.callTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.MINUTES);
            httpClient.writeTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.MINUTES);
//            httpClient.addInterceptor(chain -> {
//                Request request = chain.request()
//                        .newBuilder()
//                        .addHeader("Authorization", CustomSharedPreference.getToken())
//                        .build();
//                return chain.proceed(request);
//            });

            retrofit= new Retrofit.Builder()
                    .baseUrl(Constants.URL_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }

    public static NotesServices getBlank() {
        return getNotes().create(NotesServices.class);
    }
}
