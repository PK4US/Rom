package com.pk4us.mvvm_navigation.screens.base


import androidx.fragment.app.Fragment
import com.pk4us.mvvm_navigation.screens.base.BaseViewModel

/**
 * Base class for all fragments
 */
abstract class BaseFragment : Fragment() {

    /**
     * View-model that manages this fragment
     */
    abstract val viewModel: BaseViewModel

}