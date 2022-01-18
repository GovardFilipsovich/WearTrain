package com.example.myapplication

import android.app.Activity
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.databinding.ActivityDescriptionBinding

class DishDescription : Activity() {

    private lateinit var binding: ActivityDescriptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var intent = getIntent()

        var describe = intent.getStringExtra("describe")
        var textView: TextView = findViewById(R.id.Description)
        textView.setText(describe)

        var bytes = intent.getByteArrayExtra("image")

        var bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes?.size!!)
        var image : ImageView = findViewById(R.id.Dish_image)
        image.setImageBitmap(bitmap)

        var name = intent.getStringExtra("name")

        var logo_byte = intent.getByteArrayExtra("logo")

        var logo = BitmapFactory.decodeByteArray(logo_byte, 0, logo_byte?.size!!)

        var name_view : TextView = findViewById(R.id.name_dish)
        var logo_view : ImageView = findViewById(R.id.logo_img)

        name_view.setText(name)
        logo_view.setImageBitmap(logo)
    }
}
