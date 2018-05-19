package kravchenko.ru.cleanarchitecture.app;

import android.app.Application;

import kravchenko.ru.cleanarchitecture.app.di.AppComponent;
import kravchenko.ru.cleanarchitecture.app.di.ContextModule;
import kravchenko.ru.cleanarchitecture.app.di.DaggerAppComponent;
import kravchenko.ru.cleanarchitecture.app.di.DaggerUseCaseComponent;
import kravchenko.ru.cleanarchitecture.app.di.RepositoryModule;
import kravchenko.ru.cleanarchitecture.app.di.UseCaseComponent;
import kravchenko.ru.cleanarchitecture.data.repository.Repository;

public class App extends Application {

    private static AppComponent appComponent;
    private static UseCaseComponent useCaseComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
        useCaseComponent = DaggerUseCaseComponent.builder()
                .repositoryModule(new RepositoryModule(new Repository()))
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static UseCaseComponent getUseCaseComponent() {
        return useCaseComponent;
    }


}
