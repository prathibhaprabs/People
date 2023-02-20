package com.prabs.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prabs.myapplication.databinding.ListItemBinding
import com.prabs.myapplication.datamodel.User

class UsersAdapter : RecyclerView.Adapter<UserViewHolder>() {
    private var userList = mutableListOf<User>()

    fun setUserList(users: List<User>) {
        userList = users.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.binding.nameTv.text = "${user.name.title} ${user.name.first} ${user.name.last}"
        holder.binding.locationsTv.text = user.location.city
        Glide.with(holder.itemView.context).load(user.picture.medium)
            .into(holder.binding.userImage)
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}

class UserViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)