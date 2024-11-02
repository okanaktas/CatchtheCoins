package com.okanaktas.catchthecoins

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.okanaktas.catchthecoins.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private var score = 0
    private var countdown = 2

    private var runnable = Runnable {}
    private var handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        runnable = Runnable {
            binding.textViewCountDown.text = "Countdown: ${countdown}"
            countdown--
            handler.postDelayed(runnable, 1000)

            if (countdown < 0) {
                handler.removeCallbacks(runnable)
                showEndDialog()
            }
        }
        handler.post(runnable)
    }

    private fun showEndDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Finished Game!")
        builder.setMessage("Your Score: $score")
        builder.setPositiveButton("Play Again") { _, _ ->
            val intent = intent
            startActivity(intent)
            finish()
        }
        builder.setNegativeButton("Go Home Screen") { _, _ ->
            val intent = Intent(this@GameActivity, WelcomeActivity::class.java)
            startActivity(intent)
        }
        builder.setCancelable(false) // Dialog'un dışına tıklanarak kapanmasını önlemek için
        builder.show()
    }

    fun buttonImage(view: View) {
        binding.textViewScore.text = "Score: ${score}"
        score++
    }
}