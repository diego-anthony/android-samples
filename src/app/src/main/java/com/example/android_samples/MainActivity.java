package com.example.android_samples;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.example.android_samples.network.ClientSocketHelper;
import com.example.android_samples.network.ServerSocketHelper;

public class MainActivity extends FragmentActivity implements View.OnClickListener,ServerSocketHelper.IServerSocketListener {
    private Context mContext;
    private final Handler handler = new Handler();
    private static final int PORT = 8082;
    private static final String HOSTNAME = "127.0.0.1";
    private ClientSocketHelper clientSocketHelper;
    private TextView txtMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSendMessage = findViewById(R.id.BTN_SEND_MESSAGE);
        txtMessage = findViewById(R.id.txt_message);


        btnSendMessage.setOnClickListener(this);

        ServerSocketHelper serverSocketHelper = new ServerSocketHelper(this,PORT);
        serverSocketHelper.initialize();



        mContext = this;
        clientSocketHelper = new ClientSocketHelper(HOSTNAME,PORT);
    }

    @Override
    public void onClick(View v) {
        clientSocketHelper.sendMessage(txtMessage.getText().toString());
    }

    @Override
    public void notifyMessage(final String message) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}
