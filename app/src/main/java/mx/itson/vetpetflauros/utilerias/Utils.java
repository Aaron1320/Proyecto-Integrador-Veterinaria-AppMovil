package mx.itson.vetpetflauros.utilerias;

import mx.itson.vetpetflauros.interfaces.ApiService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Utils {
    public static ApiService getApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://vetpet.site/public/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiService.class);
    }
}
