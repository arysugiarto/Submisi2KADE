package com.arysugiarto.Submisi2.footballmatchschedule.ui.fragment
import com.arysugiarto.Submisi2.footballmatchschedule.MatchContract
import com.arysugiarto.Submisi2.footballmatchschedule.entity.repository.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class LastPresenter(
    val view: MatchContract.View,
    val repository : Repository
) : MatchContract.Presenter{

    val compositeDisposable = CompositeDisposable()

    override fun getDataMatch() {
        view.showLoading()
        compositeDisposable.add(repository.getLastMatch("4328")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe{
                view.showDataMatch(it.events)
                view.hideLoading()
            })
    }
}