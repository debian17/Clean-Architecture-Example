package kravchenko.ru.cleanarchitecture.app

import android.util.Log
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import kravchenko.ru.cleanarchitecture.data.model.Person
import kravchenko.ru.cleanarchitecture.data.model.User
import kravchenko.ru.cleanarchitecture.domain.usecase.getMedOrgsUseCase
import kravchenko.ru.cleanarchitecture.domain.usecase.getPersonsUseCase
import javax.inject.Inject

class MainActivityPresenter {

    private val users1: () -> Single<List<User>> = App.getUseCaseComponent().provideUsersUseCase()// Либо так (лучше)

    @Inject
    lateinit var users2: () -> Single<List<User>>//Либо так

    init {
        App.getUseCaseComponent().inject(this)
    }

    fun getUsers() {
        users1()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetUsersSuccess, this::onGetUsersError)
        //or
        users2()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetUsersSuccess, this::onGetUsersError)
    }

    private fun onGetUsersSuccess(users: List<User>) {
        //send data to activity
    }

    private fun onGetUsersError(throwable: Throwable) {
        // /catch error
    }

    fun getPerosns() {
        getPersonsUseCase()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetPersonsSuccess, this::onGetPersonsError)
    }

    private fun onGetPersonsSuccess(persons: List<Person>) {
        //send data to activity
    }

    private fun onGetPersonsError(throwable: Throwable) {
        // /catch error
    }

    fun getMedOrgs() {
        getMedOrgsUseCase()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it.forEach { medOrg ->
                        Log.e("NAME", medOrg.name)
                    }
                }, {})
    }
}