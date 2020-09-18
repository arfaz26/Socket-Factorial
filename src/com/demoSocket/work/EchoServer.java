package com.demoSocket.work;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private int fact(int n){
        if(n<=1){
            return 1;
        }
        else{
            return (n * fact(n-1));
        }
    }
    public static void main(String[] args){
        EchoServer echoServer = new EchoServer();
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("waiting for connection....");
            Socket socket= serverSocket.accept();
            System.out.println("connection established");
            DataInputStream din = new DataInputStream(socket.getInputStream());
            int a = din.readInt();
            System.out.println("received :"+a);
            System.out.println("processing....");
            int fact =echoServer.fact(a);
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            dout.writeInt(fact);
            dout.flush();
            System.out.println("processed!");
            dout.close();
            socket.close();
            serverSocket.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

//    public static void main(String[] args){
//        EchoServer echoServer = new EchoServer();
////        int a=echoServer.fact(5);
////        System.out.println(a);
//        try {
//            System.out.println("waiting for connection......");
//            ServerSocket serverSocket = new ServerSocket(8080);
//            Socket clientSocket = serverSocket.accept();
//            System.out.println("Connection established.");
//            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//            int line= Integer.parseInt(in.readLine());
//            System.out.println("received: "+line);
//            int ans =echoServer.fact(line);
//            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
//            out.println("From Server: "+ ans);
//        }
//        catch (Exception e){
////            System.out.println();
//            e.printStackTrace();
//        }
//
//    }
}
