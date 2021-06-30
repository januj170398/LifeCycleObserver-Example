package com.example.lifecycleobserverexample

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyObserver(private val context: Context?, private val lifecycle: Lifecycle): LifecycleObserver {

    private val TAG = "Observer"

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun eventResume(){
        Log.i(TAG,"Lifecycle.Event.ON_RESUME")
        Toast.makeText(context,"Lifecycle.Event.ON_RESUME",Toast.LENGTH_SHORT).show()
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun eventCreate(){
        Log.i(TAG,"Lifecycle.Event.ON_CREATE")
        Toast.makeText(context,"Lifecycle.Event.ON_CREATE",Toast.LENGTH_SHORT).show()
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun eventDestroy(){
        Log.i(TAG,"Lifecycle.Event.ON_DESTROY")
        Toast.makeText(context,"Lifecycle.Event.ON_DESTROY",Toast.LENGTH_SHORT).show()

    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun eventPause(){
        Log.i(TAG,"Lifecycle.Event.ON_PAUSE")
        Toast.makeText(context,"Lifecycle.Event.ON_PAUSE",Toast.LENGTH_SHORT).show()
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun eventStart(){
        Log.i(TAG,"Lifecycle.Event.ON_START")
        Toast.makeText(context,"Lifecycle.Event.ON_START",Toast.LENGTH_SHORT).show()
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun eventStop(){
        Log.i(TAG,"Lifecycle.Event.ON_STOP")
        Toast.makeText(context,"Lifecycle.Event.ON_STOP",Toast.LENGTH_SHORT).show()
    }
}