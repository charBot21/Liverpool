package com.cha.prueba.data.network.model

data class Navigation(
    val ancester: List<Any>,
    val childs: List<Any>,
    val current: List<Current>
)