package kravchenko.ru.cleanarchitecture.domain.source

import io.reactivex.Single
import kravchenko.ru.cleanarchitecture.data.model.MedOrg
import kravchenko.ru.cleanarchitecture.data.model.Person
import kravchenko.ru.cleanarchitecture.data.model.User

interface DataSource {

    fun getUsers(): () -> Single<List<User>>

    fun getPersons(): Single<List<Person>>

    fun getMedOrgs() : Single<List<MedOrg>>

}