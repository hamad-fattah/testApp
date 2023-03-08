package com.example.quizapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizapp.data.RepositoryModel
import com.example.quizapp.retrofit.RetrofitInstance
import com.example.quizapp.retrofit.RetrofitServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryViewModel : ViewModel() {

    lateinit var liveDataList : MutableLiveData<List<RepositoryModel>?>

    init {
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<RepositoryModel>?> {
        return  liveDataList
    }

    fun makeAPICall(){
        val retrofitInstance = RetrofitInstance.getRetroInstance()
        val retrofitService = retrofitInstance.create(RetrofitServiceInterface::class.java)
        val call = retrofitService.getRepositoriesList()
        call.enqueue(object : Callback<List<RepositoryModel>>{

            override fun onFailure(call: Call<List<RepositoryModel>>, t: Throwable) {
                liveDataList.postValue(null)
            }
            override fun onResponse(
                call: Call<List<RepositoryModel>>,
                response: Response<List<RepositoryModel>>
            ) {
                liveDataList.postValue(response.body())
            }
        })
    }
}