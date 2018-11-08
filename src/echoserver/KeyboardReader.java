package echoserver;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class KeyboardReader implements Runnable {

    private OutputStream oStream;
    private Socket socket;

    public KeyboardReader(Socket socket) throws IOException {

        this.socket = socket;
        oStream = socket.getOutputStream();

    }

    public void run() {

        int readByte;

        try {

            while ((readByte = System.in.read()) != -1) {

                oStream.write(readByte);

            }

            socket.shutdownOutput();

        }

        catch (IOException exception) {

            System.out.print(exception);

        }

    }

}
