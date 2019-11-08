
import com.arysugiarto.Submisi2.footballmatchschedule.MatchView
import com.arysugiarto.Submisi2.footballmatchschedule.entity.repository.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class NextPresenter(
    val mView: MatchView.View,
    val matchRepositoryImpl: Repository
) : MatchView.Presenter {

    val compositeDisposable = CompositeDisposable()

    override fun getDataMatch() {
        mView.showLoading()
        compositeDisposable.add(matchRepositoryImpl.getNextMatch("4328")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe{
                mView.showDataMatch(it.events)
                mView.hideLoading()
            })
    }
}