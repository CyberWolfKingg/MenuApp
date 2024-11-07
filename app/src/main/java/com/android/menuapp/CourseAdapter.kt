package com.android.menuapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CourseAdapter(context: Context, private val courses: List<String>, private val images: List<Int>) :
    ArrayAdapter<String>(context, 0, courses) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Inflate layout for each item
        val listItemView = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item_course, parent, false)

        // Get current course and corresponding image
        val course = getItem(position)
        val courseImage = images[position]

        // Lookup view for data population
        val textViewCourseTitle: TextView = listItemView.findViewById(R.id.textViewCourseTitle)
        val imageViewCourse: ImageView = listItemView.findViewById(R.id.imageViewCourse)
        val textViewAveragePrice: TextView = listItemView.findViewById(R.id.textViewAveragePrice) // Add this TextView in the layout

        // Populate the data
        textViewCourseTitle.text = course
        imageViewCourse.setImageResource(courseImage)

        // Set the average price for each course
        val averagePrice = DishData.getAveragePriceForCourse(course ?: "")
        textViewAveragePrice.text = context.getString(R.string.average_price, averagePrice)

        // Set click listener for each course
        listItemView.setOnClickListener {
            val intent = Intent(context, CourseDetailActivity::class.java)
            intent.putExtra("course", course)
            context.startActivity(intent)
        }

        return listItemView
    }
}
