package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThreader implements Runnable {

    private OutputStream oStream;
    private Socket socket;

    public ServerThreader(Socket socket) throws IOException {

        this.socket = socket;

    }

    public void run() {

        int readByte;

        try {

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            while ((readByte = inputStream.read()) != -1) {

                outputStream.write(readByte);

            }

            socket.shutdownOutput();

        }

        catch (IOException exception) {

            System.out.print(exception);

        }

    }

}
