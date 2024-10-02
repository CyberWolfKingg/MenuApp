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
        val buttonAddDish: Button = findViewById(R.id.buttonAddDish)
        val buttonLogin: Button = findViewById(R.id.buttonLogin)
        val textViewTotalItems: TextView = findViewById(R.id.textViewTotalItems)

        // Display the menu
        updateMenuList(listViewMenu, textViewTotalItems)

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
    }

    // Refreshes the dish list
    override fun onResume() {
        super.onResume()
        val listViewMenu: ListView = findViewById(R.id.listViewMenu)
        val textViewTotalItems: TextView = findViewById(R.id.textViewTotalItems)
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

        updateMenuList(listViewMenu, textViewTotalItems)
    }

    private fun updateMenuList(listView: ListView, textViewTotalItems: TextView) {
        val menu = DishData.getDishes()

        // Filter dishes by category
        val starters: List<DishItem> = menu.filter { it.course == "Starter" }
        val mains: List<DishItem> = menu.filter { it.course == "Main Course" }
        val desserts: List<DishItem> = menu.filter { it.course == "Dessert" }

        val menuStrings = mutableListOf<String>()
        menuStrings.add("-- Starters:")
        menuStrings.addAll(starters.map { "${it.name} - R${it.price} -- ${it.description}" })

        menuStrings.add("-- Main Courses:")
        menuStrings.addAll(mains.map { "${it.name} - R${it.price} -- ${it.description}" })

        menuStrings.add("-- Desserts:")
        menuStrings.addAll(desserts.map { "${it.name} - R${it.price} -- ${it.description} " })

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, menuStrings)
        listView.adapter = adapter

        // Displays the total number of items in the menu
        textViewTotalItems.text = getString(R.string.total_items, menu.size)
    }
}