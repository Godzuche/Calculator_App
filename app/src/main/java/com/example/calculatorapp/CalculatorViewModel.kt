package com.example.calculatorapp

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction) {
        Log.d("Calculator Result = ", "action = $action")
        when (action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Operation -> addOperator(action.operation)
            is CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.Delete -> performDeletion()
        }
    }

    private fun performDeletion() {
        when {
            state.secondNumber.isNotBlank() -> state = state.copy(
                secondNumber = state.secondNumber.dropLast(1)
            )
            state.secondOperation != null -> state = state.copy(
                secondOperation = null
            )
            state.firstNumber.isNotBlank() -> state = state.copy(
                firstNumber = state.firstNumber.dropLast(1)
            )
            state.firstOperation != null -> state = state.copy(
                firstOperation = null
            )
        }
    }

    private fun performCalculation() {
        val firstNumber = state.firstNumber.toDoubleOrNull()
        val secondNumber = state.secondNumber.toDoubleOrNull()

        if (firstNumber != null && secondNumber != null) {

            val result = when (state.secondOperation) {
                is CalculatorOperation.Add -> {
                    if (state.firstOperation == CalculatorOperation.Subtract) {
                        -firstNumber + secondNumber
                    } else firstNumber + secondNumber
                }
                is CalculatorOperation.Subtract -> {
                    if (state.firstOperation == CalculatorOperation.Subtract) {
                        -firstNumber - secondNumber
                    } else firstNumber - secondNumber
                }
                is CalculatorOperation.Multiply -> {
                    if (state.firstOperation == CalculatorOperation.Subtract) {
                        -firstNumber * secondNumber
                    } else firstNumber * secondNumber
                }
                is CalculatorOperation.Divide -> {
                    if (state.firstOperation == CalculatorOperation.Subtract) {
                        -firstNumber / secondNumber
                    } else firstNumber / secondNumber
                }
                null -> return
            }

            state = state.copy(
                firstNumber = result.toString().take(15),
                secondNumber = "",
                firstOperation = null,
                secondOperation = null
            )
        }
    }

    private fun addOperator(operation: CalculatorOperation) {
        if (state.secondNumber.isNotBlank()) {
            return
        }
        if (state.firstNumber.isNotBlank()) {
            state = state.copy(secondOperation = operation)
            return
        }
        if (operation == CalculatorOperation.Divide || operation == CalculatorOperation.Multiply) {
            return
        }
        state = state.copy(
            firstOperation = operation
        )
    }

    private fun enterDecimal() {
        if (
            state.secondOperation == null && state.firstNumber.isNotBlank()
            && !state.firstNumber.contains(".")
        ) {
            state = state.copy(
                firstNumber = state.firstNumber + "."
            )
            return
        } else if (
            state.secondOperation != null && state.secondNumber.isNotBlank()
            && !state.secondNumber.contains(".")
        ) {
            state = state.copy(
                secondNumber = state.secondNumber + "."
            )
        }

    }

    private fun enterNumber(number: Int) {
        if (state.secondOperation == null) {
            if (state.firstNumber.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(
                firstNumber = state.firstNumber + number
            )
            return
        }
        if (state.secondNumber.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(
            secondNumber = state.secondNumber + number
        )
    }

    companion object {
        const val MAX_NUM_LENGTH = 8
    }
}
