package com.example.proyecto_integral.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_integral.R
import com.example.proyecto_integral.models.Product

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val productList = ArrayList<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.product_item,
            parent,false
        )
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = productList[position]

        holder.name.text = currentItem.nombre
        holder.price.text = currentItem.precio
    }

    fun updateProductList(productList : List<Product>){
        this.productList.clear()
        this.productList.addAll(productList)
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val name: TextView = itemView.findViewById(R.id.tvName)
        val price: TextView = itemView.findViewById(R.id.tvPrice)



    }


}