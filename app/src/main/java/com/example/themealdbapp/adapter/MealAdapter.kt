package com.example.themealdbapp.adapter

import Meals_Base
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.themealdbapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.meal_list.view.*

class MealAdapter(
    private val mealsBaseModel: Meals_Base):
    RecyclerView.Adapter<MealAdapter.ViewHolder>() {

    class ViewHolder(view: View):
        RecyclerView.ViewHolder(view) {
        var tvMealName: TextView = view.tv_meal_name
        var ivMealImage: ImageView = view.iv_image
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.meal_list,parent,false))
    }

    override fun getItemCount(): Int {
        return mealsBaseModel.meals.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get()?.load(mealsBaseModel.meals[position].strMealThumb)?.into(holder.ivMealImage)


        holder.tvMealName.text = mealsBaseModel.meals[position].strMeal

    }
}