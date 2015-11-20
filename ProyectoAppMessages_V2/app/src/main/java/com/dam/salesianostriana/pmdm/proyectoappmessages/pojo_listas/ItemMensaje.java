package com.dam.salesianostriana.pmdm.proyectoappmessages.pojo_listas;

/**
 * Created by Jesús Pallares on 19/11/2015.
 */
public class ItemMensaje {

    private boolean enviado;
    private String cuerpo;

    public ItemMensaje(boolean enviado, String cuerpo) {
        this.enviado = enviado;
        this.cuerpo = cuerpo;
    }

    public boolean isEnviado() {
        return enviado;
    }

    public void setEnviado(boolean enviado) {
        this.enviado = enviado;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
}
