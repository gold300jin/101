package own;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClient {

    private static void send() throws IOException {
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8888);
        SocketChannel socketChannel = SocketChannel.open(address);
        byte[] message = "Hello World 1".getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(message);
        socketChannel.write(buffer);
        buffer.clear();
        socketChannel.close();
    }

    private static void send2() throws IOException {
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8889);
        SocketChannel socketChannel = SocketChannel.open(address);
        byte[] message = "Hello World 2".getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(message);
        socketChannel.write(buffer);
        buffer.clear();
        socketChannel.close();
    }

    public static void main(String[] args) throws IOException {
//        Socket socket = new Socket("127.0.0.1", 8888);
//        OutputStream out = socket.getOutputStream();
//        String s = "hello world";
//        out.write(s.getBytes());
//        out.close();
        send();
        send2();
    }
}