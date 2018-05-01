package kravchenko.ru.cleanarchitecture.app

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import kravchenko.ru.cleanarchitecture.data.model.Person
import kravchenko.ru.cleanarchitecture.data.model.User
import kravchenko.ru.cleanarchitecture.domain.usecase.getMedOrgsUseCase
import kravchenko.ru.cleanarchitecture.domain.usecase.getPersonsUseCase
import kravchenko.ru.cleanarchitecture.domain.usecase.getUsersUseCase

class MainActivityPresenter {

    fun getUsers() {
        //do not forget unsubscribe when destroyView
        getUsersUseCase()
                .invoke() // if we return lambda, we need invoke it.
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