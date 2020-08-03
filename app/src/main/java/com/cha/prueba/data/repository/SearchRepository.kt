package com.cha.prueba.data.repository

import android.util.Log
import com.cha.prueba.data.network.ItemsApi
import com.cha.prueba.data.network.model.ItemsResponse
import retrofit2.Response

class SearchRepository() {

    suspend fun getItems( searchString: String, page: Int, itemsPerPage: Int ): Response<ItemsResponse> {
        Log.d("Servicio", ItemsApi().getItems( searchString, page, itemsPerPage).toString() )
        return ItemsApi().getItems( searchString, page, itemsPerPage)
    }
}