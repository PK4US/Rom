package com.pk4u.recyclerview1diffutils

import android.app.Application
import com.pk4u.recyclerview1diffutils.model.UsersService

class App : Application() {

    val usersService = UsersService()
}