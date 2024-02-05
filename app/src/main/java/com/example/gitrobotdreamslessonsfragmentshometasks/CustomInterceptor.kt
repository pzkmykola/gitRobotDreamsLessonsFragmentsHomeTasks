package com.example.gitrobotdreamslessonsfragmentshometasks

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class CustomInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        if(response.code == 404){
            Log.e("CustomInterceptor", "Resource not found")
        }
        return response
    }

}