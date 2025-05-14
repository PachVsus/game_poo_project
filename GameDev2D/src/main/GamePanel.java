package main;

import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
    
    //Ajustes de pantalla.
    final int ogTileSize = 16;    //16 x 16 Tile
    final int scale = 3;

    public final int tileSize = ogTileSize*scale;  //48*48 tile
    public final int maxScreenCol = 16     //Tamaño ancho pantalla.
;    //Tamaño alto pantalla.
    public final int maxScreenRow = 12;
    final int screenWidth = tileSize*maxScreenCol;  //48 * 16 = 768 pixels.
    final int screenHeight = tileSize*maxScreenRow; //48 * 12 = 576 pixels.

    //FPS's
    int FPS = 60; //Limite de FPS que queremos que pasan.

    TileManager tileM = new TileManager(this);
    PlayerInput keyH = new PlayerInput();
    Thread gameThread;  //
    Player player = new Player(this, keyH);


    //Constructor   
    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black); 
        this.setDoubleBuffered(true);   //Improves game performance.
        this.addKeyListener(keyH);  //Recibe input de usuario.
        this.setFocusable(true);

    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS; //0.01666 segundos
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;


        while(gameThread != null) {   //Ciclo while mientras juego corra.
        
            currentTime = System.nanoTime();
            timer += (currentTime - lastTime); 
            delta += (currentTime - lastTime)/drawInterval;
            lastTime = currentTime;

            if(delta >= 1){
            //UPDATE: Verificador de posicion de personaje.
                update();
            //DRAW: Dibuja en la pantalla con la posicion adquirida.
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer=0;
            }

        }        
    }

    public void update(){
        player.update();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        tileM.draw(g2);        
        player.draw(g2);
        g2.dispose();
    }
          
}