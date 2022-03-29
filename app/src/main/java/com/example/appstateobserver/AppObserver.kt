package com.example.appstateobserver

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner


class AppObserver : Application(), LifecycleEventObserver {
    
    private val activity = "Activity : "
    private val fragment = "Fragment "
    private val application = "Application : "

    override fun onCreate() {
        super.onCreate()

        FragmentActivity().supportFragmentManager.registerFragmentLifecycleCallbacks(object : FragmentLifecycleCallbacks(){

            override fun onFragmentPreAttached(fm: FragmentManager, f: Fragment, context: Context) {
                Log.d(fragment, f.javaClass.simpleName + " preAttached")
            }

            override fun onFragmentAttached(fm: FragmentManager, f: Fragment, context: Context) {
                Log.d(fragment, f.javaClass.simpleName + " attached")
            }

            override fun onFragmentPreCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
                Log.d(fragment, f.javaClass.simpleName + " preCreated")
            }

            override fun onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
                Log.d(fragment, f.javaClass.simpleName + " created")
            }

            override fun onFragmentActivityCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
                Log.d(fragment, f.javaClass.simpleName + " fragmentActivityCreated")
            }

            override fun onFragmentViewCreated(fm: FragmentManager, f: Fragment, v: View, savedInstanceState: Bundle?) {
                Log.d(fragment, f.javaClass.simpleName + " viewCreated")
            }

            override fun onFragmentStarted(fm: FragmentManager, f: Fragment) {
                Log.d(fragment, f.javaClass.simpleName + " started")
            }

            override fun onFragmentResumed(fm: FragmentManager, f: Fragment) {
                Log.d(fragment, f.javaClass.simpleName + " resumed")
            }

            override fun onFragmentPaused(fm: FragmentManager, f: Fragment) {
                Log.d(fragment, f.javaClass.simpleName + " paused")
            }

            override fun onFragmentStopped(fm: FragmentManager, f: Fragment) {
                Log.d(fragment, f.javaClass.simpleName + " stopped")
            }

            override fun onFragmentSaveInstanceState(fm: FragmentManager, f: Fragment, outState: Bundle) {
                Log.d(fragment, f.javaClass.simpleName + " saveInstanceState")
            }

            override fun onFragmentViewDestroyed(fm: FragmentManager, f: Fragment) {
                Log.d(fragment, f.javaClass.simpleName + " viewDestroyed")
            }

            override fun onFragmentDestroyed(fm: FragmentManager, f: Fragment) {
                Log.d(fragment, f.javaClass.simpleName + " destroyed")
            }

            override fun onFragmentDetached(fm: FragmentManager, f: Fragment) {
                Log.d(fragment, f.javaClass.simpleName + " detached")
            }
        }, true )

        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks{
            override fun onActivityCreated(act: Activity, p1: Bundle?) {
                Log.d(activity, act.javaClass.simpleName + " created")
            }

            override fun onActivityStarted(act: Activity) {
                Log.d(activity, act.javaClass.simpleName + " started")
            }

            override fun onActivityResumed(act: Activity) {
                Log.d(activity, act.javaClass.simpleName + " resumed")
            }

            override fun onActivityPaused(act: Activity) {
                Log.d(activity, act.javaClass.simpleName + " paused")
            }

            override fun onActivityStopped(act: Activity) {
                Log.d(activity, act.javaClass.simpleName + " stopped")
            }

            override fun onActivitySaveInstanceState(act: Activity, p1: Bundle) {
                Log.d(activity, act.javaClass.simpleName + " saveInstanceState")
            }

            override fun onActivityDestroyed(act: Activity) {
                Log.d(activity, act.javaClass.simpleName + " destroyed")
            }
        })
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
                Log.d(application, "onCreate")
            }
            Lifecycle.Event.ON_RESUME -> {
                Log.d(application, "onResume")
            }
            Lifecycle.Event.ON_START -> {
                Log.d(application, "onStart")
            }
            Lifecycle.Event.ON_PAUSE -> {
                Log.d(application, "onPause")
            }
            Lifecycle.Event.ON_STOP -> {
                Log.d(application, "onStop")
            }
            Lifecycle.Event.ON_DESTROY -> {
                Log.d(application, "onDestroy")
            }
            Lifecycle.Event.ON_ANY -> {
                Log.d(application, "onAny")
            }
        }
    }
}





