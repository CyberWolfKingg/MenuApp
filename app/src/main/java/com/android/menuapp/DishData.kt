package com.android.menuapp

object DishData {
    private val dishes = mutableListOf(
        DishItem(
            name = "Bruschetta",
            description = "Grilled bread topped with garlic, tomatoes, and basil.",
            course = "Starter",
            price = 6.99
        ),
        DishItem(
            name = "Caesar Salad",
            description = "Fresh romaine lettuce, croutons, parmesan, and Caesar dressing.",
            course = "Starter",
            price = 7.99
        ),
        DishItem(
            name = "Grilled Salmon",
            description = "Perfectly grilled salmon with a lemon butter sauce.",
            course = "Main Course",
            price = 15.99
        ),
        DishItem(
            name = "Ribeye Steak",
            description = "Juicy ribeye steak grilled to perfection with a side of mashed potatoes.",
            course = "Main Course",
            price = 22.99
        ),
        DishItem(
            name = "Tiramisu",
            description = "Classic Italian dessert with layers of coffee-soaked ladyfingers and mascarpone cream.",
            course = "Dessert",
            price = 8.99
        ),
        DishItem(
            name = "Chocolate Lava Cake",
            description = "Warm chocolate cake with a gooey molten center, served with vanilla ice cream.",
            course = "Dessert",
            price = 9.99
        )
    )

    fun getDishes(): List<DishItem> {
        return dishes
    }

    fun addDish(dish: DishItem) {
        dishes.add(dish)
    }
}
