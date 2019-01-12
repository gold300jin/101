package own;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.configureBlocking(false);
        ServerSocket serverSocket = ssChannel.socket();
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8888);
        serverSocket.bind(address);

        ServerSocketChannel ssChannel2 = ServerSocketChannel.open();
        ssChannel2.configureBlocking(false);
        ServerSocket serverSocket2 = ssChannel2.socket();
        InetSocketAddress address2 = new InetSocketAddress("127.0.0.1", 8889);
        serverSocket2.bind(address2);


        Selector selector = Selector.open();
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        ssChannel2.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {

            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = keys.iterator();

            while (keyIterator.hasNext()) {

                SelectionKey key = keyIterator.next();

                if (key.isAcceptable()) {

                    ServerSocketChannel ssChannel1 = (ServerSocketChannel) key.channel();
                    SocketChannel sChannel = ssChannel1.accept();
//                    System.out.println(readDataFromSocketChannel(sChannel));
//                    // 服务器会为每个新连接创建一个 SocketChannel
//                    sChannel.configureBlocking(false);
//
//                    // 这个新连接主要用于从客户端读取数据
//                    sChannel.register(selector, SelectionKey.OP_READ);

                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    sChannel.read(byteBuffer);
                    String result = new String(byteBuffer.array()).trim();
                    System.out.print(result);
                } else if (key.isReadable()) {

                    SocketChannel sChannel = (SocketChannel) key.channel();
                    System.out.println(readDataFromSocketChannel(sChannel));
                    sChannel.close();
                }

                keyIterator.remove();
            }
        }
    }

    private static String readDataFromSocketChannel(SocketChannel sChannel) throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        StringBuilder data = new StringBuilder();

        while (true) {

            buffer.clear();
            int n = sChannel.read(buffer);
            if (n == -1) {
                break;
            }
            buffer.flip();
            int limit = buffer.limit();
            char[] dst = new char[limit];
            for (int i = 0; i < limit; i++) {
                dst[i] = (char) buffer.get(i);
            }
            data.append(dst);
            buffer.clear();
        }
        return data.toString();
    }
}