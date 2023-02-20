package com.prabs.myapplication.datamodel

import java.io.Serializable

data class Results(
    var results: ArrayList<User>,
    var info: Info
) : Serializable

data class User(
    var gender: String?,
    var name: Name?,
    var location: Location?,
    var picture: Picture,
    var email: String,
    var login: Login,
    var dob: DoB,
    var registered: Registered,
    var phone: String,
    var cell: String,
    var id: ID,
    var nat: String
) : Serializable

data class Name(
    var title: String,
    var first: String,
    var last: String
) : Serializable

data class Location(
    var street: Street,
    var city: String,
    var state: String,
    var country: String,
    var postcode: String,
    var coordinates: Coordinates,
    var timezone: Timezone
) : Serializable

data class Street(
    var number: String,
    var name: String
) : Serializable

data class Coordinates(
    var latitude: String,
    var longitude: String
) : Serializable

data class Timezone(
    var offset: String,
    var description: String
) : Serializable

data class Login(
    var uuid: String,
    var username: String,
    var password: String,
    var salt: String,
    var md5: String,
    var sha1: String,
    var sha256: String
) : Serializable

data class DoB(
    var date: String,
    var age: Int
) : Serializable

data class Registered(
    var date: String,
    var age: Int
) : Serializable

data class ID(
    var name: String,
    var value: String
) : Serializable

data class Picture(
    var large: String,
    var medium: String,
    var thumbnail: String
) : Serializable

data class Info(
    var seed: String,
    var results: String,
    var page: String,
    var version: String
) : Serializable