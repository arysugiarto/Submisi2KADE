package com.arysugiarto.Submisi2.footballmatchschedule.ui.main

import com.arysugiarto.Submisi2.footballmatchschedule.entity.repository.Repository
import io.reactivex.disposables.CompositeDisposable

class MainPresenter(val mView : MainContract.View, val repository: Repository) : MainContract.Presenter{

    val compositeDisposable = CompositeDisposable()
}