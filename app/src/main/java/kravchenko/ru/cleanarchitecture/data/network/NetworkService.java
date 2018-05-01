package kravchenko.ru.cleanarchitecture.data.network;

import java.util.List;

import io.reactivex.Single;
import kravchenko.ru.cleanarchitecture.data.model.MedOrg;

public class NetworkService {

    private NetworkAPI networkAPI;

    public NetworkService(NetworkAPI networkAPI) {
        this.networkAPI = networkAPI;
    }

    public Single<List<MedOrg>> loadMedOrg() {
        return networkAPI.getMedOrgs();
    }

}
