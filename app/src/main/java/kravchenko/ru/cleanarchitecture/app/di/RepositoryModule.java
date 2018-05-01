package kravchenko.ru.cleanarchitecture.app.di;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import kravchenko.ru.cleanarchitecture.app.di.annotation.RepositoryProd;
import kravchenko.ru.cleanarchitecture.app.di.annotation.RepositoryTest;
import kravchenko.ru.cleanarchitecture.data.repository.Repository;
import kravchenko.ru.cleanarchitecture.data.repository.TestRepository;
import kravchenko.ru.cleanarchitecture.domain.source.DataSource;

@Module
class RepositoryModule {

    @Provides
    DataSource provideRepository() {
        return new Repository();
    }

}
