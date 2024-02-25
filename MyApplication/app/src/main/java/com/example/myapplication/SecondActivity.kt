package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivitySecondBinding
import com.example.myapplication.model.Pizza

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var pizza : Pizza

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pizza = intent.extras?.getSerializable("pizzaInfo") as Pizza
        with(binding) {
            pizzaImage.setImageResource(pizza.imageRes)
            pizzaName.text = pizza.name
            pizzaDescription.text = pizza.shortDescription
            pizzaSizeDescription.text = pizza.sizeDescription
            pizzaTestoDescription.text = pizza.testoDescription
            btn.text = "Add to cart " + pizza.smallPrice.toString() + " KZT"
        }
    }

    fun smallSize(view: View) {
        binding.smallBtn.background.setTint(getColor(R.color.white))
        binding.mediumBtn.background.setTint(getColor(R.color.grey))
        binding.largeBtn.background.setTint(getColor(R.color.grey))
        binding.pizzaSizeDescription.text = "25cm, "
        binding.btn.text = "Add to cart " + pizza.smallPrice.toString() + " KZT"
    }
    fun mediumSize(view: View) {
        binding.smallBtn.background.setTint(getColor(R.color.grey))
        binding.mediumBtn.background.setTint(getColor(R.color.white))
        binding.largeBtn.background.setTint(getColor(R.color.grey))
        binding.pizzaSizeDescription.text = "35cm, "
        binding.btn.text = "Add to cart " + pizza.mediumPrice.toString() + " KZT"
    }
    fun largeSize(view: View) {
        binding.smallBtn.background.setTint(getColor(R.color.grey))
        binding.mediumBtn.background.setTint(getColor(R.color.grey))
        binding.largeBtn.background.setTint(getColor(R.color.white))
        binding.pizzaSizeDescription.text = "45cm, "
        binding.btn.text = "Add to cart " + pizza.bigPrice.toString() + " KZT"
    }
    fun thinTesto(view: View) {
        binding.thinBtn.background.setTint(getColor(R.color.white))
        binding.traditionalBtn.background.setTint(getResources().getColor(R.color.grey))
        binding.pizzaTestoDescription.text = "thin"
    }
    fun traditionalTesto(view: View) {
        binding.thinBtn.background.setTint(getColor(R.color.grey))
        binding.traditionalBtn.background.setTint(getColor(R.color.white))
        binding.pizzaTestoDescription.text = "traditional"
    }

    fun goBack(view: View) {
        finish()
    }

}