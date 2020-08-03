package com.cha.prueba.data.network.model

data class PlpState(
    val categoryId: String,
    val currentFilters: String,
    val currentSortOption: String,
    val firstRecNum: Int,
    val lastRecNum: Int,
    val recsPerPage: Int,
    val totalNumRecs: Int
)