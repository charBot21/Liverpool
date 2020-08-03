package com.cha.prueba.data.network.model

data class ItemsResponse(
    val pageType: String,
    val plpResults: PlpResults,
    val status: Status
)