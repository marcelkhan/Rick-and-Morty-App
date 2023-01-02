package com.marcelkhan.rickandmortyapp.model.episodes

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: String?
)