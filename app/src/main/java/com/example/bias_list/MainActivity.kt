package com.example.bias_list

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import com.example.bias_list.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var idolImagen: ImageView
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
        idolImagen=binding.image
        idolImagen.setOnClickListener{
            openCamera()
        }
    }

    private fun openCamera() {
        var CameraIntent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(CameraIntent,100)
    }

    private fun openDetailActivity(idol: Idol){
        val intent=Intent(this,DetailActivity::class.java)
        intent.putExtra(DetailActivity.idolKey,idol)
        intent.putExtra(DetailActivity.bitmapKey,idolImagen.drawable.toBitmap())

        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK && requestCode==100)
        {
            val extras: Bundle?= data?.extras
            val idolBitmap: Bitmap?=extras?.getParcelable<Bitmap>("data")
            idolImagen.setImageBitmap(idolBitmap)
        }
    }
}