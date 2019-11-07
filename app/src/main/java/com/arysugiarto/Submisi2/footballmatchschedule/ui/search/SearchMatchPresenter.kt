package com.rahmat.app.footballclub.feature.searchmatches

import com.arysugiarto.Submisi2.footballmatchschedule.entity.repository.Repository
import com.arysugiarto.Submisi2.footballmatchschedule.ui.search.SearchMatchContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*

class SearchMatchPresenter(val mView: SearchMatchContract.View,
                           val repository: Repository): SearchMatchContract.Presenter {

    val compositeDisposable = CompositeDisposable()

    override fun searchMatch(query: String?) {
        mView.showLoading()
        compositeDisposable.add(repository.searchMatches(query)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
                .subscribe {
                    mView.hideLoading()
                    mView.displayMatch(it.events)
                })
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }


}