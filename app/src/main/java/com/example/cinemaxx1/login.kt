package com.example.cinemaxx1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class login : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    // Data autentikasi statis (ganti dengan data yang sesuai)
    private val staticUsername = "user123"
    private val staticPassword = "password123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)
        loginButton = findViewById(R.id.btn_login)

        loginButton.setOnClickListener {
            val enteredUsername = usernameEditText.text.toString()
            val enteredPassword = passwordEditText.text.toString()

            // Bandingkan data yang dimasukkan oleh pengguna dengan data autentikasi statis
            if (enteredUsername == staticUsername && enteredPassword == staticPassword) {
                // Autentikasi berhasil, arahkan ke Activity_home
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            } else {
                // Autentikasi gagal, mungkin tampilkan pesan kesalahan
                Toast.makeText(this, "Autentikasi Gagal", Toast.LENGTH_SHORT).show()
            }
        }
    }
}