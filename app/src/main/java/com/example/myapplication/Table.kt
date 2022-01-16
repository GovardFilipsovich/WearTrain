package com.example.myapplication

import MenuAdapter
import MenuItem
import android.app.Activity
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityTableBinding
import menu_db_helper

class Table : Activity() {

    private lateinit var binding: ActivityTableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // RecyclerView
        var recyclerView: RecyclerView = findViewById(R.id.List_of_dishes)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Работа с бд
        val helper = menu_db_helper(this)
        helper.installDatabaseFromAssets()
        val database = helper.readableDatabase

        //Получение списка блюд для адаптера
        var menu_list = ArrayList<MenuItem>()
        var c = database.query("Menu", arrayOf("name", "logo"), null, null, null, null, null, null)
        c.moveToFirst()
        do{
            var img_byte = c.getBlob(1)
            menu_list.add(MenuItem(c.getString(0), BitmapFactory.decodeByteArray(img_byte, 0, img_byte.size)))
        } while(c.moveToNext())

        // Адаптер
        var adapter = MenuAdapter(menu_list)

        recyclerView.adapter = adapter

        helper.close()

    }

}