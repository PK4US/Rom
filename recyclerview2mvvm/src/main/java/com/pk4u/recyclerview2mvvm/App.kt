package com.pk4u.recyclerview2mvvm

import android.app.Application
import com.pk4u.recyclerview2mvvm.model.UsersService

class App : Application() {

    val usersService = UsersService()
}