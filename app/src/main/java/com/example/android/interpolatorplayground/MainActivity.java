package com.example.android.interpolatorplayground

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun openLink(url: String) {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnWhatsapp)?.setOnClickListener { openLink("https://wa.me/") }
        findViewById<Button>(R.id.btnInstagram)?.setOnClickListener { openLink("https://instagram.com/") }
        findViewById<Button>(R.id.btnFacebook)?.setOnClickListener { openLink("https://facebook.com/") }
        findViewById<Button>(R.id.btnDana)?.setOnClickListener { openLink("https://dana.id/") }
        findViewById<Button>(R.id.btnGopay)?.setOnClickListener { openLink("https://gopay.co.id/") }
    }
}
