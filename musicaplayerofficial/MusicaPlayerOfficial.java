/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicaplayerofficial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import musicaplayerofficial.Arvores.ArvoreBinariaBusca;
import musicaplayerofficial.Telas.TelaInicial;
import musicaplayerofficial.Usuario.UsuarioBase;
import musicaplayerofficial.Usuario.UsuarioComum;

/**
 *
 * @author cadoafb
 */
public class MusicaPlayerOfficial <Type extends Comparable<Type>>{

    /**
     * @param args the command line arguments
     */
    private Player playmp3;
    private FileInputStream fil;
    private long instanteDaPausa;
    private long instanteTotalMusica;
    private String arquivoGuardado;
    private boolean deuStop = false;
    
    
    public static void main(String[] args) throws IOException {
        
//        UsuarioBase u = new UsuarioComum();
//        u.escreveArquivo("ss", "ks");
//        u.escreveArquivo("mai", "un");
          ArvoreBinariaBusca<UsuarioBase> u = new ArvoreBinariaBusca<>();
        
    }
    
    /**
     * Vai no diretoria passado no parametro e executa o arquivo
     * de musica selecionado
     * @param diretorio
     * @throws IOException 
     */
    public void vaiNaPasta(String diretorio) throws IOException {
      
        try {
            if(playmp3 != null)
                playmp3.close();
            fil = new FileInputStream(diretorio);
            playmp3 = new Player(fil);
            
            
            instanteTotalMusica = fil.available();
            arquivoGuardado = diretorio + "";
        }
        catch(FileNotFoundException | JavaLayerException e) {
            
            System.out.println(e);
            
        }
        
            new Thread() {

                @Override
                public void run() {
                    try {
                        playmp3.play();
                    //    System.out.println(playmp3.get);
                    } 
                    catch (JavaLayerException ex) {
                        Logger.getLogger(MusicaPlayerOfficial.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
    }
    
    /**
     * Para a musica que está atualmente tocando
     */
    public void stopMusic() {
        if(playmp3 != null)
        {
            playmp3.close();
            
            //zerar os dois se n o botao de parar n "para"
            instanteDaPausa = 0;
            instanteTotalMusica = 0;
            deuStop = true;
            
            TelaInicial.zera();
        }
    }
    
    /**
     * Pausa a musica que está atualmente tocando
     * e armazena o segundo de onde ela parou
     * @throws IOException 
     */
    public void pauseMusic() throws IOException {
        if(playmp3 != null)
        {
                instanteDaPausa = fil.available();
                playmp3.close();
              //  deuStop = true;
            
        }
                
          
    }
    
    /**
     * Retoma a musica de onde ela tinha sido pausada
     * @throws IOException 
     */
    public void resumeMusica() throws IOException {
        
        try {
            if(!deuStop) {
                fil = new FileInputStream(arquivoGuardado);
                playmp3 = new Player(fil);

                //resume de onde a musica parou
                fil.skip(instanteTotalMusica - instanteDaPausa);
            }    
            

                
            

            
        }
        catch(FileNotFoundException | JavaLayerException e) {
            
            System.out.println(e);
            
        }
        
        new Thread() {
            
            @Override
            public void run() {
                try {
                    
                        playmp3.play();
                        if(playmp3.isComplete()){
                        //Quando a musica acabar, o nome dela apaga da tela
                        TelaInicial.zera();
       
                    }
                        
                //deuStop = false;        
                } 
                catch (JavaLayerException ex) {
                    Logger.getLogger(MusicaPlayerOfficial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
        
    }
    
}
