/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optica.model;

/**
 *
 * @author ivan
 */
public class Usuario {
    private int idUsuario;
    private int usuario;
    private String nombre;
    private String contrasenia;
    private String rol;
    private String lastToken;
    private String dateLasToken;

    public Usuario() {
    }

    public Usuario(int usuario, String nombre, String contrasenia, String rol, String lastToken, String dateLasToken) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.lastToken = lastToken;
        this.dateLasToken = dateLasToken;
    }

    public Usuario(int idUsiario, int usuario, String nombre, String contrasenia, String rol, String lastToken, String dateLasToken) {
        this.idUsuario = idUsiario;
        this.usuario = usuario;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.lastToken = lastToken;
        this.dateLasToken = dateLasToken;
    }

    public int getIdUsiario() {
        return idUsuario;
    }

    public int getUsuario() {
        return usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getRol() {
        return rol;
    }

    public String getLastToken() {
        return lastToken;
    }

    public String getDateLasToken() {
        return dateLasToken;
    }

    public void setIdUsiario(int idUsiario) {
        this.idUsuario = idUsiario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setLastToken(String lastToken) {
        this.lastToken = lastToken;
    }

    public void setDateLasToken(String dateLasToken) {
        this.dateLasToken = dateLasToken;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsiario=" + idUsuario + ", usuario=" + usuario + ", nombre=" + nombre + ", contrasenia=" + contrasenia + ", rol=" + rol + ", lastToken=" + lastToken + ", dateLasToken=" + dateLasToken + '}';
    }
    
    
}