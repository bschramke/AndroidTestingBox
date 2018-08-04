package com.github.bschramke.android.testing.sample.redux

import me.tatarka.redux.Reducer

class CalculatorReducer:Reducer<CalculatorAction,CalculatoreState>{
    override fun reduce(action: CalculatorAction, currentState: CalculatoreState): CalculatoreState {
        return when(action) {
            is CalculatorAction.CLEAR -> CalculatoreState()
            is CalculatorAction.ERASE -> currentState.copy(currentState.text.dropLast(1))
            is CalculatorAction.NUM -> currentState.copy(currentState.text + action.value)
            is CalculatorAction.ADD -> currentState.copy(currentState.text + " + ")
            is CalculatorAction.SUB -> currentState.copy(currentState.text + " - ")
            is CalculatorAction.MUL -> currentState.copy(currentState.text + " \u00D7 ")
            is CalculatorAction.DIV -> currentState.copy(currentState.text + " \u00F7 ")
        }
    }
}