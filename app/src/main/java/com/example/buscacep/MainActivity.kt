package com.example.buscacep

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.buscacep.databinding.ActivityMainBinding
import com.example.buscacep.ui.CepViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val cepViewModel: CepViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = cepViewModel

        binding.btnCep.setOnClickListener {
            val cep = binding.edtCep.text.toString().trim()
            val cepFilter = Regex("[0-9]{5}-[0-9]{3}")
            if (!cepFilter.matches(cep)) {
                binding.edtCep.error = "CEP inválido"
                return@setOnClickListener
            }
            cepViewModel.getCep(cep)

        }

        setContentView(binding.root)
    }
}