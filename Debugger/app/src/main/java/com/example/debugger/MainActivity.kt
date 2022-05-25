package com.example.debugger

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"This is where the app crashes before")
        setContentView(R.layout.activity_main)
        Log.d(TAG, "This should be logged if the bug is fixed")
        val helloTextView: TextView = findViewById(R.id.hello_world)
        helloTextView.text = "Hello, debugging!"
        logging()
        division()
    }

    private fun division() {
        val num = 60
        var den = 4
        repeat(5){
            Log.d(TAG, "$den")
            Log.v(TAG, "${num/den}")
            den--
        }
    }

    private fun logging() {
        Log.e(TAG, "ERROR: a serious error like an app crash")
        Log.w(TAG, "WARN: warns about the potential for serious errors")
        Log.i(TAG, "INFO: reporting technical information, such as an operation succeeding")
        Log.d(TAG, "DEBUG: reporting technical information useful for debugging")
        Log.v(TAG, "VERBOSE: more verbose than DEBUG logs")
    }
}