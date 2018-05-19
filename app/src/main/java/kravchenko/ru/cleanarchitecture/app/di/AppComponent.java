package kravchenko.ru.cleanarchitecture.app.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import kravchenko.ru.cleanarchitecture.data.repository.Repository;

@Singleton
@Component(modules = {NetworkModule.class,
        ContextModule.class})
public interface AppComponent {

    Context provideAppContext();

    void inject(Repository repository);
}