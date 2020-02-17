package com.example.themealdbapp.meal

import Meals_Base
import com.example.themealdbapp.meal.MealContract
import com.example.themealdbapp.network.MealRetrofitInstance
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MealPresenter(
    private var view: MealContract.View?,
    categoryValue: String
): MealContract.Presenter {

    private val compDisposable = CompositeDisposable()
    private val call = MealRetrofitInstance.getClient.getMealsClient(categoryValue)

    
    override fun getMeals() {
        compDisposable.add(
            call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::success, this::error))
    }

    private fun success(mealsModel: Meals_Base) {
        view?.showMeal(mealsModel)
    }

    private fun error(t: Throwable) {
        view?.showError(t)
    }

    override fun onDestroyCalled() {
        view = null

    }


}