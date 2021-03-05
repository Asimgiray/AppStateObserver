package com.example.appstateobserver;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

public class MyApp extends Application implements LifecycleObserver {

    private String TAG = MyApp.class.getSimpleName();
    private boolean DEBUG = true;
    public static StringBuilder appStates = new StringBuilder();

    @Override
    public void onCreate() {
        super.onCreate();

        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
                Log("ActivityCreated: " + activity.getClass().getSimpleName());
                appStates.append("ActivityCreated: ").append(activity.getClass().getSimpleName()).append("\n");
            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {
                Log("ActivityStarted: " + activity.getClass().getSimpleName());
                appStates.append("ActivityStarted: ").append(activity.getClass().getSimpleName()).append("\n");
            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {
                Log("ActivityResumed: " + activity.getClass().getSimpleName());
                appStates.append("ActivityResumed: ").append(activity.getClass().getSimpleName()).append("\n");
            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {
                Log("ActivityPaused: " + activity.getClass().getSimpleName());
                appStates.append("ActivityPaused: ").append(activity.getClass().getSimpleName()).append("\n");
            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {
                Log("ActivityStopped: " + activity.getClass().getSimpleName());
                appStates.append("ActivityStopped: ").append(activity.getClass().getSimpleName()).append("\n");
            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {
                Log("ActivitySavedInstanceState: " + activity.getClass().getSimpleName());
                appStates.append("ActivitySavedInstanceState: ").append(activity.getClass().getSimpleName()).append("\n");
            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {
                Log("ActivityDestroyed: " + activity.getClass().getSimpleName());
                appStates.append("ActivityDestroyed: ").append(activity.getClass().getSimpleName()).append("\n");
            }
        });

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onAppCreated() {
        Log("AppCreated");
        appStates.append("AppCreated" + "\n");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onAppForegrounded() {
        Log("AppForeground");
        appStates.append("AppStarted" + "\n");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onAppResumed() {
        Log("AppResumed");
        appStates.append("AppResumed" + "\n");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onAppPaused() {
        Log("AppPaused");
        appStates.append("AppPaused" + "\n");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onAppBackgrounded() {
        Log("AppStopped");
        appStates.append("AppStopped" + "\n");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onAppDestroyed() {
        Log("AppDestroyed");
        appStates.append("AppDestroyed" + "\n");
    }

    private void Log (String message){
        if(DEBUG)
            Log.d(TAG , message);
    }


}
