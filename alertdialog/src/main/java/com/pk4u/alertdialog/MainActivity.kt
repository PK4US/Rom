package com.pk4u.alertdialog

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pk4u.alertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.level1Button.setOnClickListener {
            startActivity(Intent(this, DialogsLevel1Activity::class.java))
        }

        binding.level2Button.setOnClickListener {
            startActivity(Intent(this, DialogsLevel2Activity::class.java))
        }

        binding.exitButton.setOnClickListener {
            finish()
        }
    }

}