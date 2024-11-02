package com.okanaktas.catchthecoins

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.okanaktas.catchthecoins.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun buttonImage(view: View) {
        binding.textViewScore.text = "Score: ${score}"
        score++
    }
}