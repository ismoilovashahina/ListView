package com.example.listviewpr1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listviewpr1.model.Product

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        var p = intent.getSerializableExtra("product") as Product



    }
}