package com.example.android_samples.network;

import android.os.Handler;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocketHelper {
    private int mPort;
    private String mHostname;
    private Socket socket;

    public ClientSocketHelper(String hostname, int port) {
        mPort = port;
        mHostname = hostname;
    }


    public void sendMessage(final String message) {
        final Handler handler = new Handler();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    socket = new Socket(mHostname, mPort);

                    if (socket.isConnected()) {


                        OutputStream out = socket.getOutputStream();

                        PrintWriter output = new PrintWriter(out);

                        output.println(message);
                        output.flush();
                        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        final String st = input.readLine();

                        handler.post(new Runnable() {
                            @Override
                            public void run() {

                                String s = "mTextViewReplyFromServer.getText().toString()";
                                if (st.trim().length() != 0)
                                    Log.d("APP_DEBUG_SOCKET", s + "\nFrom Server : " + st);
                            }
                        });

                        output.close();
                        out.close();
                        socket.close();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
