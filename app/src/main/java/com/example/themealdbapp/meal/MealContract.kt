package com.example.themealdbapp.meal

import Meals_Base

interface MealContract {
    interface View {
        fun showMeal(model: Meals_Base)
        fun showError(error : Throwable)
    }

    interface Presenter {
        fun getMeals()
        fun onDestroyCalled()
    }
}
