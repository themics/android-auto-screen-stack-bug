package com.example.auto.screenstackbug

import android.util.Log
import androidx.lifecycle.LifecycleEventObserver
import com.google.android.libraries.car.app.CarContext
import com.google.android.libraries.car.app.CarToast
import com.google.android.libraries.car.app.Screen
import com.google.android.libraries.car.app.model.Action
import com.google.android.libraries.car.app.model.MessageTemplate

class AScreen(carContext: CarContext) : Screen(carContext) {
    init {
        lifecycle.addObserver(LifecycleEventObserver { _, event ->
            Log.i("AScreen", "state: ${event.name}")
        })
    }

    override fun getTemplate() =
        MessageTemplate.builder("Screen A")
            .setHeaderAction(Action.APP_ICON)
            .setActions(
                listOf(
                    Action.builder()
                        .setTitle("Open B")
                        .setOnClickListener {
                            screenManager.pushForResult(BScreen(carContext)) {
                                (it as? String)?.let { message ->
                                    CarToast.makeText(carContext, message, CarToast.LENGTH_SHORT).show()
                                }
                            }
                        }
                        .build()
                )
            )
            .build()
}
