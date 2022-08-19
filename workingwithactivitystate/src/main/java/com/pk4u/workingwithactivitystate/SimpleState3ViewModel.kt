package com.pk4u.workingwithactivitystate

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class SimpleState3ViewModel: ViewModel() {

    val state:LiveData<State> get() = stateLiveData
    private val stateLiveData = MutableLiveData<State>()

    fun initState(state:State){
        stateLiveData.value = state
    }

    fun increment(){
        val oldState = stateLiveData.value
        stateLiveData.value = oldState?.copy(
            countValue = oldState.countValue + 1
        )
    }

    fun setRandomColor(){
        val oldState = stateLiveData.value
        stateLiveData.value = oldState?.copy(
            countTextColor = Color.rgb(
                Random.nextInt(256),
                Random.nextInt(256),
                Random.nextInt(256),
            )
        )
    }

    fun switchVisibility(){
        val oldState = stateLiveData.value
        stateLiveData.value = oldState?.copy(
            countIsVisible = !oldState.countIsVisible
        )
    }

    data class State(
        val countValue:Int,
        val countTextColor:Int,
        val countIsVisible:Boolean
    )
}