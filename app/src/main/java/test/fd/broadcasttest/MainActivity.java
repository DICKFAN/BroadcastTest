package test.fd.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "Broadcast_TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendBroadcastButton=(Button) findViewById(R.id.SendBroadcast);
        sendBroadcastButton.setOnClickListener(BroadcastListener);
    }

    Button.OnClickListener BroadcastListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            generateBroadcastEvent();
        }
    };
    //generate Broadcast event
    public void generateBroadcastEvent(){
        Log.v(TAG,"Send broadcast message");
        Intent intent=new Intent("test.fd.broadcasttest.BROADCAST");
        sendBroadcast(intent);
    }
    public static class MyBroadcast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent){
            Log.v(TAG,"received broadcast message");
            doBroadcastProcess();
        }
    }
    //process broadcast message
    private static void doBroadcastProcess(){
        Log.v(TAG,"process broadcast message");
    }
}
