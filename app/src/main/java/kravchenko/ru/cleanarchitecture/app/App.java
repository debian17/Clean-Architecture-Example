package kravchenko.ru.cleanarchitecture.app;

import android.app.Application;

import kravchenko.ru.cleanarchitecture.app.di.AppComponent;
import kravchenko.ru.cleanarchitecture.app.di.ContextModule;
import kravchenko.ru.cleanarchitecture.app.di.DaggerAppComponent;

public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }


}
