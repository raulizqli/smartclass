package raulizq.smartclass;

import java.io.Serializable;

/**
 * Created by raulizq on 09/11/15.
 */
public class Usuario implements Serializable{

    private int _id;
    private String _usuario;
    private String _password;
    private int _permiso_id;

    public Usuario(){

    }

    public Usuario(int id, String usuario, String password, int _permiso_id){
        this._id = id;
        this._usuario = usuario;
        this._password = password;
        this._permiso_id = _permiso_id;
    }

    public Usuario(String usuario, String password){
        this._usuario = usuario;
        this._password = password;
    }

    public int getId(){
        return this._id;
    }

    public int getPermisoId(){
        return this._permiso_id;
    }

    public String getUsuario() {
        return _usuario;
    }

    public void setUsuario(String _usuario) {
        this._usuario = _usuario;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;

        if (!_usuario.equals(usuario._usuario)) return false;
        return _password.equals(usuario._password);

    }

    @Override
    public int hashCode() {
        int result = _id;
        result = 31 * result + _usuario.hashCode();
        result = 31 * result + _password.hashCode();
        result = 31 * result + _permiso_id;
        return result;
    }
}
