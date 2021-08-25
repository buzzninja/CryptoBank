package com.example.cryptobank


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner


class MainActivity : AppCompatActivity(){

    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(ViewModelStore(),ViewModelProvider.AndroidViewModelFactory(application))[CoinViewModel::class.java]
        viewModel.loadData()

    }


}


