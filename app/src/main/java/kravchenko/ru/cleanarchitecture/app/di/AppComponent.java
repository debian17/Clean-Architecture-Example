package kravchenko.ru.cleanarchitecture.app.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import kravchenko.ru.cleanarchitecture.data.repository.Repository;
import kravchenko.ru.cleanarchitecture.domain.source.DataSource;

@Singleton
@Component(modules = {NetworkModule.class,
        RepositoryModule.class,
        ContextModule.class})
public interface AppComponent {

    Context provideAppContext();

    DataSource provideRepository();

    void inject(Repository repository);

}
