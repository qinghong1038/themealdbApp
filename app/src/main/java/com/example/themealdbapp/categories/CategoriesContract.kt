package com.example.themealdbapp.categories

import Categories_Base

interface CategoriesContract {
    interface View {
        fun showCategories(model: Categories_Base)
        fun showError(error : Throwable)
    }

    interface Presenter {
        fun getCategories()
        fun onDestroyCalled()
    }
}