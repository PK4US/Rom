package com.pk4u.recyclerview2mvvm

import com.pk4u.recyclerview2mvvm.model.User


interface Navigator {

    fun showDetails(user: User)

    fun goBack()

    fun toast(messageRes: Int)

}