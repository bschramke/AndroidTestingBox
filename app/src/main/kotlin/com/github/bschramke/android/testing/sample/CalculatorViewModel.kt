package com.github.bschramke.android.testing.sample

import android.arch.lifecycle.LiveData
import android.util.Log
import android.view.View
import android.widget.Button
import com.github.bschramke.android.testing.sample.redux.CalculatorAction
import com.github.bschramke.android.testing.sample.redux.CalculatorStore
import com.github.bschramke.android.testing.sample.redux.CalculatoreState
import me.tatarka.redux.android.lifecycle.StoreViewModel

class CalculatorViewModel: StoreViewModel<CalculatoreState,CalculatorStore>(CalculatorStore()) {
    val text:String
        get() = state.value!!.text

    fun onClick(view: View) {
        when(view) {
            is Button -> onClickButton(view)
        }
    }

    private fun onClickButton(btn:Button) {
        when(btn.id) {
            R.id.btn_erase -> store.dispatch(CalculatorAction.ERASE)
            R.id.btn_clear -> store.dispatch(CalculatorAction.CLEAR)
            R.id.btn_plus -> store.dispatch(CalculatorAction.ADD)
            R.id.btn_mul -> store.dispatch(CalculatorAction.MUL)
            R.id.btn_minus -> store.dispatch(CalculatorAction.SUB)
            R.id.btn_div -> store.dispatch(CalculatorAction.DIV)
            R.id.btn_0 -> store.dispatch(CalculatorAction.NUM(0))
            R.id.btn_1 -> store.dispatch(CalculatorAction.NUM(1))
            R.id.btn_2 -> store.dispatch(CalculatorAction.NUM(2))
            R.id.btn_3 -> store.dispatch(CalculatorAction.NUM(3))
            R.id.btn_4 -> store.dispatch(CalculatorAction.NUM(4))
            R.id.btn_5 -> store.dispatch(CalculatorAction.NUM(5))
            R.id.btn_6 -> store.dispatch(CalculatorAction.NUM(6))
            R.id.btn_7 -> store.dispatch(CalculatorAction.NUM(7))
            R.id.btn_8 -> store.dispatch(CalculatorAction.NUM(8))
            R.id.btn_9 -> store.dispatch(CalculatorAction.NUM(9))
            else -> Log.d("Calculator", "Unknown button action")
        }
    }
}