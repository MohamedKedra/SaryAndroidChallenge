package com.example.saryandroidchallenge.ui.main.view_model

import android.net.ConnectivityManager
import android.util.Log
import com.example.saryandroidchallenge.app.base.BaseViewModel
import com.example.saryandroidchallenge.app.base.LiveDataState
import com.example.saryandroidchallenge.remote.models.BannerResponse
import com.example.saryandroidchallenge.remote.models.CategoryResponse
import com.example.saryandroidchallenge.ui.main.repository.MainRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MainViewModel(
    private val repository: MainRepository,
    connectivityManager: ConnectivityManager
) : BaseViewModel(connectivityManager) {

    private val disposable = CompositeDisposable()
    private var bannersDataList = LiveDataState<BannerResponse>()

    private val disposableCategory = CompositeDisposable()
    private var categoriesDataList = LiveDataState<CategoryResponse>()

    fun refreshBanners(): LiveDataState<BannerResponse> {

        if (!isNetworkAvailable) {
            publishNoInternet(bannersDataList)
            return bannersDataList
        }

        publishLoading(bannersDataList)

        disposable.add(
            repository.getBanners().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(
                    object : DisposableSingleObserver<BannerResponse>() {
                        override fun onSuccess(response: BannerResponse) {
                            publishResult(bannersDataList, response)
                        }

                        override fun onError(error: Throwable) {
                            publishError(bannersDataList, error)
                        }
                    }
                )
        )

        return bannersDataList
    }

    fun refreshCategories(): LiveDataState<CategoryResponse> {

        if (!isNetworkAvailable) {
            publishNoInternet(bannersDataList)
            return categoriesDataList
        }

        publishLoading(categoriesDataList)

        disposableCategory.add(
            repository.getCategories().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(
                    object : DisposableSingleObserver<CategoryResponse>() {
                        override fun onSuccess(response: CategoryResponse) {
                            Log.d("res",response.toString())
                            publishResult(categoriesDataList, response)
                        }

                        override fun onError(error: Throwable) {
                            publishError(categoriesDataList, error)
                        }

                    }
                )
        )

        return categoriesDataList
    }
}