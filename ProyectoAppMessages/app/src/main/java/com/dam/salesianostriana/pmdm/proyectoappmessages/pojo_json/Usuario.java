package com.dam.salesianostriana.pmdm.proyectoappmessages.pojo_json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Jesús Pallares on 19/11/2015.
 */
public class Usuario {

    @SerializedName("nickname")
    @Expose
    private String nickname;

    /**
     * No args constructor for use in serialization
     *
     */
    public Usuario() {
    }

    /**
     *
     * @param nickname
     */
    public Usuario(String nickname) {
        this.nickname = nickname;
    }

    /**
     *
     * @return
     * The nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     *
     * @param nickname
     * The nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}