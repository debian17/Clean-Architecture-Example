package kravchenko.ru.cleanarchitecture.data.repository

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import kravchenko.ru.cleanarchitecture.app.App
import kravchenko.ru.cleanarchitecture.data.model.MedOrg
import kravchenko.ru.cleanarchitecture.data.model.Person
import kravchenko.ru.cleanarchitecture.data.model.User
import kravchenko.ru.cleanarchitecture.data.network.NetworkService
import kravchenko.ru.cleanarchitecture.domain.source.DataSource
import javax.inject.Inject

class Repository : DataSource {

    init {
        App.getAppComponent().inject(this)
    }

    @Inject
    lateinit var api: NetworkService

    override fun getUsers(): () -> Single<List<User>> {
        return {
            //get users from network or from anyway else
            val users = listOf(User("Ivan", "1234"), User("Amigo", "4321"))
            Single.just(users)
                    .subscribeOn(Schedulers.io()) // do not forget make magic in another thread!
        }
    }

    //for logic over another entity you should create new repository
    override fun getPersons(): Single<List<Person>> {
        val persons = listOf(Person("Ivan", 22), Person("Amigo", 23))
        return Single.just(persons)
                .subscribeOn(Schedulers.io())
    }

    override fun getMedOrgs(): Single<List<MedOrg>> {
        val context = App.getAppComponent().provideAppContext()
        return api.loadMedOrg()
                .subscribeOn(Schedulers.io())
    }

}