package com.example.android_samples.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketHelper {

    public interface IServerSocketListener{
        void notifyMessage(String message);
    }

    private boolean mEnd = false;
    private int mPort;
    private IServerSocketListener mListener;

    public ServerSocketHelper(IServerSocketListener listener,int port) {
        mPort = port;
        mListener = listener;
    }


    public void finalizeSocket(){
        mEnd = true;
    }

    public void initialize(){
        Thread thread = new Thread(new Runnable() {

            private String stringData = null;

            @Override
            public void run() {

                try {

                    ServerSocket ss = new ServerSocket(mPort);
                    while (!mEnd) {
                        // Server is waiting for client here, if needed
                        Socket s = ss.accept();
                        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
                        PrintWriter output = new PrintWriter(s.getOutputStream());

                        stringData = input.readLine();
                        output.println("FROM SERVER - " + stringData.toUpperCase());
                        output.flush();

                        mListener.notifyMessage(stringData);

                        if (stringData.equalsIgnoreCase("STOP")) {
                            mEnd = true;
                            output.close();
                            s.close();
                            break;
                        }

                        output.close();
                        s.close();
                    }
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
        thread.start();
    }
}
