package com.example.listviewpr1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import coil.load
import com.example.listviewpr1.R
import com.example.listviewpr1.databinding.ItemProductBinding
import com.example.listviewpr1.model.Product

 class Product_Adapter(context:Context, var productlist:MutableList<Product>)
    :ArrayAdapter<Product>(context, R.layout.item_product, productlist){

    override fun getCount(): Int {
        return productlist.size
    }

     var s:Int = 0

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var binding:ItemProductBinding
        if(convertView==null){
            binding= ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        }
        else{
            binding = ItemProductBinding.bind(convertView)
        }
        val product = productlist[position]
        binding.productImg.load(product.img)
        binding.name.text = product.name
        binding.price.text = product.price.toString()
        binding.weight.text = product.weight.toString()

        binding.plus.setOnClickListener {
            s = binding.count.text.toString().toInt()
            s++
            binding.count.text = s.toString()
        }

        binding.minus.setOnClickListener {
            s = binding.count.text.toString().toInt()
            if (s>0){
                s--
                binding.count.text = s.toString()
            }

        }

        return binding.root
    }
}
