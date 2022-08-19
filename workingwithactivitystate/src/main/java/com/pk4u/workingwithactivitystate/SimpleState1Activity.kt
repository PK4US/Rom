package com.pk4u.workingwithactivitystate

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import com.pk4u.workingwithactivitystate.databinding.ActivitySimpleState1Binding
import kotlin.random.Random

class SimpleState1Activity : AppCompatActivity() {
    lateinit var binding: ActivitySimpleState1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleState1Binding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.IncrementButton.setOnClickListener{increment()}
        binding.RandomColorButton.setOnClickListener{setRandomColor()}
        binding.SwitchVisibilityButton.setOnClickListener{switchVisibility()}
    }

    private fun increment() {
        var counter = binding.counterTextView.text.toString().toInt()
        counter++
        binding.counterTextView.text = counter.toString()
    }

    private fun setRandomColor() {

        val randomColor = Color.rgb(
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
        binding.counterTextView.setTextColor(randomColor)
    }

    private fun switchVisibility() {
        binding.counterTextView.visibility = if(binding.counterTextView.visibility==VISIBLE)
            INVISIBLE
        else
            VISIBLE
    }
}