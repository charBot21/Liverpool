package com.cha.prueba.model.interfaces

import com.cha.prueba.data.network.model.Record

interface SearchListener {

    fun onStarted()

    fun onSuccess(records: List<Record>)

    fun onFailure(errorCode: Int)
}