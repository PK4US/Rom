package com.pk4u.workingwithactivitystate

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.core.content.ContextCompat
import com.pk4u.workingwithactivitystate.databinding.ActivitySimpleState1Binding
import kotlin.properties.Delegates.notNull
import kotlin.random.Random

class SimpleState2Activity : AppCompatActivity() {
    lateinit var binding: ActivitySimpleState1Binding

    private var counterValue by notNull<Int>()
    private var counterTextColor by notNull<Int>()
    private var counterIsVisible by notNull<Boolean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleState1Binding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.IncrementButton.setOnClickListener{increment()}
        binding.RandomColorButton.setOnClickListener{setRandomColor()}
        binding.SwitchVisibilityButton.setOnClickListener{switchVisibility()}

        if (savedInstanceState == null){
            counterValue = 0
            counterTextColor = ContextCompat.getColor(this,R.color.purple_700)
            counterIsVisible = true
        }else{
            counterValue = savedInstanceState.getInt(KEY_COUNTER)
            counterTextColor = savedInstanceState.getInt(KEY_COLOR)
            counterIsVisible = savedInstanceState.getBoolean(KEY_IS_VISIBLE)
        }
        renderState()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNTER,counterValue)
        outState.putInt(KEY_COLOR,counterTextColor)
        outState.putBoolean(KEY_IS_VISIBLE,counterIsVisible)
    }

    private fun increment() {
        counterValue++
        renderState()
    }

    private fun setRandomColor() {
        counterTextColor = Color.rgb(
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
        renderState()
    }

    private fun switchVisibility() {
        counterIsVisible = !counterIsVisible
        renderState()
    }

    private fun renderState() {
        binding.counterTextView.text = counterValue.toString()
        binding.counterTextView.setTextColor(counterTextColor)
        binding.counterTextView.visibility = if (counterIsVisible) VISIBLE else INVISIBLE
    }

    companion object{
        private const val KEY_COUNTER = "COUNTER"
        private const val KEY_COLOR = "COLOR"
        private const val KEY_IS_VISIBLE = "IS_VISIBLE"
    }

}