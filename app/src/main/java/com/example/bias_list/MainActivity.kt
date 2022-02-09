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
            openDetailActivity()
        }
    }
    private fun openDetailActivity(){
        val intent=Intent(this,DetailActivity::class.java)
        startActivity(intent)
    }
}