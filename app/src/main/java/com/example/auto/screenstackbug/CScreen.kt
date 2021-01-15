package com.example.auto.screenstackbug

import android.util.Log
import androidx.lifecycle.LifecycleEventObserver
import com.google.android.libraries.car.app.CarContext
import com.google.android.libraries.car.app.Screen
import com.google.android.libraries.car.app.model.Action
import com.google.android.libraries.car.app.model.MessageTemplate

class CScreen(carContext: CarContext) : Screen(carContext) {
    init {
        lifecycle.addObserver(LifecycleEventObserver { _, event ->
            Log.i("CScreen", "state: ${event.name}")
        })
    }

    override fun getTemplate() =
        MessageTemplate.builder("Screen C")
            .setHeaderAction(Action.BACK)
            .setActions(
                listOf(
                    Action.builder()
                        .setTitle("finish")
                        .setOnClickListener {
                            setResult("result")
                            finish()
                        }
                        .build()
                )
            )
            .build()
}
