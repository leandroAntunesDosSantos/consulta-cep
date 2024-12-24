package com.example.buscacep.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CepRemoteDataSource(private val cepService: CepService) {
    suspend fun getCep(cep: String) : Cep {
        val result: Cep
        withContext(Dispatchers.IO) {
            result = cepService.getCep(cep)
        }
        return result
    }
}