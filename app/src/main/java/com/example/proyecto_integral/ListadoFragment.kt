package com.example.proyecto_integral

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_integral.adapter.MyAdapter
import com.example.proyecto_integral.models.ProductViewModel

private lateinit var viewModel : ProductViewModel
private lateinit var productRecyclerView : RecyclerView
lateinit var adapter : MyAdapter

class ListadoFragment : Fragment(R.layout.fragment_listado) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productRecyclerView = view.findViewById(R.id.recyclerView)
        productRecyclerView.layoutManager = LinearLayoutManager(context)
        productRecyclerView.setHasFixedSize(true)
        adapter = MyAdapter()
        productRecyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        viewModel.allProducts.observe(viewLifecycleOwner, Observer {
            adapter.updateProductList(it)
        })
    }
}


