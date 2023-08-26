/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cliente.cliente;

/**
 *
 * @author Windows 10
 */
public class Cliente {

    public static Conector cliente;
    public static void main(String[] args) {
       
        VCliente cliente = new VCliente();
        cliente.main();
        
    }
 
    public static void initCliente(String ip)
    {
       cliente = new Conector(ip); 
       cliente.start();
    }
}
