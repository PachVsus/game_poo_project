package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.GamePanel;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];


    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[25];    //Cantidad de Losas/Casillas.
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();
        loadMap("GameDev2D/res/maps/map001.txt");
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
            tile[11] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Wall_Center_Top.png"));

            tile[12] = new Tile();
            tile[12] .image = ImageIO.read(getClass().getResourceAsStream("res/tiles/Wall_Left_Single.png"));

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

        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath){
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                int col = 0;
                int row = 0;

                while(col < gp.maxScreenCol && row < gp.maxScreenRow){
                    String line = br.readLine();

                    while(col<gp.maxScreenCol){
                        String numbers[] = line.split(" ");
                        int num = Integer.parseInt(numbers[col]);

                        mapTileNum[col][row] = num;
                        col++;
                    }
                    if(col == gp.maxScreenCol){
                        col = 0;
                        row++;
                    }
                }
                br.close();
            }
        } catch (IOException | NumberFormatException e) {
        }
    }
    public void draw(Graphics2D g2){
        int col = 0; int row = 0; int x = 0; int y = 0;

        while(col < gp.maxScreenCol && row < gp.maxScreenRow){
            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize,  null);
            col++;
            x += gp.tileSize;
            if(col == gp.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;

            }
        }
    }

}