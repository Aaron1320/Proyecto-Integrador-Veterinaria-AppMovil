package mx.itson.vetpetflauros.entidades;

import java.util.List;

public class ListaMascotas {
    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    private List<Mascota> mascotas;

}
