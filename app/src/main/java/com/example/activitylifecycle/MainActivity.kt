package com.example.activitylifecycle

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.activitylifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //callDialogIntent()
        //Even though we call dialog themed intent in onCreate(), activity will not
        //directly go to pause state. It will go to start and resume state before
        //going into pause state.

        Log.d(TAG, "onCreate: ")

        initListeners();
    }

    private fun initListeners() {

        binding.intentDialogBtn.setOnClickListener {
            callDialogIntent()
        }

        binding.alertDialogBtn.setOnClickListener {
            callAlertDialog()
        }

        binding.dialogBtn.setOnClickListener {
            callDialog()
        }

    }

    private fun callDialog() {

        val dialog = Dialog(this)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.dialog_layout)
        val ok = dialog.findViewById(R.id.OK) as Button
        val cancel = dialog.findViewById(R.id.Cancel) as Button
        ok.setOnClickListener{
            Toast.makeText(this, "Clicked OK!", Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }

        cancel.setOnClickListener {
            Toast.makeText(this, "Cancelled!", Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }

        dialog.show()
    }

    fun callAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Android Alert")
        builder.setMessage("We have a message")

        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
            Toast.makeText(applicationContext,
                "Yes", Toast.LENGTH_SHORT).show()
        }

        builder.setNegativeButton(android.R.string.no) { dialog, which ->
            Toast.makeText(applicationContext,
                "No", Toast.LENGTH_SHORT).show()
        }

        builder.setNeutralButton("Maybe") { dialog, which ->
            Toast.makeText(applicationContext,
                "Maybe", Toast.LENGTH_SHORT).show()
        }

        builder.show()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    fun callDialogIntent() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }

    override fun onPostResume() {
        super.onPostResume()
        Log.d(TAG, "onPostResume: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }
}