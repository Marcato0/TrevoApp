package com.trevo.trevoapp.ui.informacoes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InformacoesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Fragment de Informacoes"
    }
    val text: LiveData<String> = _text
}