package com.example.lifecycleobserverexample

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import com.example.lifecycleobserverexample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myObserver : MyObserver
    val fragmentManager = BlankFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        buttonPressed()
        myObserver = MyObserver(this,lifecycle)
        lifecycle.addObserver(myObserver)


    }

    private fun buttonPressed(){
        binding.button.setOnClickListener{
            if(lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
            }
        }
        binding.buttonAlert.setOnClickListener{
            showAlertDialog()
        }
        binding.buttonFragment.setOnClickListener{
            openFragment()
        }
    }

    private fun openFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.mainLayout,BlankFragment()).commit()
        binding.buttonFragment.visibility = View.GONE
        binding.button.visibility = View.GONE
        binding.buttonAlert.visibility = View.GONE

    }

    private fun showAlertDialog() {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
        alertDialog.setTitle("AlertDialog")
        alertDialog.setMessage("Do you wanna close this Dialog?")
        alertDialog.setPositiveButton(
            "yes"
        ) { _, _ ->
            Toast.makeText(this@MainActivity, "Alert dialog closed.", Toast.LENGTH_LONG).show()
        }
        alertDialog.setNegativeButton(
            "No"
        ) { _, _ -> }
        val alert: AlertDialog = alertDialog.create()
        alert.setCanceledOnTouchOutside(false)
        alert.show()
    }
}


