package io.tohure.common

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.*

class MyCarScreen(carContext: CarContext) : Screen(carContext) {

    override fun onGetTemplate(): Template {

        val row = Row.Builder().setTitle("¡¡¡Hola GDG Santo Domingo!!!").build()

        return PaneTemplate.Builder(Pane.Builder().addRow(row).build())
            .setHeaderAction(Action.BACK)
            .build()
    }

}