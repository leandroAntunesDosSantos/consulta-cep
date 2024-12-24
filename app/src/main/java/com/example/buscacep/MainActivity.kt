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
            val cep = binding.edtCep.text.toString()

            if (cep.isNotEmpty()) {
                cepViewModel.getCep(cep)
            }
        }

        setContentView(binding.root)
    }
}