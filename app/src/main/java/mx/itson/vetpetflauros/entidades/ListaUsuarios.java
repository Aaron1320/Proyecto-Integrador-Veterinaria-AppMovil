package mx.itson.vetpetflauros.entidades;

import java.util.List;

public class ListaUsuarios {

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    private List<Usuario> usuarios;
}
