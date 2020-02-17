package com.example.themealdbapp.adapter

import Categories_Base
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.themealdbapp.meal.MealActivity
import com.example.themealdbapp.R
import com.example.themealdbapp.network.Constant.PASSING_CATEGORY
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.catergories_list.view.*

class CategoriesAdapter(
    private val categoriesBaseModel: Categories_Base,
    private val context: Context
    ):RecyclerView.Adapter<CategoriesAdapter.ViewHolder>(){

    class ViewHolder(view: View):
        RecyclerView.ViewHolder(view) {
        val categoriesName: TextView = view.tv_categories_name
        val categoriesDescription: TextView = view.tv_categories_description
        val categoriesThumb: ImageView = view.iv_categories
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.catergories_list,parent,false))
    }

    override fun getItemCount(): Int {
       return categoriesBaseModel.categories.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.categoriesName.text = categoriesBaseModel.categories[position].strCategory
        holder.categoriesDescription.text = categoriesBaseModel.categories[position].strCategoryDescription
        var picasso = Picasso.get()
        picasso.load(categoriesBaseModel.categories[position].strCategoryThumb).into(holder.categoriesThumb)

        holder.itemView.setOnClickListener{
            val intent = Intent(context,
                MealActivity::class.java)
            intent.putExtra(PASSING_CATEGORY,categoriesBaseModel.categories[position].strCategory)
            context.startActivity(intent)
        }
    }
}
