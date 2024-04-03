package com.example.info_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemo.network.ApiClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val client = ApiClient.instance
        val response = client.fetchDogList()
        
        print(response)
    }
}