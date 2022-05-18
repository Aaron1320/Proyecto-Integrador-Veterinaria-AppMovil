package mx.itson.vetpetflauros.interfaces;

import mx.itson.vetpetflauros.entidades.ListaCitas;
import mx.itson.vetpetflauros.entidades.ListaMascotas;
import mx.itson.vetpetflauros.entidades.ListaUsuarios;
import mx.itson.vetpetflauros.entidades.Login;
import mx.itson.vetpetflauros.entidades.Mascota;
import mx.itson.vetpetflauros.entidades.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("mascota/showAll")
    Call<ListaMascotas> getMascotas();

    @GET("cita/showAll")
    Call<ListaCitas> getCitas();

 }
