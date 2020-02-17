package com.example.themealdbapp.network

import Categories_Base
import Meals_Base
import com.example.themealdbapp.network.Constant.CATEGORIES_ENDPOINT
import com.example.themealdbapp.network.Constant.MEAL_ENDPOINT
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Client {
    @GET(CATEGORIES_ENDPOINT)
    fun getCategoriesClient():
            Observable<Categories_Base>

    @GET(MEAL_ENDPOINT)
    fun getMealsClient(
        @Query("c") category: String):
            Observable<Meals_Base>
}