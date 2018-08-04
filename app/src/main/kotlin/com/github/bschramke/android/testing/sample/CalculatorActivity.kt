package com.github.bschramke.android.testing.sample

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.bschramke.android.testing.sample.databinding.ActivityCalculatorBinding
import com.github.bschramke.android.testing.sample.redux.CalculatorStore

class CalculatorActivity : AppCompatActivity() {

    private lateinit var binding:ActivityCalculatorBinding
    private val viewModel by lazy { ViewModelProviders.of(this).get(CalculatorViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_calculator)
        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)
    }
}
