package com.trevo.trevoapp.ui.orcamento

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrcamentosViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Fragment de Orçamento"
    }
    val text: LiveData<String> = _text
}