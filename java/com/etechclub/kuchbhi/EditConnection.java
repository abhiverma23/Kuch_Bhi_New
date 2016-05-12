package com.etechclub.kuchbhi;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class EditConnection extends AppCompatActivity {

    private String ip, port;
    final String ping = "ping/ping.php", task = "task.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_connection);
        if (StaticIp.ip == null) {
            setIp();
        }
        else{
            setStaticIp();
        }
    }

    private void setStaticIp() {
        Log.v("Edit Connection", "Setting Ip and Port");
        TextView textView = (TextView) findViewById(R.id.ip);
        textView.setText(StaticIp.ip);
        textView = (TextView) findViewById(R.id.port);
        textView.setText(StaticIp.port);
    }
    private void setIp() {
        Log.v("Edit Connection", "Setting Ip and Port");
        TextView textView = (TextView) findViewById(R.id.ip);
        textView.setText(getResources().getText(R.string.ip));
        textView = (TextView) findViewById(R.id.port);
        textView.setText(getResources().getText(R.string.port));
    }

    private void getIpPort() {
        Log.v("Edit Connection", "Getting Ip and Port");
        TextView textView = (TextView) findViewById(R.id.ip);
        ip = textView.getText().toString();
        textView = (TextView) findViewById(R.id.port);
        port = textView.getText().toString();
    }

    @Override
    protected void onPause() {
        Log.v("Edit Connection", "In onPause Method");
        getIpPort();
        StaticIp.ip = ip;
        StaticIp.port = port;
        StaticIp.isConnected = turn(null, ping);
        StaticIp.flagEditConnection = true;
        Log.v("Edit Connection", "Is connected or not" + StaticIp.isConnected);
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        Log.v("Edit Connection", "In Saving Data Method");
        getIpPort();
        bundle.putString("ip", ip);
        bundle.putString("port", port);
        super.onSaveInstanceState(bundle);

    }

    public void checkConnection(View view) {
        getIpPort();
        if (turn(null, ping)) {
            Toast.makeText(this, "Link Working", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error : Check IP and PORT #", Toast.LENGTH_SHORT).show();
        }
    }

    boolean turn(String s, String tdo) {
        boolean check = true;
        try {
            /*Log.e("Pass 1.0.1", "Going in big nap");
            Thread.sleep(20000);
            Log.e("Pass 1.0.1", "Aaah that was a real big nap....");*/
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            Log.e("Pass 1.0", "Line 1 Executed");
            StrictMode.setThreadPolicy(policy);
            Log.e("Pass 1.0", "Line 2 Executed");
            @SuppressWarnings("deprecation") HttpClient httpclient = new DefaultHttpClient();
            Log.e("Pass 1.0", "httpclient created");
            @SuppressWarnings("deprecation") HttpPost httppost = new HttpPost(
                    "http://" + ip + ":" + port + "/php_project/" + tdo + "/?" + s);
            Log.e("Pass 1.0", "Link setup done");
            HttpResponse response = httpclient.execute(httppost);
            Log.e("Pass 1.0", "Link executed");
            HttpEntity entity = response.getEntity();
            Log.e("Pass 1.0", "Entity setup success");
            //is = entity.getContent();
            check = true;
        } catch (Exception e) {
            Log.e("Fail 1", e.toString());
            check = false;
        } finally {
            return check;
        }
    }
}
