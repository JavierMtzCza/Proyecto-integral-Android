package com.example.proyecto_integral.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyecto_integral.repository.ProductRepository

class ProductViewModel : ViewModel() {

    private val repository : ProductRepository
    private val _allProducts = MutableLiveData<List<Product>>()
    val allProducts : LiveData<List<Product>> = _allProducts

    init {
        repository = ProductRepository().getInstance()
        repository.loadProducts(_allProducts)
    }

}