/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.cliente;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows 10
 */
public class Conector extends Thread{
    
    private Socket s;
    private ServerSocket ss;
    private InputStreamReader entradaSocket;
    private DataOutputStream salida;
    private BufferedReader entrada;
    final int puerto = 9000;
    
    public Conector(String ip)
    {
        try {
            this.s = new Socket(ip,puerto);
            
            this.entradaSocket = new InputStreamReader(s.getInputStream());
            this.entrada = new BufferedReader(entradaSocket);
            
            this.salida = new DataOutputStream(s.getOutputStream());
            this.salida.writeUTF("Conectado \n");
            
        } catch (IOException ex) {};
    }
    
    public void run()
    {
        String texto;
        while(true)
        {
            try {
            texto = entrada.readLine();
            VCliente.jTextArea1.setText(VCliente.jTextArea1.getText()+"\n"+texto);
        } catch (IOException ex) {};
        }
    }
    
    public void enviarMSG(String msg)
    {
        System.out.println("enviando");
        try {
            this.salida = new DataOutputStream(s.getOutputStream());
            this.salida.writeUTF(msg+"\n");
        } catch (IOException ex) {
            System.out.println("Problema al enviar");
        }
    }
    
    public String leerMSG()
    {
        try {
            return entrada.readLine();
        } catch (IOException ex) {} 
        return null;
    }
    
    public void desconectar()
    {
        try {
            ss.close();
        } catch (IOException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
    

