package com.example.themealdbapp.categories

import Categories_Base
import com.example.themealdbapp.network.MealRetrofitInstance
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CategoriesPresenter (private var view: CategoriesContract.View?):
    CategoriesContract.Presenter {

    private val compDisposable = CompositeDisposable()
    private val call = MealRetrofitInstance.getClient.getCategoriesClient()

    override fun getCategories() {
        compDisposable.add(
            call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::success, this::error))
    }

    private fun success(categoryModel: Categories_Base) {
        view?.showCategories(categoryModel)

    }

    private fun error(t: Throwable) {
        view?.showError(t)
    }


    override fun onDestroyCalled() {
        view = null
    }

}