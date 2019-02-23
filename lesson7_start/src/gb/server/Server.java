package gb.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private Vector<ClientHandler> clients;
    private static final Logger logger = Logger.getLogger("");
    public Server() throws SQLException {
        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;
        try {
            AuthService.connect();
            server = new ServerSocket(8189);
            logger.log(Level.SEVERE, "Сервер запущен. Ожидаем клиентов...");
//            System.out.println("Сервер запущен. Ожидаем клиентов...");
            while (true) {
                socket = server.accept();
//                System.out.println("Клиент подключился");
                new ClientHandler(this, socket);
//
               // clients.add(new ClientHandler(this, socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AuthService.disconnect();
        }
    }

    public void subscribe(ClientHandler client) {
        clients.add(client);
        logger.log(Level.SEVERE, "Пользователь " + client.getNick() + " подключился");
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
        logger.log(Level.SEVERE, "Пользователь " + client.getNick() + " отключился");
    }
    public void errorConnect(){
        logger.log(Level.SEVERE, "Ошибка в подключении пользователя. Не верный логин/пароль");
    }

    public void broadcastMsg(String msg) {
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }
    }
}
