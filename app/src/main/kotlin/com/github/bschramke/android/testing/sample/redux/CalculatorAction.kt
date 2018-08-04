package com.github.bschramke.android.testing.sample.redux

sealed class CalculatorAction {
    data class NUM(val value:Int):CalculatorAction()
    object CLEAR:CalculatorAction()
    object ERASE:CalculatorAction()
    object ADD:CalculatorAction()
    object SUB:CalculatorAction()
    object MUL:CalculatorAction()
    object DIV:CalculatorAction()
}