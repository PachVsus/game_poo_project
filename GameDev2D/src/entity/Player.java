package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.PlayerInput;

public class Player extends Entity{
    
    GamePanel gp;
    PlayerInput keyH;

    public Player(GamePanel gp, PlayerInput keyH){
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){ 
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";

    }

    public void getPlayerImage(){
        try {
            
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/TinMan_Up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/TinMan_Up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/TinMan_Down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/TinMan_Down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/TinMan_Left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/TinMan_Left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/TinMan_Right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/TinMan_Right_2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        //AFK 
        if(keyH.upPressed == true || keyH.downPressed == true ||  keyH.leftPressed == true ||   keyH.rightPressed == true){
            //AIK
         if(keyH.upPressed == true){
            direction = "up";
             y -= speed;
         } else if (keyH. downPressed == true){
             direction = "down";
             y += speed;
         } else if (keyH. leftPressed == true){
             direction = "left";
             x -= speed;
         } else if (keyH. rightPressed == true){
             direction = "right";
             x += speed;
         }
         spriteCounter++;
         if(spriteCounter > 12){
             if(spriteNum == 1){
                 spriteNum = 2;
             }else if (spriteNum == 2) {
                 spriteNum = 1;
             }
             spriteCounter = 0;
         }
        }

             
    }

    public void draw(Graphics2D g2){
       // g2.setColor(Color.white);
       //g2.fillRect(x, y, gp.tileSize, gp.tileSize); //Para
    

        BufferedImage image = null;
        switch(direction){
        case "up":
            if(spriteNum == 1){
                image = up1;
            }
            if(spriteNum == 2){
                image = up2;
            }
            
            break;

        case "down":
            if(spriteNum == 1){
            image = down1;
            }
            if(spriteNum == 2){
            image = down2;
            }
            break;

        case "left":
            if(spriteNum == 1){
                image = left1;
            }
            if(spriteNum == 2){
                image = left2;
            }
            break;
            
        case "right":
            if(spriteNum == 1){
                image = right1;
            }
            if(spriteNum == 2){
                image = right2;
            }
            break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    
        }
    
}