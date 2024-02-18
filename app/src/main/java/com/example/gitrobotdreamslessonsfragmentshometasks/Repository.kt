package com.example.gitrobotdreamslessonsfragmentshometasks

import retrofit2.Retrofit

class Repository (private val client: Retrofit) {
    fun getSuperHeroesByCR() : SuperHeroDataResponse{
        //suspend fun getSuperHeroesByCR() : SuperHeroDataResponse{
        val apiInterfase = client.create(ApiInterface::class.java)
        return apiInterfase.getSuperHeroesByCR()
    }
}