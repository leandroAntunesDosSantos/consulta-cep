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


        fun formatCep(cep: String): String {
            return cep.replace(".", "").replace("-", "").replace(" ", "")
        }

        binding.btnCep.setOnClickListener {
            val cep = formatCep(binding.edtCep.text.toString())
            if (cep.length != 8) {
                binding.edtCep.error = "CEP inválido"
                return@setOnClickListener
            } else {
                cepViewModel.getCep(cep)
            }
        }
        setContentView(binding.root)
    }
}

