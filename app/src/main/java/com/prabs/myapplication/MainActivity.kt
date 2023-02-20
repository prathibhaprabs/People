package com.prabs.myapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.prabs.myapplication.databinding.ActivityMainBinding
import com.prabs.myapplication.datamodel.User
import com.prabs.myapplication.db.AppDatabase
import com.prabs.myapplication.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var viewModel: UserViewModel = UserViewModel()
    private val user: ArrayList<User> = ArrayList()
    private val adapter = UsersAdapter(user)
    private var mDb: AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
//        mDb = AppDatabase.getInstance(this)
        setContentView(binding.root)

        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(this)

        viewModel.users.observe(this) {
            mDb?.userDao()?.deleteAllUsers()
            binding.progress.visibility = View.GONE
            user.clear()
            user.addAll(it)
            adapter.notifyDataSetChanged()

            user.forEach { user ->
                mDb?.userDao()?.insert(Gson().toJson(user))
            }
        }

        viewModel.errorMessage.observe(this) {
            binding.progress.visibility = View.GONE
            binding.errorTv.visibility = View.VISIBLE
        }

        if (Util.isNetworkAvailable(this))
            viewModel.getUsersInfo()
        else {
            val list = mDb?.userDao()?.getAllUsers()
            val users: ArrayList<User> = arrayListOf()

            list?.forEach {
                users.add(Gson().fromJson(it, User::class.java))
            }
            viewModel.users.value = users

            binding.progress.visibility = View.GONE
            binding.errorTv.visibility = View.VISIBLE
        }
    }
}