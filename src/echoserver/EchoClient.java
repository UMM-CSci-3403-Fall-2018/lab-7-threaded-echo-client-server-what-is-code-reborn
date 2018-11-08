package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {
	
	public static final int PORT_NUMBER = 6013;

	public static void main(String[] args) throws IOException {
		
		EchoClient client = new EchoClient();
		client.start();
	}

	private void start() throws IOException, InterruptedException {
		
		Socket socket = new Socket("localhost", PORT_NUMBER);
		
		InputStream socketInputStream = socket.getInputStream();
		Thread iThread = new Thread(new ServerReader(socketInputStream));
		iThread.start();
		
		OutputStream socketOutputStream = socket.getOutputStream();
		Thread oThread = new Thread(new KeyboardReader(socketOutputStream));
		oThread.start();
		
		oThread.join();
		
		iThread.join();
		
		socket.close();
		
		System.out.flush();
	
	}
}
