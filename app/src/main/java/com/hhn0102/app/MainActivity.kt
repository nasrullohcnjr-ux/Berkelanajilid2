package com.hhn0102.app

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.net.URLEncoder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_main)
            setupViews()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun setupViews() {
        val adminWA = "6281234567890"

        fun openUrl(url: String) {
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Gagal membuka tautan", Toast.LENGTH_SHORT).show()
            }
        }

        fun orderViaWA(productName: String, price: String) {
            try {
                val message = "Halo Admin hhn0102, saya mau pesan:\n- Produk: $productName\n- Harga: $price\nMohon informasi pembayarannya."
                val encodedMessage = URLEncoder.encode(message, "UTF-8")
                val waUrl = "https://wa.me/$adminWA?text=$encodedMessage"
                openUrl(waUrl)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        findViewById<Button>(R.id.btnWhatsapp)?.setOnClickListener { openUrl("https://wa.me/$adminWA") }
        findViewById<Button>(R.id.btnInstagram)?.setOnClickListener { openUrl("https://instagram.com/") }
        findViewById<Button>(R.id.btnFacebook)?.setOnClickListener { openUrl("https://facebook.com/") }
        findViewById<Button>(R.id.btnDana)?.setOnClickListener { openUrl("https://dana.id/") }
        findViewById<Button>(R.id.btnGopay)?.setOnClickListener { openUrl("https://gopay.co.id/") }

        findViewById<Button>(R.id.btnSalinRekening)?.setOnClickListener {
            val noRek = findViewById<TextView>(R.id.tvRekening)?.text?.toString() ?: "1234567890"
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Nomor Rekening", noRek)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this, "Nomor rekening berhasil disalin!", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btnOrder1)?.setOnClickListener { orderViaWA("Paket Hemat Frozen Food A", "Rp 35.000") }
        findViewById<Button>(R.id.btnOrder2)?.setOnClickListener { orderViaWA("Paket Sosis & Nugget Premium", "Rp 55.000") }
        findViewById<Button>(R.id.btnOrder3)?.setOnClickListener { orderViaWA("Paket Komplit Bakso & Dimsum", "Rp 75.000") }
    }
}
