package mx.itson.vetpetflauros.interfaces;

import mx.itson.vetpetflauros.entidades.ListaMascotas;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("mascota/showAll")
    Call<ListaMascotas> getMascotas();

}
