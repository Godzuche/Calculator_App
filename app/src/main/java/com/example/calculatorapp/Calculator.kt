package com.example.calculatorapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorapp.ui.theme.LightGray
import com.example.calculatorapp.ui.theme.Orange

@Composable
fun CalculatorScreen(
    state: CalculatorState,
    onAction: (CalculatorAction) -> Unit,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(
            space = buttonSpacing,
            alignment = Alignment.Bottom
        ),
        modifier = Modifier
            .fillMaxSize()
            .then(modifier)
    ) {
        // Results to be displayed
        val firstOperator = state.firstOperation?.symbol ?: ""
        val secondOperator = state.secondOperation?.symbol ?: ""
        val firstNumber = state.firstNumber
        val secondNumber = state.secondNumber

        Text(
            text = firstOperator + firstNumber + secondOperator + secondNumber,
            textAlign = TextAlign.End,
            fontWeight = FontWeight.Light,
            fontSize = 80.sp,
            color = Color.White,
            maxLines = 2,
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
        )

        // Row 1
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            // Clear Button
            CalculatorButton(
                symbol = "AC",
                modifier = Modifier
                    .background(LightGray)
                    // make it's width twice as wide as a normal button
                    .aspectRatio(2f)
                    .weight(2f),
                onClick = {
                    onAction(CalculatorAction.Clear)
                }
            )
            // Delete Button
            CalculatorButton(
                symbol = "Del",
                modifier = Modifier
                    .background(LightGray)
                    // make it's width twice as wide as a normal button
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                    onAction(CalculatorAction.Delete)
                }
            )
            // Divide button
            CalculatorButton(
                symbol = "/",
                modifier = Modifier
                    .background(Orange)
                    // make it's width twice as wide as a normal button
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                    onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                }
            )
        }

        // Row 2
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            // Number 7 Button
            CalculatorButton(
                symbol = "7",
                modifier = Modifier
                    .background(Color.DarkGray)
                    // make it's width twice as wide as a normal button
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                    onAction(CalculatorAction.Number(7))
                }
            )
            // Number 8 Button
            CalculatorButton(
                symbol = "8",
                modifier = Modifier
                    .background(Color.DarkGray)
                    // make it's width twice as wide as a normal button
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                    onAction(CalculatorAction.Number(8))
                }
            )
            // Number 9 Button
            CalculatorButton(
                symbol = "9",
                modifier = Modifier
                    .background(Color.DarkGray)
                    // make it's width twice as wide as a normal button
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                    onAction(CalculatorAction.Number(9))
                }
            )
            // Multiply Button
            CalculatorButton(
                symbol = "x",
                modifier = Modifier
                    .background(Orange)
                    // make it's width twice as wide as a normal button
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                    onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                }
            )
        }

        // Row 3
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            // Number 4 Button
            CalculatorButton(
                symbol = "4",
                modifier = Modifier
                    .background(Color.DarkGray)
                    // make it's width twice as wide as a normal button
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                    onAction(CalculatorAction.Number(4))
                }
            )
            // Number 5 Button
            CalculatorButton(
                symbol = "5",
                modifier = Modifier
                    .background(Color.DarkGray)
                    // make it's width twice as wide as a normal button
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                    onAction(CalculatorAction.Number(5))
                }
            )
            // Number 6 Button
            CalculatorButton(
                symbol = "6",
                modifier = Modifier
                    .background(Color.DarkGray)
                    // make it's width twice as wide as a normal button
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                    onAction(CalculatorAction.Number(6))
                }
            )
            // Subtract Button
            CalculatorButton(
                symbol = "-",
                modifier = Modifier
                    .background(Orange)
                    // make it's width twice as wide as a normal button
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                    onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                }
            )
        }
        // Row 4
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            // Number 1 Button
            CalculatorButton(
                symbol = "1",
                modifier = Modifier
                    .background(Color.DarkGray)
                    // make it's width twice as wide as a normal button
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                    onAction(CalculatorAction.Number(1))
                }
            )
            // Number 2 Button
            CalculatorButton(
                symbol = "2",
                modifier = Modifier
                    .background(Color.DarkGray)
                    // make it's width twice as wide as a normal button
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                    onAction(CalculatorAction.Number(2))
                }
            )
            // Number 3 Button
            CalculatorButton(
                symbol = "3",
                modifier = Modifier
                    .background(Color.DarkGray)
                    // make it's width twice as wide as a normal button
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                    onAction(CalculatorAction.Number(3))
                }
            )
            // Add Button
            CalculatorButton(
                symbol = "+",
                modifier = Modifier
                    .background(Orange)
                    // make it's width twice as wide as a normal button
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                    onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                }
            )
        }

        // Row 5
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            // Number 0 Button
            CalculatorButton(
                symbol = "0",
                modifier = Modifier
                    .background(Color.DarkGray)
                    // make it's width twice as wide as a normal button
                    .aspectRatio(2f)
                    .weight(2f),
                onClick = {
                    onAction(CalculatorAction.Number(0))
                }
            )
            // Decimal Button
            CalculatorButton(
                symbol = ".",
                modifier = Modifier
                    .background(Color.DarkGray)
                    // make it's width twice as wide as a normal button
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                    onAction(CalculatorAction.Decimal)
                }
            )
            // Calculate Button
            CalculatorButton(
                symbol = "=",
                modifier = Modifier
                    .background(Orange)
                    // make it's width twice as wide as a normal button
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                    onAction(CalculatorAction.Calculate)
                }
            )
        }
    }
}