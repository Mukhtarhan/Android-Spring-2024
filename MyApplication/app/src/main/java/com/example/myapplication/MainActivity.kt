package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.example.myapplication.adapter.PizzaAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.Pizza
import com.example.myapplication.model.PizzaDataSource
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var searchView: SearchView
    private val adapter: PizzaAdapter by lazy {PizzaAdapter(onPizzaClick = { handlePizzaClick(it) })}
    private var pizzaList: ArrayList<Pizza> = PizzaDataSource.pizzaList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        searchView = binding.search
        setContentView(binding.root)

        binding.recyclerView.adapter = adapter

        adapter.setData(pizzaList)

        searchView.clearFocus()
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                return false
            }
        })


    }

    override fun onResume() {
        super.onResume()
        binding.search.clearFocus()
    }

    override fun onPause() {
        super.onPause()
        binding.search.clearFocus()
    }


    private fun handlePizzaClick(pizza: Pizza) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("pizzaInfo", pizza)
        startActivity(intent)
    }

    private fun filterList(query: String?) {
        if (query != null) {
            val filteredList = pizzaList.filter { it.name.lowercase(Locale.ROOT).contains(query.toLowerCase(Locale.ROOT)) }
            adapter.setData(ArrayList(filteredList))
        }
        else {
            adapter.setData(pizzaList)
        }
    }


}