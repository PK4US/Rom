package com.pk4u.recyclerview1

import android.app.Application
import com.pk4u.recyclerview1.model.UsersService

class App : Application() {

    val usersService = UsersService()
}