package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityDescriptionBinding

class DishDescription : Activity() {

    private lateinit var binding: ActivityDescriptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}