package it.ivandisiro.portfolio.networking

import it.ivandisiro.portfolio.model.Me
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("data")
    fun getProfile(): Call<Me>
}