package com.example.bias_list

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bias_list.databinding.ActivityDetailBinding
import com.example.bias_list.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    companion object {
        const val idolKey="idol"
        const val bitmapKey="bitmapKey"

    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding= ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle=intent.extras!!
        val idol=bundle.getParcelable<Idol>(idolKey)!!
        val bitmapIdol=bundle.getParcelable<Bitmap>(bitmapKey)!!


        binding.idol=idol
        binding.imageView.setImageBitmap(bitmapIdol)

        val botonVolver=binding.buttonBack


        botonVolver.setOnClickListener{
            intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}