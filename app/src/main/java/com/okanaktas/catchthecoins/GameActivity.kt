package com.okanaktas.catchthecoins

import android.content.Intent
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
    private var countdown = 60

    private var runnable = Runnable {}
    private var handler = Handler(Looper.getMainLooper())

    private var imageArray = ArrayList<ImageView>()

    // Seçilen görselin ID'si
    private var selectedImageId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        imageArray.add(binding.imageView12)
        imageArray.add(binding.imageView13)
        imageArray.add(binding.imageView14)
        imageArray.add(binding.imageView15)
        imageArray.add(binding.imageView16)
        imageArray.add(binding.imageView17)
        imageArray.add(binding.imageView18)
        imageArray.add(binding.imageView19)
        imageArray.add(binding.imageView20)
        imageArray.add(binding.imageView21)
        imageArray.add(binding.imageView22)
        imageArray.add(binding.imageView23)

        hideImages()


        selectedImageId = intent.getIntExtra("selected_image_id", 0)

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
            val randomIndex = random.nextInt(13) //12 değerim olduğu için
            imageArray[randomIndex].visibility = View.VISIBLE

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
        // Dialog'un dışına tıklanarak kapanmasını önlemek için
        builder.setCancelable(false)
        builder.show()
    }

    fun buttonImage(view: View) {
        binding.textViewScore.text = "Score: ${score}"
        score++
    }
}