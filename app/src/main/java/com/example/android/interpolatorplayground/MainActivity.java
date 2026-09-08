package com.example.android.interpolatorplayground;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupButton(R.id.btnWhatsapp, "https://wa.me/");
        setupButton(R.id.btnInstagram, "https://instagram.com/");
        setupButton(R.id.btnFacebook, "https://facebook.com/");
        setupButton(R.id.btnDana, "https://dana.id/");
        setupButton(R.id.btnGopay, "https://gopay.co.id/");
    }

    private void setupButton(int id, final String url) {
        Button btn = findViewById(id);
        if (btn != null) {
            btn.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            });
        }
    }
}
