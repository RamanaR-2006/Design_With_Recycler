package com.example.myapplication


import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var text = "₹4999"

        // Create a SpannableString with the text
        var spannableString = SpannableString(text)

        // Apply the strike-through style to the SpannableString
        spannableString.setSpan(StrikethroughSpan(), 0, text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        var text1 = "₹3210"

        // Create a SpannableString with the text
        var spannableString1 = SpannableString(text)

        // Apply the strike-through style to the SpannableString
        spannableString1.setSpan(StrikethroughSpan(), 0, text1.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        val layoutManager = GridLayoutManager(this, 2) // 2 columns per row
        recyclerview.layoutManager = layoutManager

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..17) {
            data.add(ItemsViewModel(R.drawable.img, "Adidas Men's Running Shoes", "₹4799", text))
            data.add(ItemsViewModel(R.drawable.img_2, "Puma Black Sports Shoe", "₹3777", text1))
        }
        data.add(ItemsViewModel(R.drawable.img, "Adidas Men's Running Shoes", "₹4799", text))

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

    }
}