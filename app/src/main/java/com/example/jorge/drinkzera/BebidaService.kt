package com.example.jorge.drinkzera

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BebidaService {

    @GET("search.php?a=Alcoholic")
    fun getTodasBebidas(): Call<BebidasList>

    @GET("random.php")
    fun getBebidaAleatoria(): Call<Bebida>

    @GET("lookup.php?")
    fun getBebidaID(@Query("i") i: String): Call<Bebida>
}