package com.cha.prueba.data.network.model

data class PlpResults(
    val label: String,
    val navigation: Navigation,
    val plpState: PlpState,
    val records: List<Record>,
    val refinementGroups: List<RefinementGroup>,
    val sortOptions: List<SortOption>
)