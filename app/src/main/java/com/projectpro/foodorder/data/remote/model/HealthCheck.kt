package com.projectpro.foodorder.data.remote.model

data class HealthCheck(
    val db: Db
)

data class Db(
    val message: String,
    val status: String
)