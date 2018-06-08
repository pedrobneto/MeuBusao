/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicaplayerofficial.Usuario;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author cadoafb
 */
public abstract class UsuarioBase implements Comparable<UsuarioBase> {

    private String usuario;
    private String senha;
    public static boolean vip = false;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Escreve no arquivo os atributos da classe usuario
     * @param u
     * @param s
     * @throws IOException 
     */
    public void escreveArquivo(String u, String s) throws IOException {

        File file = new File("/home/cadoafb/informacoesUsuario.log");

        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(u + " " + s + " " + vip + "\n");
            bw.close();
        }

    }

    public boolean isVip() {
        return vip;
    }

    
    /**
     * Funcao usada para comparar os atributos de usuario e senha 
     * dos objeto de Usuarios armazenados na árvore
     * @param o
     * @return 
     */
    @Override
    public int compareTo(UsuarioBase o) {
        int nome1 = usuario.toUpperCase().compareTo(o.getUsuario().toUpperCase());
        int senha1 = senha.toUpperCase().compareTo(o.getSenha().toUpperCase());

        if (usuario.toUpperCase().compareTo(o.getUsuario().toUpperCase()) == 0) {
            if (senha.toUpperCase().compareTo(o.getSenha().toUpperCase()) == 0) {
                return 0;
            } else {
                return senha1;
            }

        } else {
            return nome1;
        }

    }

}
