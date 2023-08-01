package com.example.myapplication


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        val layoutManager = GridLayoutManager(this, 2) // 2 columns per row
        recyclerview.layoutManager = layoutManager

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..17) {
            data.add(ItemsViewModel(R.drawable.img, "Addidas Men's Running Shoes", "$300"))
            data.add(ItemsViewModel(R.drawable.img_1, "Puma Black Sports Shoe", "$150"))
        }
        data.add(ItemsViewModel(R.drawable.img, "Addidas Men's Running Shoes", "$300"))

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

    }
}