package com.example.quizapp.retrofit

import com.example.quizapp.data.RepositoryModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServiceInterface {
    @GET("repos")
    fun getRepositoriesList(
        @Query("page") page : Int
    ) : Call<List<RepositoryModel>>



}