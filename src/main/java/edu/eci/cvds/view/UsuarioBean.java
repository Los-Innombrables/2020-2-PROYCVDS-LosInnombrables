package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.services.ServicesUsuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "usuarioBean")
@SessionScoped

public class UsuarioBean extends BasePageBean{

    private static final long serialVersionUID = 1L;

    @Inject
    private ServicesUsuario servicesUsuario;

    public List<Usuario> consultarEquipos() throws HistorialEquiposException {
        return servicesUsuario.consultarUsuarios();
    }

    public void addUsuario(int carnet, String nombre, String apellido, String correo, String username, String passwd, int rol) throws HistorialEquiposException {
        System.out.println(carnet);
        System.out.println(nombre);
        System.out.println(apellido);
        System.out.println(correo);
        System.out.println(username);
        System.out.println(passwd);
        System.out.println(rol);
        Usuario usuario = new Usuario(carnet, nombre, apellido, correo, username, this.convertSHA256(passwd), true, rol);
        servicesUsuario.addUsuario(usuario);
    }

    private String convertSHA256(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

        byte[] hash = md.digest(password.getBytes());
        StringBuffer sb = new StringBuffer();

        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }


}