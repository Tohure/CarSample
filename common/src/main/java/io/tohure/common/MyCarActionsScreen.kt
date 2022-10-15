package io.tohure.common

import android.content.Intent
import android.net.Uri
import androidx.car.app.CarContext
import androidx.car.app.CarToast
import androidx.car.app.Screen
import androidx.car.app.model.*

class MyCarActionsScreen(carContext: CarContext) : Screen(carContext) {

    override fun onGetTemplate(): Template {
        val listBuilder = ItemList.Builder()

        //Mandar a otra pantalla
        listBuilder.addItem(
            GridItem.Builder()
                .setTitle("Next Screen")
                .setImage(CarIcon.ALERT)
                .setOnClickListener { screenManager.push(MyCarScreen(carContext)) }
                .build()
        )

        //Simple Call Action
        listBuilder.addItem(
            GridItem.Builder()
                .setTitle("Llamar Mapa")
                .setImage(CarIcon.PAN)
                .setOnClickListener(::launchMap)
                .build()
        )

        //Call classic toast
        listBuilder.addItem(
            GridItem.Builder()
                .setTitle("Lanzar Toast")
                .setImage(CarIcon.ERROR)
                .setOnClickListener {
                    CarToast.makeText(carContext, "¡Parezco un Toast pero soy un CarToast!", CarToast.LENGTH_SHORT).show()
                }
                .build()
        )

        return GridTemplate.Builder()
            .setSingleList(listBuilder.build())
            .setTitle("Acciones disponibles")
            .setHeaderAction(Action.APP_ICON)
            .build()


    }

    private fun launchMap() {
        carContext.startCarApp(
            Intent(
                CarContext.ACTION_NAVIGATE, Uri.parse("geo:0,0?q=UNAPEC")
            )
        )
    }

}