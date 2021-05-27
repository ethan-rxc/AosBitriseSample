package com.sample.bollsal.extension

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.annotation.IdRes
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun Activity.isSafelyWindowToken(): Boolean {
    return !this.isDestroyed && !this.isFinishing
}

fun Fragment.isSafe(): Boolean {
    return !(this.isRemoving || this.activity == null || this.isDetached || !this.isAdded || this.view == null)
}

fun <T> createIntent(
    context: Context,
    clazz: Class<out T>,
    params: Array<out Pair<String, Any?>>
) = Intent(context, clazz).apply { putExtras(bundleOf(*params)) }

inline fun <reified T : Activity> Context.startActivity(
    vararg param: Pair<String, Any?>,
    intentAction: Intent.() -> Unit = {}
) {
    val intent = createIntent(this, T::class.java, param).apply(intentAction)
    startActivity(intent)
}

inline fun <reified T : Activity> Fragment.startActivity(
    vararg param: Pair<String, Any?>,
    intentAction: Intent.() -> Unit = {}
) {
    val intent = createIntent(requireContext(), T::class.java, param).apply(intentAction)
    startActivity(intent)
}

inline fun <reified T : Fragment> FragmentActivity.replaceFragment(
    @IdRes containerViewId: Int,
    vararg param: Pair<String, Any?>,
    tag: String = T::class.java.simpleName
) {
    findFragment() ?: T::class.java.newInstance().also { newFragment ->
        newFragment.arguments = bundleOf(*param)
        supportFragmentManager.beginTransaction()
            .replace(containerViewId, newFragment, tag)
            .commitAllowingStateLoss()
    }
}

inline fun <reified T : Fragment> FragmentActivity.findFragment(tag: String = T::class.java.simpleName): T? {
    return supportFragmentManager.findFragmentByTag(tag) as? T
}

inline fun <reified T : Fragment> Fragment.replaceFragment(
    @IdRes containerViewId: Int,
    vararg param: Pair<String, Any?>,
    tag: String = T::class.java.simpleName
) {
    findFragment() ?: T::class.java.newInstance().also { newFragment ->
        newFragment.arguments = bundleOf(*param)
        childFragmentManager.beginTransaction()
            .replace(containerViewId, newFragment, tag)
            .commitAllowingStateLoss()
    }
}

inline fun <reified T : Fragment> Fragment.findFragment(tag: String = T::class.java.simpleName): T? {
    return childFragmentManager.findFragmentByTag(tag) as? T
}
