package com.okanaktas.catchthecoins

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.okanaktas.catchthecoins.databinding.ActivityGameBinding
import com.okanaktas.catchthecoins.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding

    private var speed = 0
    private var countdown = 0

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("com.okanaktas.catchthecoins", MODE_PRIVATE)
    }


    fun buttonReset(view: View) {
        speed = 0
        countdown = 30
    }

    fun buttonHome(view: View) {
        val intent = Intent(this@SettingsActivity, WelcomeActivity::class.java)
        finish()
        startActivity(intent)
    }

    fun buttonSettings(viwe: View) {
        val intent = Intent(this@SettingsActivity, GameActivity::class.java)
        finish()
        startActivity(intent)
    }
}