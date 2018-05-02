package kravchenko.ru.cleanarchitecture.app.di

import dagger.Component
import io.reactivex.Single
import kravchenko.ru.cleanarchitecture.app.MainActivityPresenter
import kravchenko.ru.cleanarchitecture.app.di.annotation.MyScope
import kravchenko.ru.cleanarchitecture.data.model.User
import kravchenko.ru.cleanarchitecture.domain.source.DataSource


@MyScope
@Component(modules = [RepositoryModule::class])
interface UseCaseComponent  {

    fun provideUsersUseCase(): () -> Single<List<User>>

    fun provideRepository(): DataSource

    fun inject (presenter: MainActivityPresenter)
}