package com.example.cinemaxx1

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.cinemaxx1.databinding.ActivitySummaryBinding

class summary : AppCompatActivity() {
    private lateinit var binding: ActivitySummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengambil nilai dari intent
        val selectedBioskop = intent.getStringExtra(PaymentActivity.EXTRA_BIOSKOP)
        val selectedSeat = intent.getStringExtra(PaymentActivity.EXTRA_SEAT)
        val selectedTanggal = intent.getStringExtra(PaymentActivity.EXTRA_TANGGAL)
        val selectedBank = intent.getStringExtra(PaymentActivity.EXTRA_BANK)
        val harga = intent.getIntExtra(PaymentActivity.EXTRA_HARGA, 0)

        with(binding) {
            // Update TextView dengan nilai yang diterima
            textView14.text = selectedBioskop
            textView15.text = selectedTanggal
            textView23.text = selectedSeat
            textView19.text = selectedSeat
            textView28.text = "$selectedBank"
            textView25.text = "$harga"
            textView27.text = "$harga"

        }
    }
}