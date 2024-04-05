package com.example.info_app

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.info_app.databinding.ActivityDetailsDogBinding
import com.example.info_app.databinding.ActivityMainBinding
import model.Dog

class details_dog : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsDogBinding
    private lateinit var dog: Dog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsDogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dog = intent.extras?.getSerializable("info") as Dog

        with(binding) {
            Glide
                .with(root.context)
                .load(dog.imageUrl)
                .into(dogImage)

            dogName.text = dog.name
            dogPlay.text = dog.playfulness.toString()
            dogEnergy.text = dog.energy.toString()
            dogWeight.text = dog.weight.toString()
            dogGrooming.text = dog.grooming.toString()
            dogShedding.text = dog.shedding.toString()
            dogHeight.text = dog.height.toString()

        }
    }
    fun goBack(view: View) {
        finish()
    }

    fun toggle(view: View) {
        if(dog.isFavor) {
            binding.imageStar.setColorFilter(Color.GRAY)
            dog.isFavor = false
        }
        else {
            binding.imageStar.setColorFilter(Color.YELLOW)
            dog.isFavor = true
        }

    }

}