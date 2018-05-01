package kravchenko.ru.cleanarchitecture.data.repository

import io.reactivex.Single
import kravchenko.ru.cleanarchitecture.data.model.MedOrg
import kravchenko.ru.cleanarchitecture.data.model.Person
import kravchenko.ru.cleanarchitecture.data.model.User
import kravchenko.ru.cleanarchitecture.domain.source.DataSource

class TestRepository : DataSource {
    override fun getUsers(): () -> Single<List<User>> {
        return {
            Single.just(emptyList())
        }
    }

    override fun getPersons(): Single<List<Person>> {
        return Single.just(emptyList())
    }

    override fun getMedOrgs(): Single<List<MedOrg>> {
        return Single.just(emptyList())
    }
}