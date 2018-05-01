package kravchenko.ru.cleanarchitecture.app.di;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kravchenko.ru.cleanarchitecture.data.network.NetworkAPI;
import kravchenko.ru.cleanarchitecture.data.network.NetworkService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    private static final String BASE_URL = "https://gosuslugi-rostov.ru/";

    @Provides
    @Singleton
    NetworkService providesNetWorkService(NetworkAPI networkAPI) {
        return new NetworkService(networkAPI);
    }

    @Provides
    @Singleton
    NetworkAPI providesNetworkAPI(Retrofit retrofit) {
        return retrofit.create(NetworkAPI.class);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(RxJava2CallAdapterFactory rxJava2CallAdapterFactory,
                             GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .addConverterFactory(gsonConverterFactory)
                .baseUrl(BASE_URL)
                .build();
    }

    @Provides
    @Singleton
    RxJava2CallAdapterFactory provideRx2ConverterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    @Singleton
    GsonConverterFactory provideGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new Gson();
    }

}
