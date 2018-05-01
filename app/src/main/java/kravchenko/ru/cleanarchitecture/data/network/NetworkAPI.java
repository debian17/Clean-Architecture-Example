package kravchenko.ru.cleanarchitecture.data.network;

import java.util.List;

import io.reactivex.Single;
import kravchenko.ru.cleanarchitecture.data.model.MedOrg;
import retrofit2.http.GET;

public interface NetworkAPI {

    @GET("/elmedWebApiTest/api/m1/list_mo")
    Single<List<MedOrg>> getMedOrgs();

}
