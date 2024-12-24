package com.example.buscacep.data

import retrofit2.http.GET
import retrofit2.http.Path


interface CepService {
    @GET("{cep}/json/")
    suspend fun getCep(@Path("cep") cep: String) : Cep
}