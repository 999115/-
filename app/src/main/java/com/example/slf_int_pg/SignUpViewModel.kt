package com.example.slf_int_pg

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {

    private val _idLiveData: MutableLiveData<String> = MutableLiveData()
    val idLiveData: LiveData<String> get() = _idLiveData

    private val _pwLiveData: MutableLiveData<String> = MutableLiveData()
    val pwLiveData: LiveData<String> get() = _pwLiveData

    private val _nameLiveData: MutableLiveData<String> = MutableLiveData()
    val nameLiveData: LiveData<String> get() = _nameLiveData

    fun nameData(id: String) {

        _nameLiveData.value = "이름 : $id"

    }

    fun idData(id: String) {

        _idLiveData.value = "ID : $id"

    }

    fun pwData(id: String) {

        _pwLiveData.value = "PW : $id"

    }

}