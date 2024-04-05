package com.example.info_app

import adapter.DogAdapter
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import network.ApiClient.dogService
import com.example.info_app.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import model.Dog
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var searchView: SearchView
    private val adapter: DogAdapter by lazy { DogAdapter(onDogClick = { handleDogClick(it) }) }
    private var dogList: MutableList<Dog> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        searchView = binding.search

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

        setContentView(binding.root)

        binding.recyclerView.adapter = adapter


        // In a coroutine scope
        CoroutineScope(Dispatchers.IO).launch {
            try {
                dogList = dogService.getDogs().toMutableList()
                // Handle the successful response:
                Log.d("RESPONSE", dogList.toString())
                if(dogList != null) {
                    adapter.setData(dogList)
                }

            } catch (e: Exception) {
                // Handle network errors or other exceptions
                println("Error fetching dogs: $e")
            }
        }




    }

    private fun filterList(query: String?) {
        if (query != null) {
            val filteredList = dogList.filter { it.name.lowercase(Locale.ROOT).contains(query.toLowerCase(Locale.ROOT)) }
            adapter.setData(ArrayList(filteredList))
        }
        else {
            adapter.setData(dogList)
        }
    }

    override fun onResume() {
        super.onResume()
        binding.search.clearFocus()
    }

    override fun onPause() {
        super.onPause()
        binding.search.clearFocus()
    }

    private fun handleDogClick(dog: Dog) {
        val intent = Intent(this, details_dog::class.java)
        intent.putExtra("info", dog)
        startActivity(intent)
    }
}