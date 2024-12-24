package com.example.buscacep.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buscacep.data.Cep
import com.example.buscacep.data.CepRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CepViewModel @Inject constructor( private val cepRepository: CepRepository) : ViewModel() {
    private val _cep = MutableLiveData<Cep>()
    val cep = _cep

    fun getCep(cep: String) {
        viewModelScope.launch {
            val result = cepRepository.getCep(cep)
            _cep.value = result
        }
    }
}