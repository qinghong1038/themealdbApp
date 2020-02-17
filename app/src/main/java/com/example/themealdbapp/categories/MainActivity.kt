package com.example.themealdbapp.categories

import Categories_Base
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themealdbapp.R
import com.example.themealdbapp.adapter.CategoriesAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    CategoriesContract.View {

    private lateinit var categoriesPresenter: CategoriesPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        categoriesPresenter =
            CategoriesPresenter(this)
        categoriesPresenter.getCategories()

    }

    override fun showCategories(model: Categories_Base) {
        categories_recyclingView.adapter = CategoriesAdapter(model,this)
        categories_recyclingView.layoutManager = LinearLayoutManager(this)

    }

    override fun showError(error: Throwable) {

        var t = Toast.makeText(this@MainActivity,"Error:" + error.localizedMessage,Toast.LENGTH_SHORT)
        t. show()
    }

    override fun onDestroy() {
        categoriesPresenter.onDestroyCalled()
        super.onDestroy()
    }
}
