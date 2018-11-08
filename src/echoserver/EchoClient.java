package echoserver;

import java.io.IOException;
import java.net.Socket;
import java.lang.Thread;

public class EchoClient {
	
	public static final int PORT_NUMBER = 6013;

	public static void main(String[] args) throws IOException, InterruptedException {
		
		EchoClient client = new EchoClient();
		client.start();

	}

	private void start() throws IOException, InterruptedException {
		
		Socket socket = new Socket("localhost", PORT_NUMBER);
		
		Thread iThread = new Thread(new ServerReader(socket));
		iThread.start();
		
		Thread oThread = new Thread(new KeyboardReader(socket));
		oThread.start();
		
		oThread.join();
		
		iThread.join();
		
		socket.close();
		
		System.out.flush();
	
	}
}
