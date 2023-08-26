/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package server.server;

/**
 *
 * @author Windows 10
 */
public class Server {

    public static Conector servidor;
    public static void main(String[] args) {
        
        VServer server = new VServer();
        server.main();
        
    }
    
    public static void initServer()
    {
        servidor = new Conector("Server");
        servidor.start();
    }
}
