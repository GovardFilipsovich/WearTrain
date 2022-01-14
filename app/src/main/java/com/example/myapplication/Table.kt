package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityTableBinding

class Table : Activity() {

    private lateinit var binding: ActivityTableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTableBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}