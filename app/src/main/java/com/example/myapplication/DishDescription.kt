package com.example.myapplication

import android.app.Activity
import android.graphics.BitmapFactory
import android.os.Bundle
import com.example.myapplication.databinding.ActivityDescriptionBinding

class DishDescription : Activity() {

    private lateinit var binding: ActivityDescriptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        var intent = getIntent()
        
        var describe = intent.getStringExtra("describe")
        var bytes = intent.getByteArrayExtra("image")
        var bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes?.size!!)

    }
}
