package com.example.gitrobotdreamslessonsfragmentshometasks

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiClient @Inject constructor() {
    val client: Retrofit = Retrofit.Builder()
        .baseUrl(/* baseUrl = */ "https://akabab.github.io")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}