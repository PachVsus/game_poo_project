package tile;

import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class TileManager {
    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[25];    //Cantidad de Losas/Casillas.
        getTileImage();
    }

    public void getTileImage(){
        
        //Getter's de Casillas.
        try{
        
        //Piso [9]
            tile[0] = new Tile();
            tile[0] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Dirt_Center_Bottom.png"));

            tile[1] = new Tile();
            tile[1] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Dirt_Center_Top.png"));

            tile[2] = new Tile();
            tile[2] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Dirt_Center.png"));

            tile[3] = new Tile();
            tile[3] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Dirt_Left_Bottom.png"));

            tile[4] = new Tile();
            tile[4] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Dirt_Left_Top.png"));

            tile[5] = new Tile();
            tile[5] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Dirt_Left.png"));

            tile[6] = new Tile();
            tile[6] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Dirt_Right_Bottom.png"));

            tile[7] = new Tile();
            tile[7] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Dirt_Right_Center.png"));

            tile[8] = new Tile();
            tile[8] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Dirt_Right_Top.png"));

        //Paredes [13]
            tile[9] = new Tile();
            tile[9] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Wall_Center_Bottom.png"));

            tile[10] = new Tile();
            tile[10] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Wall_Center_Single.png"));

            tile[11] = new Tile();
            tile[12] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Wall_Center_Top.png"));

            tile[13] = new Tile();
            tile[13] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Wall_Center.png"));

            tile[14] = new Tile();
            tile[14] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Wall_Column.png"));

            tile[14] = new Tile();
            tile[14] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Wall_Left_Bottom.png"));

            tile[15] = new Tile();
            tile[15] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Wall_Left_Center.png"));

            tile[16] = new Tile();
            tile[16] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Wall_Left_Single.png"));

            tile[17] = new Tile();
            tile[17] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Wall_Left_Top.png"));

            tile[18] = new Tile();
            tile[18] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Wall_Right_Bottom.png"));

            tile[19] = new Tile();
            tile[19] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Wall_Right_Center.png"));

            tile[20] = new Tile();
            tile[20] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Wall_Right_Single.png"));

            tile[21] = new Tile();
            tile[21] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Wall_Right_Top.png"));

           

        //Agua/Aceite [1]
            tile[22] = new Tile();
            tile[22] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Oil.png"));
            
            /* 
            tile[23] = new Tile();
            tile[23] .image = ImageIO.read(getClass().getResourceAsStream(""));
            */

        }catch(IOException e){
            e.printStackTrace();
            
        }
    }
    public void draw(Graphics2D g2){
        g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, 48, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[2].image, 96, 0, gp.tileSize, gp.tileSize, null);
        
    }

}