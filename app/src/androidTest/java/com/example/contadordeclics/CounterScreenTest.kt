package com.example.contadordeclics

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule


@RunWith(AndroidJUnit4::class)
class CounterScreenTest {
    // 1. La regla de Compose es necesaria para poder probar componentes UI.
    // Esto crea un entorno de UI virtual para nuestra prueba.
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun cuando_el_boton_es_pulsado_el_texto_del_contador_se_actualiza() {
        // 2. Preparación: Establece el contenido de UI en el entorno de prueba.
        // Usamos un estado mutable para que la UI se actualice cuando cambie.
        var count by mutableIntStateOf(0)
        composeTestRule.setContent {
            CounterScreenStateless(
                count = count,
                onIncrement = { count++ }
            )
        }

        // 3. Acción: Simula la interacción del usuario.
        // onNodeWithText() busca un elemento en la pantalla que contenga ese texto.
        // performClick() simula un clic en ese elemento.
        composeTestRule.onNodeWithText("Pulsa aquí").performClick()

        // 4. Verificación: Asegura que el UI ha cambiado como se espera.
        // onNodeWithText() ahora busca el nuevo texto.
        // assertIsDisplayed() verifica que el elemento es visible en la pantalla.
        composeTestRule.onNodeWithText("Has pulsado 1 veces").assertIsDisplayed()
    }
}