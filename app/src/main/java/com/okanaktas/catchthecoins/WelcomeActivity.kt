package com.okanaktas.catchthecoins

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.okanaktas.catchthecoins.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding

    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // onCreate içinde sharedPref değişkenini başlatıyoruz
        sharedPref = getSharedPreferences("com.okanaktas.catchthecoins", MODE_PRIVATE)

        val lastScore = sharedPref.getInt("lastScore",0)
        binding.textViewLastScore.text = "Last Score: $lastScore"

    }

    fun imageClick(view: View) {
        // Seçilen görselin kaynağını tanımlama
        val imageId = when (view.id) {
            R.id.imageViewBitcoin -> R.drawable.bitcoin
            R.id.imageViewCoin -> R.drawable.coin
            R.id.imageViewDollar -> R.drawable.dollar
            R.id.imageViewEthereum -> R.drawable.ethereum
            R.id.imageViewPolygon -> R.drawable.polygon
            R.id.imageViewShiba -> R.drawable.shiba
            R.id.imageViewTon -> R.drawable.ton
            R.id.imageViewTrx -> R.drawable.trx
            R.id.imageViewUsdt -> R.drawable.usdt
            else -> R.drawable.ic_launcher_background // Varsayılan bir resim
        }

        val intent = Intent(this@WelcomeActivity, GameActivity::class.java)
        intent.putExtra("selected_image_id", imageId) // Görselin drawable kaynağını gönder
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