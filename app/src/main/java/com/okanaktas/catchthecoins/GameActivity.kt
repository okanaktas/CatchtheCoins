package com.okanaktas.catchthecoins

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.okanaktas.catchthecoins.databinding.ActivityGameBinding
import java.util.Random

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private var score = 0
    private var countdown = 30

    private var runnable = Runnable {}
    private var handler = Handler(Looper.getMainLooper())

    private var imageArray = ArrayList<ImageView>()

    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref = getSharedPreferences("com.okanaktas.catchthecoins", MODE_PRIVATE)


        val input = intent.getIntExtra("selected_image_id", R.drawable.bitcoin)

        imageArray.add(binding.imageView)
        imageArray.add(binding.imageView2)
        imageArray.add(binding.imageView3)
        imageArray.add(binding.imageView4)
        imageArray.add(binding.imageView5)
        imageArray.add(binding.imageView6)
        imageArray.add(binding.imageView7)
        imageArray.add(binding.imageView8)
        imageArray.add(binding.imageView9)
        imageArray.add(binding.imageView10)
        imageArray.add(binding.imageView11)
        imageArray.add(binding.imageView12)

        /*
        for(i in imageArray){
           i.id = input
            println("Görsel id'si ${i.id}")
        }
        println(imageArray[0].id)
         */

        // Tüm ImageView'lerin kaynağını ayarlayın
        for (image in imageArray) {
            image.setImageResource(input) // Burada kaynak resim ayarlandı
        }


        hideImages()

    }

    private fun hideImages() {

        runnable = Runnable {
            binding.textViewCountDown.text = "Countdown: ${countdown}"
            countdown--
            handler.postDelayed(runnable, 1000)

            for (image in imageArray) {
                image.visibility = View.INVISIBLE
            }
            val random = Random()
            val randomIndex = random.nextInt(12) //0-11 arasında rastgele bir indeks üretiyoruz
            imageArray[randomIndex].visibility = View.VISIBLE

            if (countdown < 0) {
                handler.removeCallbacks(runnable)
                showEndDialog()
                sharedPref.edit().putInt("lastScore", score).apply()
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
        // Dialog'un dışına tıklanarak kapanmasını önlemek için
        builder.setCancelable(false)
        builder.show()
    }

    fun buttonImage(view: View) {
        score++
        binding.textViewScore.text = "Score: ${score}"
    }
}