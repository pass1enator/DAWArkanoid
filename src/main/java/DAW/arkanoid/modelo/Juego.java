/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAW.arkanoid.modelo;

import DAW.arkanoid.interfaz.CanvasLayer;
import javafx.geometry.Point2D;

/**
 *
 * @author Pedro
 */
enum EstadoJuego {
    PENDIETEINICIAR,
    INICIADO
}

public class Juego {

    private Campo campo;
   
    public static int ANCHO = 448;
    public static int ALTO = 480;
   
   
    public Juego() {
        this.campo = new Campo(Juego.ANCHO, Juego.ALTO);
        this.campo.setVelocidad(1.0f);
        this.campo.getBarra().setAlto(16);
        this.campo.getBarra().setAncho(64);
        
    }

   
    /**
     * ciclo del juego, se mueve la pelota, comprueba colision con barra y ladrillos
     * si es con ladrillos se devuelve true para repintar el fondo.
     * @param pulsados
     * @return 
     */
    public EstadoCambiosJuego ciclo(boolean pulsados[]) {
        EstadoCambiosJuego vuelta=EstadoCambiosJuego.NADA;
       
        if (pulsados[0]) {
            this.moverBarraIzquierda();
        }
        if (pulsados[1]) {
            this.moverBarraDerecha();
        }
        //si devuelve true es que toca fondo
        if(this.moverPelota())
            vuelta=EstadoCambiosJuego.TOCABORDE;
       
        return vuelta;
    }
    
     public boolean moverPelota() {
        boolean tocafondo=false;
       
            this.campo.getPelota().mover();
            // pelota.mover();
        
         return tocafondo;
    }
    
    public void moverBarraIzquierda() {
       
        
            this.campo.getBarra().moverIzquierda();
           
    }
    public void moverBarraDerecha() {
        
            this.campo.getBarra().moverDerecha();
         
        
    }

   
    /**
     * @return the campo
     */
    public Campo getCampo() {
        return campo;
    }

    /**
     * @param campo the campo to set
     */
    public void setCampo(Campo campo) {
        this.campo = campo;
    }
   

    

   

   
   
}
