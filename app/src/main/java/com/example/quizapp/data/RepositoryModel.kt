package com.example.quizapp.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RepositoryModel(
    @SerializedName("name")
    val name:String?,
    @SerializedName("created_at")
    val created_at:String?,
    @SerializedName("stargazers_count")
    val stargazers_count:Int?,
    @SerializedName("owner")
    val owner: Owner?,
    @SerializedName("id")
    val id:Int?
    ) : Serializable
