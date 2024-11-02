package com.okanaktas.catchthecoins

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.okanaktas.catchthecoins.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private var score = 0
    private var countdown = 60

    private var runnable = Runnable {}
    private var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        runnable = Runnable {
            binding.textViewCountDown.text = "Countdown: ${countdown}"
            countdown--
            handler.postDelayed(runnable, 1000)
        }
        handler.post(runnable)
    }

    fun buttonImage(view: View) {
        binding.textViewScore.text = "Score: ${score}"
        score++
    }
}