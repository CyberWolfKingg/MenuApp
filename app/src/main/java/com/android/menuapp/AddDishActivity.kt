package com.android.menuapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class AddDishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_dish)

        val editTextDishName: EditText = findViewById(R.id.editTextDishName)
        val editTextDishDescription: EditText = findViewById(R.id.editTextDishDescription)
        val spinnerCourse: Spinner = findViewById(R.id.spinnerCourse)
        val editTextDishPrice: EditText = findViewById(R.id.editTextDishPrice)
        val buttonAddDish: Button = findViewById(R.id.buttonAddDish)

        // Sets the dish type options
        val courses = arrayOf("Starter", "Main Course", "Dessert")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, courses)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCourse.adapter = adapter

        // Logic for adding a new dish
        buttonAddDish.setOnClickListener {
            val dishName = editTextDishName.text.toString()
            val dishDescription = editTextDishDescription.text.toString()
            val course = spinnerCourse.selectedItem.toString()
            val dishPrice = editTextDishPrice.text.toString().toDoubleOrNull()

            if (dishName.isNotEmpty() && dishDescription.isNotEmpty() && dishPrice != null) {
                DishData.addDish(DishItem(dishName, dishDescription, course, dishPrice))
                Toast.makeText(this, "$dishName added!", Toast.LENGTH_SHORT).show()

                editTextDishName.text.clear()
                editTextDishDescription.text.clear()
                editTextDishPrice.text.clear()
            } else {
                Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}