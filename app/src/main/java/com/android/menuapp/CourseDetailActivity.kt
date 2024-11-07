package com.android.menuapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class CourseDetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail)

        val listViewCourse: ListView = findViewById(R.id.listViewCourse)
        val buttonAddDish: Button = findViewById(R.id.buttonAddDish)
        val buttonLogin: Button = findViewById(R.id.buttonLogin)

        // Navigates to the add new dish screen
        buttonAddDish.setOnClickListener {
            val intent = Intent(this, AddDishActivity::class.java)
            startActivity(intent)
        }

        // Navigates to the add login screen
        buttonLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val course = intent.getStringExtra("course")

        val filteredDishes = DishData.getDishes().filter { it.course == course }.toMutableList()
        val adapter = DishAdapter(this, filteredDishes)
        listViewCourse.adapter = adapter

        buttonAddDish.setOnClickListener {
            val intent = Intent(this, AddDishActivity::class.java)
            intent.putExtra("course", course)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        val buttonAddNewDish: Button = findViewById(R.id.buttonAddDish)
        val buttonLoginDish: Button = findViewById(R.id.buttonLogin)

        // Checks if the chef is logged in to show the add dish button
        if (LoginState.isLoggedIn) {
            buttonAddNewDish.visibility = View.VISIBLE
            buttonLoginDish.visibility = View.GONE
        } else {
            buttonAddNewDish.visibility = View.GONE
            buttonLoginDish.visibility = View.VISIBLE
        }
    }
}