package com.example.bias_list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bias_list.databinding.ActivityDetailBinding
import com.example.bias_list.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    companion object {
        const val idolKey="idol"

    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding= ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle=intent.extras!!
        val idol=bundle.getParcelable<Idol>(idolKey)!!


        val botonVolver=binding.buttonBack
        binding.textName.text=idol.nombre
        binding.Alias.text=idol.alias
        binding.Bio.text=idol.bio
        binding.ratingBar2.rating=idol.calificacion

        botonVolver.setOnClickListener{
            intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}