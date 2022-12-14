package com.pk4us.mvvm_navigation.screens.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pk4us.mvvm_navigation.Event
import com.pk4us.mvvm_navigation.R
import com.pk4us.mvvm_navigation.navigator.Navigator
import com.pk4us.mvvm_navigation.screens.base.BaseViewModel
import com.pk4us.mvvm_navigation.screens.edit.EditFragment.Screen

class EditViewModel(
    private val navigator: Navigator,
    screen: Screen
) : BaseViewModel() {

    private val _initialMessageEvent = MutableLiveData<Event<String>>()
    val initialMessageEvent: LiveData<Event<String>> = _initialMessageEvent

    init {
        // sending initial value from screen argument to the fragment
        _initialMessageEvent.value = Event(screen.initialValue)
    }

    fun onSavePressed(message: String) {
        if (message.isBlank()) {
            navigator.toast(R.string.empty_message)
            return
        }
        navigator.goBack(message)
    }

    fun onCancelPressed() {
        navigator.goBack()
    }

}