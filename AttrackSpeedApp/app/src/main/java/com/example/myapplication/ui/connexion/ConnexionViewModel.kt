package com.example.myapplication.ui.connexion

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class ConnexionViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Connexion Fragment"
    }
    val text: LiveData<String> = _text
}