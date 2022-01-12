package com.example.desaafio_12_01

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _textInput=MutableLiveData<String>()

    val textInput:LiveData<String>
        get()=_textInput


    fun setValue(tvInput:String){
        _textInput.value= tvInput
    }

}