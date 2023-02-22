package com.example.listviewpr1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.listviewpr1.adapter.Product_Adapter
import com.example.listviewpr1.databinding.ActivityMainBinding
import com.example.listviewpr1.databinding.ItemProductBinding
import com.example.listviewpr1.model.Product

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val productlist = productAPI()

        val products_adapter = Product_Adapter(this, productlist)
        binding.productsListView.adapter = products_adapter

        binding.productsListView.setOnItemClickListener { adapterView, view, i, l ->
            val product = productlist[i]
            val intent = Intent(this, ProductActivity::class.java)
            intent.putExtra("product", product)
            startActivity(intent)
        }

    }

    fun productAPI():MutableList<Product>{
        var products = mutableListOf<Product>()
        products.add(Product("Namkeen", "https://haldiramuk.com/wp-content/uploads/2021/07/PLAIN-BHUJIA-300x300.png", 100, 120))
        products.add(Product("Cheers", "https://cheers.uz/assets/images/Blue-look.png", 156, 125))
        products.add(Product("Grenki", "https://img2.zakaz.ua/upload.version_1.0.61fa0107811bc8372dfea281455068b1.1350x1350.jpeg", 160, 128))
        products.add(Product("Garliki", "https://m.media-amazon.com/images/I/61XlqQAFqyL.jpg", 98, 680))
        products.add(Product("Kiriyeshki", "https://m.media-amazon.com/images/I/51u5OGBXG5L.jpg", 10, 150))
        products.add(Product("Ermak", "https://web.lebazar.uz/resources/product/2019/3/4/medium_1554364356702170401-00111.jpg", 40, 60))
        products.add(Product("Doritos", "https://m.media-amazon.com/images/I/81iUuyr2R7L.jpg", 420, 240))
        products.add(Product("Pringles", "https://haldiramuk.com/wp-content/uploads/2021/07/PLAIN-BHUJIA-300x300.png", 180, 320))
        products.add(Product("Grizzly", "https://m.media-amazon.com/images/I/61JcfP2YUSL._SX522_.jpg", 350, 500))
        products.add(Product("Lays", "https://m.media-amazon.com/images/I/71HyeSkXm0L._SX522_.jpg", 200, 250))
        return products
    }
}