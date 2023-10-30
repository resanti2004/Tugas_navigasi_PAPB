package com.example.cinemaxx1

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.cinemaxx1.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentBinding

    companion object {
        const val EXTRA_BIOSKOP = "EXT_BIOSKOP"
        const val EXTRA_SEAT = "EXT_SEAT"
        const val EXTRA_TANGGAL = "EXT_TANGGAL"
        const val EXTRA_BANK = "EXT_BANK"
        const val EXTRA_HARGA = "EXT_HARGA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bioskop = arrayOf(
            "Empire XXI",
            "Ambarrukmo XXI",
            "CGV J-Walk",
            "Jogja City XXI",
            "CGV Pakuwon Mall",
            "Sleman City Hall XXI",
            "CGV Transmart Maguwo"
        )

        val seat = arrayOf(
            "Regular 2D",
            "RealD 3D",
            "Sphere X",
            "Screen X",
            "Sweetbox",
            "Gold Class",
            "Satin Suite"
        )

        val payment = arrayOf(
            "Transfer Bank",
            "Tunai"
        )

        val bank = arrayOf(
            "MANDIRI",
            "BCA",
            "BNI",
            "BRI",
            "BSI"
        )

        with(binding) {
            val bioskopAdapter = ArrayAdapter(
                this@PaymentActivity,
                R.layout.simple_spinner_dropdown_item, bioskop
            )
            bioskopAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinBioskop.adapter = bioskopAdapter

            val seatAdapter = ArrayAdapter(
                this@PaymentActivity,
                R.layout.simple_spinner_dropdown_item, seat
            )
            seatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinSeat.adapter = seatAdapter

            val paymentAdapter = ArrayAdapter(
                this@PaymentActivity,
                R.layout.simple_spinner_dropdown_item, payment
            )
            paymentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinPaymentMethod.adapter = paymentAdapter

            val bankAdapter = ArrayAdapter(
                this@PaymentActivity,
                R.layout.simple_spinner_dropdown_item, bank
            )
            bankAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinBank.adapter = bankAdapter

            // ... (kode yang ada)

            // Spinner untuk seat
            spinSeat.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val selectedSeat = seat[position]
                    pilihanSeat.text = "$selectedSeat"

                    // Update harga dan total berdasarkan jenis kursi yang dipilih
                    val harga: Int = when (selectedSeat) {
                        "Regular 2D" -> 35000
                        "RealD 3D"-> 50000
                        "Sphere X"-> 150000
                        "Screen X"-> 75000
                        "Sweetbox"-> 85000
                        "Gold Class"-> 250000
                        "Satin Suite"-> 20000
                        else -> 0  // Default jika tidak ada yang cocok
                    }

                    val total: Int = harga  // Total sementara, bisa dimodifikasi sesuai kebutuhan

                    // Update TextView harga dan total dengan harga yang sesuai
                    hargaSeat.text = "Rp $harga"
                    totalHarga.text = "Rp $total"
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Handle jika tidak ada yang dipilih
                    pilihanSeat.text = "Pilihan seat: "
                }
            }
            tombolBack.setOnClickListener {
                finish()
            }

            var selectedDate = ""
            datePick.init(
                datePick.year,
                datePick.month,
                datePick.dayOfMonth
            ) { _, year, month, day ->
                selectedDate = "$day/${month + 1}/$year"
            }

            tombolOrder.setOnClickListener {
                val intent = Intent(this@PaymentActivity, summary::class.java)
                val selectedBioskop = spinBioskop.selectedItem.toString()
                val selectedSeat = spinSeat.selectedItem.toString()
                val selectedBank = spinBank.selectedItem.toString()

                // Update harga dan total berdasarkan jenis kursi yang dipilih
                val harga: Int = when (selectedSeat) {
                    "Regular 2D" -> 35000
                    "RealD 3D"-> 50000
                    "Sphere X"-> 150000
                    "Screen X"-> 75000
                    "Sweetbox"-> 85000
                    "Gold Class"-> 250000
                    "Satin Suite"-> 20000
                    else -> 0  // Default jika tidak ada yang cocok
                }


                intent.putExtra(PaymentActivity.EXTRA_BIOSKOP, selectedBioskop)
                intent.putExtra(PaymentActivity.EXTRA_SEAT, selectedSeat)
                intent.putExtra(PaymentActivity.EXTRA_TANGGAL, selectedDate)
                intent.putExtra(PaymentActivity.EXTRA_BANK, selectedBank)
                intent.putExtra(PaymentActivity.EXTRA_HARGA, harga)
                startActivity(intent)
            }

        }
    }
}