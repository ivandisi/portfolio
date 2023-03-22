package it.ivandisiro.portfolio.networking

import android.util.JsonReader
import com.google.gson.Gson
import it.ivandisiro.portfolio.model.Me
import it.ivandisiro.portfolio.networking.callback.ProfileCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Networking {
    var service: ApiService;

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/ivandisi/portfolio/594b34fa72b3da345b060745224ca5a7e9dc2a87/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        this.service = retrofit.create(ApiService::class.java)
    }

    fun getProfile(callback: ProfileCallback) {
        this.service.getProfile().enqueue(object : Callback<Me> {
            override fun onResponse(call: Call<Me>, response: Response<Me>) {
                if (response.isSuccessful){
                    callback.onSuccess(response.body());
                } else {
                    callback.onError(response.code(), null);
                }
            }
            override fun onFailure(call: Call<Me>, t: Throwable) {
                callback.onError(-1, t);
            }});
    }
}

