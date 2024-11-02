package com.okanaktas.catchthecoins

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.okanaktas.catchthecoins.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun buttonGame(view: View) {
        val intent = Intent(this@WelcomeActivity, GameActivity::class.java)
        startActivity(intent)
    }

    fun buttonHome(view: View) {
        val intent = Intent(this@WelcomeActivity, WelcomeActivity::class.java)
        finish()
        startActivity(intent)
    }

    fun buttonSettings(viwe: View) {
        val intent = Intent(this@WelcomeActivity, SettingsActivity::class.java)
        finish()
        startActivity(intent)
    }
}