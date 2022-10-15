package io.tohure.common

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.*

class NextScreen(carContext: CarContext) : Screen(carContext) {

    override fun onGetTemplate(): Template {
        return MessageTemplate.Builder("¡Hola a todos!")
            .setHeaderAction(Action.APP_ICON)
            .addAction(
                Action.Builder()
                    .setTitle("Siguiente")
                    .setOnClickListener { screenManager.push(MyCarScreen(carContext)) }
                    .build())
            .build()
    }
}