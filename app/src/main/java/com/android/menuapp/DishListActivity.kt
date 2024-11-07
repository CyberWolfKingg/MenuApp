package com.android.menuapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DishListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_list)

        val listViewMenu: ListView = findViewById(R.id.listViewMenu)
        val textViewTotalItems: TextView = findViewById(R.id.textViewTotalItems)

        // Display the total number of items
        textViewTotalItems.text = getString(R.string.total_items, DishData.getDishes().size)

        // List of courses
        val courses = listOf("Starter", "Main Course", "Dessert")
        val courseImages = listOf(R.drawable.starter_image, R.drawable.main_course_image, R.drawable.dessert_image)

        val adapter = CourseAdapter(this, courses, courseImages)
        listViewMenu.adapter = adapter
    }
}