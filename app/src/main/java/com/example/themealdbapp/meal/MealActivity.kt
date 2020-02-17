package com.example.themealdbapp.meal

import Meals_Base
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themealdbapp.R
import com.example.themealdbapp.adapter.MealAdapter
import com.example.themealdbapp.network.Constant.PASSING_CATEGORY
import kotlinx.android.synthetic.main.activity_meal.*

class MealActivity : AppCompatActivity(),
    MealContract.View {

    private lateinit var categoriesPresenter: MealPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal)

        val categoryValue = intent.getStringExtra(PASSING_CATEGORY)
        categoriesPresenter =
            MealPresenter(this, categoryValue)
        categoriesPresenter.getMeals()
    }

    override fun showMeal(model: Meals_Base) {
        meal_recyclingView.adapter = MealAdapter(model)
        meal_recyclingView.layoutManager = LinearLayoutManager(this)
    }

    override fun showError(error: Throwable) {

        var t = Toast.makeText(this@MealActivity,"Error:" + error.localizedMessage, Toast.LENGTH_SHORT)
        t. show()
    }

    override fun onDestroy() {
        categoriesPresenter.onDestroyCalled()
        super.onDestroy()
    }
}
