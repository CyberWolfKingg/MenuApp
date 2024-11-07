package com.android.menuapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class DishAdapter(context: Context, private val dishes: MutableList<DishItem>) :
    ArrayAdapter<DishItem>(context, 0, dishes) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val dish = getItem(position)

        // Inflate different views for course and dish items
        return if (isCategory(dish)) {
            val listItemView = convertView ?: LayoutInflater.from(context)
                .inflate(R.layout.list_item_course, parent, false)

            val textViewCourseTitle: TextView = listItemView.findViewById(R.id.textViewCourseTitle)
            val imageViewCourse: ImageView = listItemView.findViewById(R.id.imageViewCourse)

            // Set course title and image
            textViewCourseTitle.text = dish?.course
            val imageResId = when (dish?.course) {
                "Starter" -> R.drawable.starter_image // Add this image to the drawable
                "Main Course" -> R.drawable.main_course_image // Add this image to the drawable
                "Dessert" -> R.drawable.dessert_image // Add this image to the drawable
                else -> R.drawable.ic_launcher_foreground // Add this image to the drawable
            }
            imageViewCourse.setImageResource(imageResId)

            listItemView
        } else {
            val listItemView = convertView ?: LayoutInflater.from(context)
                .inflate(R.layout.list_item_dish, parent, false)

            val textViewDishName: TextView = listItemView.findViewById(R.id.textViewDishName)
            val textViewDishDescription: TextView = listItemView.findViewById(R.id.textViewDishDescription)
            val textViewDishPrice: TextView = listItemView.findViewById(R.id.textViewDishPrice)
            val buttonRemoveDish: Button = listItemView.findViewById(R.id.buttonRemoveDish)

            // Set dish details
            textViewDishName.text = dish?.name
            textViewDishDescription.text = dish?.description
            textViewDishPrice.text = "R${dish?.price}"

            // Implement remove button functionality
            buttonRemoveDish.setOnClickListener {
                dish?.let {
                    dish?.let {
                        // Remove from DishData
                        DishData.removeDish(it)
                        dishes.remove(it) // Remove item from the list in adapter
                        notifyDataSetChanged() // Notify the adapter about the change
                        Toast.makeText(context, "${it.name} removed!", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            listItemView
        }
    }

    private fun isCategory(dish: DishItem?): Boolean {
        // Define logic to distinguish between category items and dish items.
        return dish?.description.isNullOrEmpty() && dish?.price == 0.0
    }
}