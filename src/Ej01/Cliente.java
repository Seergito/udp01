package Ej01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Cliente {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		DatagramSocket sck=new DatagramSocket();
		InetAddress ip=InetAddress.getLocalHost();
		
		int contador=0;
		while(true) {
			byte[] enviar=new byte[1024];
			if(contador>500) {
				String br="FIN";
				enviar=br.getBytes();
				DatagramPacket paquete=new DatagramPacket(enviar, enviar.length,ip,5000);
				sck.send(paquete);
				System.out.println(br);
				break;
			}
			
			String mensaje="Mensaje "+contador;
			enviar=mensaje.getBytes();
			
			DatagramPacket paquete=new DatagramPacket(enviar, enviar.length, ip, 5000);
			sck.send(paquete);
		
			contador++;
		}
		sck.close();
	}

}
