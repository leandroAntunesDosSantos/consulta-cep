package com.example.buscacep.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Cep(
    @SerializedName("logradouro")
    @Expose
    val logradouro: String,
    @SerializedName("bairro")
    @Expose
    val bairro: String,
    @SerializedName("cep")
    @Expose
    val cep: String) {
}
