package com.example.pruebaretrofit;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface RegisterUser {

    @FormUrlEncoded
    @POST("api/mobile/login")
    Call<List<Respuesta>> createuser(
            @Field("email") String email,
            @Field("password") String password
    );

}
