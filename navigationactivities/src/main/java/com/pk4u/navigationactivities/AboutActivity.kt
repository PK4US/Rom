package com.pk4u.navigationactivities

import android.os.Bundle
import androidx.viewbinding.BuildConfig
import com.pk4u.navigationactivities.databinding.ActivityAboutBinding

class AboutActivity : BaseActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater).also { setContentView(it.root) }
        binding.versionNameTextView.text = "1.0"
        binding.versionCodeTextView.text = "1.0.0"
        binding.okButton.setOnClickListener { onOkPressed() }
    }

    private fun onOkPressed() {
        finish()
    }

}