package kravchenko.ru.cleanarchitecture.domain.usecase

import kravchenko.ru.cleanarchitecture.data.repository.Repository

object Injection {

    fun provideRepository(): Repository {
        return Repository()
    }

}