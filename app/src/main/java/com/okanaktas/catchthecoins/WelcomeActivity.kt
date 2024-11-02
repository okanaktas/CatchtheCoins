package com.okanaktas.catchthecoins

import android.os.Bundle
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
}