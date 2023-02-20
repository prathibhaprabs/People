package com.prabs.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prabs.myapplication.datamodel.Results
import com.prabs.myapplication.datamodel.User
import com.prabs.myapplication.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel() {

    val users = MutableLiveData<List<User>>()
    val errorMessage = MutableLiveData<String>()

    fun getUsersInfo() {
        val response = RetrofitService.getInstance().getUsersInfo()
        response.enqueue(object : Callback<Results> {
            override fun onResponse(call: Call<Results>, response: Response<Results>) {
                users.value = response.body()?.results
            }

            override fun onFailure(call: Call<Results>, t: Throwable) {
                errorMessage.value = t.message
            }
        })
    }
}