package com.example.auto.screenstackbug

import android.util.Log
import androidx.lifecycle.LifecycleEventObserver
import com.google.android.libraries.car.app.CarContext
import com.google.android.libraries.car.app.Screen
import com.google.android.libraries.car.app.model.Action
import com.google.android.libraries.car.app.model.MessageTemplate

class BScreen(carContext: CarContext) : Screen(carContext) {
    init {
        lifecycle.addObserver(LifecycleEventObserver { _, event ->
            Log.i("BScreen", "state: ${event.name}")
        })
    }

    override fun getTemplate() =
        MessageTemplate.builder("Screen B")
            .setHeaderAction(Action.BACK)
            .setActions(
                listOf(
                    Action.builder()
                        .setTitle("Open C")
                        .setOnClickListener {
                            screenManager.pushForResult(CScreen(carContext)) {
                                if (it != null) {
                                    setResult(it)
                                    finish()
                                }
                            }
                        }
                        .build()
                )
            )
            .build()
}
