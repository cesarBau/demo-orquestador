package com.orquestador.pruebas.models.dto;

import com.orquestador.pruebas.models.Name;

public class NameResponse extends Name {

    private Integer id;
    private String message;

    public NameResponse() {
    }

    public NameResponse(String usuarioId, String nombre, String segundoNombre, Integer id, String message) {
        super(usuarioId, nombre, segundoNombre);
        this.id = id;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "NameResponse [id=" + id + ", message=" + message + "]";
    }

}
