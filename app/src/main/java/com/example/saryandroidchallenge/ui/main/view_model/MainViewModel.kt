package com.example.saryandroidchallenge.ui.main.view_model

import android.net.ConnectivityManager
import com.example.saryandroidchallenge.app.base.BaseViewModel
import com.example.saryandroidchallenge.app.base.LiveDataState
import com.example.saryandroidchallenge.remote.models.BannerResponse
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


}