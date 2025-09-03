package com.example.contadordeclics

import org.junit.Test
import org.junit.Assert.*

class CounterTest {

    // La anotación @Test indica a la librería de pruebas que esta función es una prueba unitaria.
    @Test
    fun `cuando el contador incrementa, el valor se actualiza correctamente`() {
        // 1. Preparación: Define el valor inicial.
        val initialCount = 5

        // 2. Acción: Llama a la función que estás probando.
        val newCount = increment(initialCount)

        // 3. Verificación: Comprueba que el resultado es el esperado.
        // assertEquals(valor_esperado, valor_obtenido)
        assertEquals(6, newCount)
    }

    @Test
    fun `incrementar desde cero resulta en uno`() {
        // Esta es otra prueba para un caso de uso específico.
        assertEquals(1, increment(0))
    }
}