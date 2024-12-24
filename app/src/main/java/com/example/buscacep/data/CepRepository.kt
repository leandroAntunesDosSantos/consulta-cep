package com.example.buscacep.data

import javax.inject.Inject


class CepRepository @Inject constructor(private val cepRemoteDataSource: CepRemoteDataSource){

    suspend fun getCep(cep: String) : Cep {
        return cepRemoteDataSource.getCep(cep)
    }
}