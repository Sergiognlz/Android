package com.example.termo.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.termo.models.TermostatoRepository
import androidx.compose.runtime.State

// Solo lógica, no sabe nada de botones ni pantallas
class TermostatoViewModel : ViewModel() {

    private val _temperatura = mutableStateOf(TermostatoRepository.getTemperatura())
    val temperatura: State<Int> get() = _temperatura

    fun setTemperatura(nueva: Int) {
        _temperatura.value = nueva
    }
}