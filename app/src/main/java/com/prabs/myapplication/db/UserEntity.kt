package com.prabs.myapplication.db

import androidx.room.*

@Entity
data class UserEntity @Ignore constructor(
    @PrimaryKey(autoGenerate = true) var uid: Int = 0,
    @ColumnInfo(name = "user") var user: String = "",
    @ColumnInfo(name = "info") var info: String = ""
) {
    constructor() : this(0, "", "")
}