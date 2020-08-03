package com.cha.prueba.data.network

import com.cha.prueba.model.constants.ENVIROMENT
import com.cha.prueba.data.network.model.ItemsResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ItemsApi {

    @GET("plp?force-plp=true")
    suspend fun getItems(
        @Query("search-string") searchString: String,
        @Query("page-number") page: Int,
        @Query("number-of-items-per-page") itemsPerPage: Int
    ): Response<ItemsResponse>

    companion object {
        operator fun invoke(): ItemsApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ENVIROMENT.URL_BASE)
                .build()
                .create(ItemsApi::class.java)
        }
    }
}