package kravchenko.ru.cleanarchitecture.app.di

import dagger.Module
import dagger.Provides
import io.reactivex.Single
import kravchenko.ru.cleanarchitecture.app.di.annotation.MyScope
import kravchenko.ru.cleanarchitecture.data.model.User
import kravchenko.ru.cleanarchitecture.domain.source.DataSource

@Module
internal class RepositoryModule(private val repos: DataSource) {

    @MyScope
    @Provides
    fun provideRepository(): DataSource {
        return repos
    }

    @MyScope
    @Provides
    fun provideUsersUseCase(): () -> Single<List<User>> {
        return repos.getUsers()
    }

}
