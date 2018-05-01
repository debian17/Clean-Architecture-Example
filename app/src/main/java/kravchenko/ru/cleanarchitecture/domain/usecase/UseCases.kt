package kravchenko.ru.cleanarchitecture.domain.usecase

import io.reactivex.Single
import kravchenko.ru.cleanarchitecture.app.App
import kravchenko.ru.cleanarchitecture.data.model.MedOrg
import kravchenko.ru.cleanarchitecture.data.model.Person
import kravchenko.ru.cleanarchitecture.data.model.User
import kravchenko.ru.cleanarchitecture.data.repository.Repository
import kravchenko.ru.cleanarchitecture.domain.source.DataSource

//split this usecases into multiple files

fun getUsersUseCase(): () -> Single<List<User>> {
    return Repository().getUsers()
}

fun getPersonsUseCase(): Single<List<Person>> {
    return Repository().getPersons()
}

fun getPersonsInjectionUseCase(): Single<List<Person>> {
    val repository: DataSource
    repository = Injection.provideRepository()
    return repository.getPersons()
}

fun getMedOrgsUseCase(): Single<List<MedOrg>> {
    val repository: DataSource = App.getAppComponent().provideRepository()
    return repository.getMedOrgs()
}