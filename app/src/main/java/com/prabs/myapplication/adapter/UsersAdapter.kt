package com.prabs.myapplication

import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prabs.myapplication.databinding.ListItemBinding
import com.prabs.myapplication.datamodel.User

class UsersAdapter(users: List<User>) : RecyclerView.Adapter<UserViewHolder>() {
    private val userList = users

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]

        holder.binding.nameTv.visibility = (if (user.name == null) GONE else VISIBLE)
        holder.binding.locationTv.visibility = (if (user.location == null) GONE else VISIBLE)
        holder.binding.genderTv.visibility = (if (user.gender == null) GONE else VISIBLE)

        holder.binding.nameTv.text = "${user.name?.title}. ${user.name?.first} ${user.name?.last}"
        holder.binding.locationTv.text = "${user.location?.city}, ${user.location?.state}, ${user.location?.country} "
        holder.binding.genderTv.text =
            user.gender?.replaceFirst(user.gender!!.first(), user.gender!!.first().uppercaseChar())

        Glide.with(holder.itemView.context).load(user.picture.medium).into(holder.binding.userImage)
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}

class UserViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)