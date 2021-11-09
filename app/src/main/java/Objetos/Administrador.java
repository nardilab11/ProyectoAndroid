package Objetos;

import java.util.Arrays;

public class Administrador {
    private String[] usuarios = {"Nico", "Diego"};
    private String[] contrasenas = {"ABC123", "456DEF"};

    public Administrador() {
    }

    public Administrador(String[] usuarios, String[] contrasenas) {
        this.usuarios = usuarios;
        this.contrasenas = contrasenas;
    }

    public String[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(String[] usuarios) {
        this.usuarios = usuarios;
    }

    public String[] getContrasenas() {
        return contrasenas;
    }

    public void setContrasenas(String[] contrasenas) {
        this.contrasenas = contrasenas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrador that = (Administrador) o;
        return Arrays.equals(usuarios, that.usuarios) && Arrays.equals(contrasenas, that.contrasenas);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(usuarios);
        result = 31 * result + Arrays.hashCode(contrasenas);
        return result;
    }

}
