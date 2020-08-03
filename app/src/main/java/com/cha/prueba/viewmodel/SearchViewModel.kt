package com.cha.prueba.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import com.cha.prueba.model.interfaces.SearchListener
import com.cha.prueba.data.repository.SearchRepository
import com.cha.prueba.utils.Coroutines

class SearchViewModel: ViewModel() {

    var search: String? = null
    var searchListener: SearchListener ?= null
    var page = 1
    var itemsPerPage = 200



    fun onSearchValue(view: View) {
        searchListener?.onStarted()

        if ( !search.isNullOrEmpty() ) {
            Coroutines.main {
                val response = SearchRepository().getItems( search!!, page, itemsPerPage)

                if ( response.isSuccessful ) {
                    searchListener?.onSuccess(response.body()?.plpResults?.records!!)
                } else {
                    searchListener?.onFailure(2)
                }
            }
        } else {
            searchListener?.onFailure(1)
        }

    }

    fun onReloadedSearch( searchR: String, pageR: Int, itemsPerPageR: Int ) {
        if ( !search.isNullOrEmpty() ) {
            Coroutines.main {
                val response = SearchRepository().getItems( searchR, pageR, itemsPerPageR)

                if ( response.isSuccessful ) {
                    searchListener?.onSuccess(response.body()?.plpResults?.records!!)
                } else {
                    searchListener?.onFailure(2)
                }
            }
        } else {
            searchListener?.onFailure(1)
        }
    }

}