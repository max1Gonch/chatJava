package sample.App;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Alastor on 01.10.2016.
 */
public class Server extends Application implements Runnable {
    private Thread t;
     private ServerSocket server;
    private Socket connection;
    private String line = null;
    private  ObjectOutputStream output;
    private  ObjectInputStream input;
    private DataInputStream in ;
    private DataOutputStream out;




    @Override
    public void start(Stage primaryStage) throws Exception {
        ActivStage ass = new ActivStage(primaryStage);
        ass.nextStage("..\\Style\\StyleServer.fxml");
        t = new Thread(this,"СерверПоток");
        System.out.println("Серверный поток запущен!");
        t.start();
    }



    @Override
    public void run() {
        try {
            System.out.println("Тут");
            server = new ServerSocket(5678,10);
            while (true)
            {

                connection = server.accept();

                output = new ObjectOutputStream(connection.getOutputStream());

                input = new ObjectInputStream(connection.getInputStream());

                in = new DataInputStream(input);
                out = new DataOutputStream(output);
                    System.out.println("Глубже");

                line = in.readUTF();
                System.out.println(line);
                out.writeUTF(line); // отсылаем клиенту обратно ту самую строку текста.
                out.flush();

            }
        } catch (IOException e) {
            System.out.print("Проблема IP server : " + e);
        }
    }
}
