package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items2)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()

        items.add(Item(1, "sofa", "Divan", "Loremdfsadf asdfadfas asdfsad", "asdfasdfs fsadfsad sa sadfsdfds", 5000))
        items.add(Item(2, "chair", "Stul", "Loremdfsadf asdfadfas asdfsad", "asdfasdfs fsadfsad sa sadfsdfds", 2000))
        items.add(Item(3, "desc", "Stol", "Loremdfsadf asdfadfas asdfsad", "asdfasdfs fsadfsad sa sadfsdfds", 4000))
    }
}

