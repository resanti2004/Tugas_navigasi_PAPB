package com.example.cinemaxx1

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.cinemaxx1.databinding.ActivityDetailsBinding

class details : AppCompatActivity() {
    private val TAG = "MainActivityLifecycle"
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate: dipanggil")

        with(binding) {
            toolbar.setOnClickListener{
                val intent = Intent(this@details, HomeFragment::class.java)
                startActivity(intent)
            }

            button1.setOnClickListener{
                val intent = Intent(this@details, PaymentActivity::class.java)
                startActivity(intent)
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "OnStart: dipanggil")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "OnResume: dipanggil")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "OnPause: dipanggil")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "OnStop: dipanggil")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "OnDestroy: dipanggil")
    }
}