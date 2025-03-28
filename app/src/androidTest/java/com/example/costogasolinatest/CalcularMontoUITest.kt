package com.example.costogasolinatest

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.costogasolinatest.ui.theme.CostoGasolinaTestTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat


class CalcularMontoUITest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calcularMonto_20l_24_95(){
        composeTestRule.setContent {
            CostoGasolinaTestTheme {
                CostGasLayout()
            }
        }
        composeTestRule.onNodeWithText("Ingresa precio por litro de Gasolina")
            .performTextInput("24.95")
        composeTestRule.onNodeWithText("Litros")
            .performTextInput("20")

        val montoEsperado = NumberFormat.getCurrencyInstance().format(499.0)

        composeTestRule.onNodeWithText("Monto Total: $montoEsperado")
            .assertExists("No se encontro ningún nodo (TextField) con el texto ingresado")
    }
}