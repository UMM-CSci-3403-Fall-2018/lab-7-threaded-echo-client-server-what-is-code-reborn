package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerReader implements Runnable {

    private InputStream istream;
    private Socket socket;

    public ServerReader(Socket socket) throws IOException {

        this.socket = socket;
        istream = socket.getInputStream();

    }

    public void run() {

        int readByte;

        try {

            while ((readByte = istream.read()) != -1) {

                System.out.write(readByte);
                System.out.flush();

            }

            socket.shutdownInput();

        }

        catch (IOException exception) {

            System.out.print(exception);

        }

    }

}
