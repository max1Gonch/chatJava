package sample.App;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sun.misc.MessageUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Created by Alastor on 01.10.2016.
 */
public class Client implements Runnable{
    private String line;
    private Thread t;
    private Socket connection;
    private InetAddress serverAddres;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private DataInputStream in ;
    private DataOutputStream out;

    public Client(String address) throws UnknownHostException {
        ///serverAddres.getByName(address);
        t = new Thread(this,"КлиентПоток");
        System.out.println("Клиентский поток запущен");
        t.start();
    }

    @Override
    public void run()
    {
        try {
            System.out.println("Тут");
            while (1>0)
            {
                    System.out.println("Глубже");
                connection = new Socket("127.0.0.1",5678);
                    System.out.println("Глубже1");
                output = new ObjectOutputStream(connection.getOutputStream());
                    System.out.println("Глубже2");
                input = new ObjectInputStream(connection.getInputStream());

                in = new DataInputStream(input);
                out = new DataOutputStream(output);


                    System.out.println("Глубже3");
            }
        } catch (IOException e) {
            System.out.print("Проблема IP client : " + e);
        }
    }
    public void sendMassage(String str)
    {
        try
        {
            line = str;

            out.writeUTF(line);
            out.flush();
           // заставляем поток закончить передачу данных.

            System.out.println("Собщение оправлено");

        }
        catch (IOException e) {
           System.out.println("Ошиюка отправки: " + e);
        }
    }


}
