package Ej01;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor {
	public static void main(String[] args) throws Exception {
		
		DatagramSocket sv_sck=new DatagramSocket(5000);
		PrintWriter fichero=new PrintWriter(new FileWriter("resultado.txt"));
		boolean fin=false;
		while(!fin) {
			
			byte[] recibir=new byte[1024];
			DatagramPacket paquete=new DatagramPacket(recibir, recibir.length);
			sv_sck.receive(paquete);
			
			String txt=new String(paquete.getData());
			System.out.println(txt);
			 
			 
			if(txt.equals("FIN")) {
				fin=true;
			}else {
				fichero.println(txt);
			}
		}
		System.out.println("ACABAO");
		sv_sck.close();
		fichero.close();
	}

}
