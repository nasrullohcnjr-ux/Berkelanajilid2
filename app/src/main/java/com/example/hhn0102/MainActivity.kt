package com.example.hhn0102

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun setupButton(id: Int, url: String) {
            findViewById<Button>(id)?.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }
        }

        setupButton(R.id.btnWhatsapp, "https://wa.me/")
        setupButton(R.id.btnInstagram, "https://instagram.com/")
        setupButton(R.id.btnFacebook, "https://facebook.com/")
        setupButton(R.id.btnDana, "https://dana.id/")
        setupButton(R.id.btnGopay, "https://gopay.co.id/")
    }
}
