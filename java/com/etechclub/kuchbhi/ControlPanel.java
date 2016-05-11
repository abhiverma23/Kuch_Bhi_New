package com.etechclub.kuchbhi;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;

public class ControlPanel extends AppCompatActivity {

    boolean toggleSwitch1;
    boolean toggleSwitch2;
    boolean toggleSwitch3;
    boolean isConnected;

    String ip = "192.168.192.1";
    final String ping = "ping/ping.php", task = "task.php";
    int port = 8080;

    InputStream is = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("Control Panel", "In onCreate() Method");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control_panel);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.v("Control Panel", "In onCreateOptionMenu() Method");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_file, menu);

        return true;
    }

    public void connect(MenuItem item) {
        Log.v("Control Panel", "In connect() Method");
        TextView textView = (TextView) findViewById(R.id.connect_status);
        textView.setTextColor(Color.WHITE);
        textView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        textView.setText("Connected");
        // Add code here to check for ping
        // IF all things works fine then execute the below line
        isConnected = true;
    }

    public void toggleSwitch1(View view) {
        Log.v("Control Panel", "In toggleSwitch1() Method");
        TextView textView = (TextView) findViewById(R.id.toggle_text_switch1);
        ImageView imageView = (ImageView) findViewById(R.id.toggle_button_switch1);
        toggleSwitch1 = toggleSwitch1 ? false : true;
        if (toggleSwitch1) {
            textView.setText("ON");
            imageView.setImageResource(android.R.drawable.button_onoff_indicator_on);
        } else {
            textView.setText("OFF");
            imageView.setImageResource(android.R.drawable.button_onoff_indicator_off);
        }
    }

    public void toggleSwitch2(View view) {
        Log.v("Control Panel", "In toggleSwitch2() Method");
        TextView textView = (TextView) findViewById(R.id.toggle_text_switch2);
        ImageView imageView = (ImageView) findViewById(R.id.toggle_button_switch2);
        toggleSwitch2 = toggleSwitch2 ? false : true;
        if (toggleSwitch2) {
            textView.setText("ON");
            imageView.setImageResource(android.R.drawable.button_onoff_indicator_on);
        } else {
            textView.setText("OFF");
            imageView.setImageResource(android.R.drawable.button_onoff_indicator_off);
        }
    }

    public void toggleSwitch3(View view) {
        Log.v("Control Panel", "In toggleSwitch3() Method");
        TextView textView = (TextView) findViewById(R.id.toggle_text_switch3);
        ImageView imageView = (ImageView) findViewById(R.id.toggle_button_switch3);
        toggleSwitch3 = toggleSwitch3 ? false : true;
        if (toggleSwitch3) {
            textView.setText("ON");
            imageView.setImageResource(android.R.drawable.button_onoff_indicator_on);
        } else {
            textView.setText("OFF");
            imageView.setImageResource(android.R.drawable.button_onoff_indicator_off);
        }
    }

    public void timeSwitch(View view) {
        Log.v("Control Panel", "In timeSwitch() Method");
        int id = view.getId();
        Log.v("Control Panel", "Id is " + id);
        if (id == R.id.t1) {
            Toast.makeText(this, "Set Time for 1", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.t2) {
            Toast.makeText(this, "Set Time for 2", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.t3) {
            Toast.makeText(this, "Set Time for 3", Toast.LENGTH_SHORT).show();
        }
        // TODO : ADD task here to submit scheduled task
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        Log.v("Control Panel", "In Saving Data Method");
        bundle.putBoolean("switch1", toggleSwitch1);
        bundle.putBoolean("switch2", toggleSwitch2);
        bundle.putBoolean("switch3", toggleSwitch3);
        bundle.putBoolean("isConnected", isConnected);
        super.onSaveInstanceState(bundle);
    }

    @Override
    public void onRestoreInstanceState(Bundle bundle) {
        Log.v("Control Panel", "In Restoring data Method");
        super.onRestoreInstanceState(bundle);
        toggleSwitch1 = bundle.getBoolean("switch1");
        toggleSwitch2 = bundle.getBoolean("switch2");
        toggleSwitch3 = bundle.getBoolean("switch3");
        isConnected = bundle.getBoolean("isConnected");
        if (bundle.containsKey("ip")) {
            Toast.makeText(this, "Yes", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No", Toast.LENGTH_SHORT).show();
        }

        TextView textView = (TextView) findViewById(R.id.toggle_text_switch1);
        ImageView imageView = (ImageView) findViewById(R.id.toggle_button_switch1);
        if (toggleSwitch1) {
            textView.setText("ON");
            imageView.setImageResource(android.R.drawable.button_onoff_indicator_on);
        } else {
            textView.setText("OFF");
            imageView.setImageResource(android.R.drawable.button_onoff_indicator_off);
        }
        textView = (TextView) findViewById(R.id.toggle_text_switch2);
        imageView = (ImageView) findViewById(R.id.toggle_button_switch2);
        if (toggleSwitch2) {
            textView.setText("ON");
            imageView.setImageResource(android.R.drawable.button_onoff_indicator_on);
        } else {
            textView.setText("OFF");
            imageView.setImageResource(android.R.drawable.button_onoff_indicator_off);
        }
        textView = (TextView) findViewById(R.id.toggle_text_switch3);
        imageView = (ImageView) findViewById(R.id.toggle_button_switch3);
        if (toggleSwitch3) {
            textView.setText("ON");
            imageView.setImageResource(android.R.drawable.button_onoff_indicator_on);
        } else {
            textView.setText("OFF");
            imageView.setImageResource(android.R.drawable.button_onoff_indicator_off);
        }
        textView = (TextView) findViewById(R.id.connect_status);
        if (isConnected) {
            textView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            textView.setText("Connected");
        }

    }

    public void editConnection(MenuItem item) {
        Intent intent = new Intent("com.etechclub.kuchbhi.EDITCONNECTION");
        startActivity(intent);
    }


    /**
     * Code from here belongs to connecting to board
     */
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
                    "http://" + ip + ":" + port + "/php_project/" + tdo +"/?" + s);
            Log.e("Pass 1.0", "Link setup done");
            HttpResponse response = httpclient.execute(httppost);
            Log.e("Pass 1.0", "Link executed");
            HttpEntity entity = response.getEntity();
            Log.e("Pass 1.0", "Entity setup success");
            is = entity.getContent();
            check = true;
        } catch (Exception e) {
            Log.e("Fail 1", e.toString());
            check = false;
        } finally {
            return check;
        }
    }
}