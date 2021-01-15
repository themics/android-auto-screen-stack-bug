package com.example.auto.screenstackbug

import android.content.Intent
import com.google.android.libraries.car.app.CarAppService
import com.google.android.libraries.car.app.Screen

class ScreenStackBugService : CarAppService() {
    override fun onCreateScreen(intent: Intent): Screen = AScreen(carContext)
}
