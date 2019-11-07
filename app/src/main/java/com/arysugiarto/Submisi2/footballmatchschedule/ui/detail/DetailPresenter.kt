package com.arysugiarto.Submisi2.footballmatchschedule.ui.detail


import com.arysugiarto.Submisi2.footballmatchschedule.entity.repository.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailPresenter(val view : DetailContract.View, val repository: Repository) : DetailContract.Presenter {

    override fun getTeamHome(id: String) {
        compositeDisposable.add(repository.getTeams(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe{
                    it.teams?.get(0)?.let { it1 -> view.logoTeamHome(it1) }
                })
    }

    val compositeDisposable = CompositeDisposable()

    override fun getTeamAway(id:String) {
        compositeDisposable.add(repository.getTeams(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe{
                    it.teams?.get(0)?.let { it1 -> view.logoTeamAway(it1) }
                })
    }
}