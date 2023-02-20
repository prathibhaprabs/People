package com.prabs.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.prabs.myapplication.databinding.ActivityMainBinding
import com.prabs.myapplication.databinding.ListItemBinding
import com.prabs.myapplication.datamodel.User
import com.prabs.myapplication.retrofit.RetrofitService
import com.prabs.myapplication.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var viewModel: UserViewModel = UserViewModel()
    private val user: ArrayList<User> = ArrayList()
    private val adapter = UsersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(this)

        viewModel.users.observe(this) {
            user.clear()
            user.addAll(it)
            Log.e("list size", "-" + user.size)
            adapter.setUserList(user)
        }

        viewModel.getUsersInfo()
    }
}