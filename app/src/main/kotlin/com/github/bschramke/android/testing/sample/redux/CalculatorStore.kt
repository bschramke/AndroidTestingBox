package com.github.bschramke.android.testing.sample.redux

import me.tatarka.redux.Dispatcher
import me.tatarka.redux.SimpleStore
import me.tatarka.redux.Thunk
import me.tatarka.redux.ThunkDispatcher
import me.tatarka.redux.android.LogMiddleware

class CalculatorStore(initialState:CalculatoreState = CalculatoreState())
    : SimpleStore<CalculatoreState>(initialState) {

    private val dispatcher by lazy {
        Dispatcher.forStore(this,CalculatorReducer())
                .chain(LogMiddleware<CalculatorAction,CalculatorAction>("ACTION"))
    }

    private val thunkDispatcher by lazy { ThunkDispatcher(dispatcher) }

    fun dispatch(action:CalculatorAction):CalculatorAction {
        return dispatcher.dispatch(action)
    }

    fun dispatch(action:Thunk<CalculatorAction,CalculatorAction>) {
        thunkDispatcher.dispatch(action)
    }
}
