package com.pk4u.navigationfragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.BuildConfig
import com.pk4u.navigationfragments.R
import com.pk4u.navigationfragments.contract.HasCustomTitle
import com.pk4u.navigationfragments.contract.navigator
import com.pk4u.navigationfragments.databinding.FragmentAboutBinding

class AboutFragment : Fragment(), HasCustomTitle {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentAboutBinding.inflate(inflater, container, false).apply {
        versionNameTextView.text = "1.0.0"
        versionCodeTextView.text = "1.0"
        okButton.setOnClickListener { onOkPressed() }
    }.root

    override fun getTitleRes(): Int = R.string.about

    private fun onOkPressed() {
        navigator().goBack()
    }

}