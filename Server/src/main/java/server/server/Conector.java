/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server.server;

import java.io.*;
import java.net.*;

/**
 *
 * @author Marvin Jimenez
 */
public class Conector extends Thread{
    
    private Socket s;
    private ServerSocket ss;
    private InputStreamReader entradaSocket;
    private DataOutputStream salida;
    private BufferedReader entrada;
    final int puerto = 9000;
    
    public Conector(String nombre)
    {
        super(nombre);
    }
    
    public void enviarMSG(String msg)
    {
        try {
            this.salida.writeUTF(msg+"\n");
        } catch (IOException ex) {
        }
    }
    
    public void run()
    {
        String text="test";
        
        try {
        
        this.ss = new ServerSocket(puerto);
        this.s = ss.accept();
        
        this.entradaSocket = new InputStreamReader(s.getInputStream());
        this.entrada = new BufferedReader(entradaSocket);
        
        this.salida = new DataOutputStream(s.getOutputStream());
        while(true)
        {
            text = this.entrada.readLine();
            System.out.println(text);
            VServer.jTextArea1.setText(VServer.jTextArea1.getText()+"\n"+text);
        }
        } catch (IOException ex) {
            System.out.println("algun tipo de error ha sucedido");
        } ;
        
    }
    
    public String leerMSG()
    {
        try {
            return entrada.readLine();
        } catch (IOException ex) {
        } return null;
    }
    
    public void desconectar()
    {
        try {
            ss.close();
        } catch (IOException ex) {
        }
        try {
            s.close();
        } catch (IOException ex) {
        }
    }
    
    
    
}
