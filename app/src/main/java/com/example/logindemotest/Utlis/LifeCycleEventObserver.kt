package com.example.logindemotest.Utlis

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

private const val TAG = "LifeCycleEventObserver"
object LifeCycleEventObserver {

    fun lifeCycleEventListener(lifecycleOwner: LifecycleOwner, lifeCycleCallBack:(String) -> Unit) {

        lifecycleOwner.lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onResume(owner: LifecycleOwner) {
                Log.d(TAG, "onResume: ")
                lifeCycleCallBack("onResume")
            }

            override fun onPause(owner: LifecycleOwner) {
                Log.d(TAG, "onPause: ")
                lifeCycleCallBack("onPause")
            }

            override fun onDestroy(owner: LifecycleOwner) {
                Log.d(TAG, "onDestroy: ")
                lifeCycleCallBack("onDestroy")
            }

            override fun onStop(owner: LifecycleOwner) {
                Log.d(TAG, "onStop: ")
                lifeCycleCallBack("onStop")
            }

        })
    }
}