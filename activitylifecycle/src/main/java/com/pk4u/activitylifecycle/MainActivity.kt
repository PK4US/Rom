package com.pk4u.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.pk4u.activitylifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate, saveState =  $savedInstanceState")

        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.buttonShowAnotherActivity.setOnClickListener{
            startActivity(Intent(this,SecondActivity::class.java))
        }

        binding.buttonShowTransparentActivity.setOnClickListener{
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),1)
        }

        binding.buttonShowAnotherActivity.setOnClickListener{
            moveTaskToBack(false)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG,"onSaveInstanceState")
    }

    companion object{
        val TAG = MainActivity::class.simpleName
    }
}