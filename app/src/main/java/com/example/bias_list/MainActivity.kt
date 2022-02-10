package com.example.bias_list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bias_list.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.save.setOnClickListener{

            val nombre=binding.nombre.text.toString()
            val alias=binding.alias.text.toString()
            val bio=binding.bio.text.toString()
            val calificacion=binding.ratingBar.rating

            val idol= Idol(nombre,alias,bio,calificacion)
            openDetailActivity(idol)
        }
    }
    private fun openDetailActivity(idol: Idol){
        val intent=Intent(this,DetailActivity::class.java)
        intent.putExtra(DetailActivity.idolKey,idol)
        startActivity(intent)
    }
}