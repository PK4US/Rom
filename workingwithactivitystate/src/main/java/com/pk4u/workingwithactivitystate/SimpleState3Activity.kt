package com.pk4u.workingwithactivitystate

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.pk4u.workingwithactivitystate.databinding.ActivitySimpleState1Binding
import kotlin.properties.Delegates.notNull
import kotlin.random.Random

class SimpleState3Activity : AppCompatActivity() {
    private lateinit var binding: ActivitySimpleState1Binding

    private val viewModel by viewModels<SimpleState3ViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleState1Binding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.IncrementButton.setOnClickListener{viewModel.increment()}
        binding.RandomColorButton.setOnClickListener{viewModel.setRandomColor()}
        binding.SwitchVisibilityButton.setOnClickListener{viewModel.switchVisibility()}

        if (viewModel.state.value == null){
            viewModel.initState(
                SimpleState3ViewModel.State(
                    countValue = 0,
                    countTextColor = ContextCompat.getColor(this, R.color.purple_700),
                    countIsVisible = true
                )
            )
        }
        viewModel.state.observe(this, Observer {
            renderState(it)
        })
    }

    private fun renderState(state: SimpleState3ViewModel.State) {
        binding.counterTextView.text = state.countValue.toString()
        binding.counterTextView.setTextColor( state.countTextColor)
        binding.counterTextView.visibility = if ( state.countIsVisible) VISIBLE else INVISIBLE
    }
}