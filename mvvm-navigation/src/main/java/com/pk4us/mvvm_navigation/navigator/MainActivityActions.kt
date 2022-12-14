package com.pk4us.mvvm_navigation.navigator

import com.pk4us.mvvm_navigation.MainActivity

typealias MainActivityAction = (MainActivity) -> Unit

/**
 * This class executes actions only when activity is assigned to [mainActivity] field.
 * See setup logic and usage example in [MainNavigator] and [MainActivity]
 */
class MainActivityActions {

    /**
     * Assign activity in [MainActivity.onResume] and assign NULL in [MainActivity.onPause]
     */
    var mainActivity: MainActivity? = null
        set(activity) {
            field = activity
            if (activity != null) {
                actions.forEach { it(activity) }
                actions.clear()
            }
        }

    private val actions = mutableListOf<MainActivityAction>()

    /**
     * Invoke operator allows using this class like this:
     *
     * ```
     * val runActionSafely = MainActivityActions()
     * fun doSomeActivityDependentLogic() = runActionSafely { activity ->
     *   // do navigation stuffs here
     * }
     * ```
     */
    operator fun invoke(action: MainActivityAction) {
        val activity = this.mainActivity
        if (activity == null) {
            actions += action
        } else {
            action(activity)
        }
    }

    /**
     * Call this method in navigator's [MainNavigator.onCleared]
     */
    fun clear() {
        actions.clear()
    }

}