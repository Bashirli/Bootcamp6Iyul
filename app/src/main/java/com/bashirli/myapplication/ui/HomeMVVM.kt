package com.bashirli.myapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeMVVM  : ViewModel() {

    private val _counter= MutableLiveData<Int>(0)
    val counter: LiveData<Int> get()=_counter


    fun increaseNumber(number:Int){
        val newNumber=number+1
        _counter.postValue(newNumber)
    }

    fun decreaseNumber(number:Int){

        val newNumber=number-1
        _counter.value=newNumber
    }

}