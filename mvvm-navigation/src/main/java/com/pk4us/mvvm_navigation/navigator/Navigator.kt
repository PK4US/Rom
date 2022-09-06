package com.pk4us.mvvm_navigation.navigator

import androidx.annotation.StringRes
import com.pk4us.mvvm_navigation.screens.base.BaseScreen

interface Navigator {

    fun launch(screen: BaseScreen)

    fun goBack(result: Any? = null)

    fun toast(@StringRes messageRes: Int)

    fun getString(@StringRes messageRes: Int): String

}