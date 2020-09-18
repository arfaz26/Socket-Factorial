package com.demoSocket.work;

import java.io.*;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("localhost",8080);
            BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
            String str  = bin.readLine();
            int a = Integer.valueOf(str);
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            dout.writeInt(a);
            dout.flush();
            DataInputStream din = new DataInputStream(socket.getInputStream());
            System.out.println("Factorial :"+din.readInt());
            din.close();
            dout.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//    public static void main(String[] args){
//        try{
//            System.out.println("Client started");
//            Socket socket = new Socket("localhost",8080);
//
//            BufferedReader inputData = new BufferedReader(new InputStreamReader(System.in));
//            System.out.println("Enter numbers: ");
////            String input= inputData.readLine();
//              int a = Integer.parseInt(inputData.readLine());
//
//            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
//            out.println(a);
//            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            System.out.println(in.readLine());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
