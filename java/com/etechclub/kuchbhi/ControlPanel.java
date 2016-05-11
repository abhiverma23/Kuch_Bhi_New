package com.etechclub.kuchbhi;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ControlPanel extends AppCompatActivity {

    boolean toggleSwitch1;
    boolean toggleSwitch2;
    boolean toggleSwitch3;

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
        super.onSaveInstanceState(bundle);
    }

    @Override
    public void onRestoreInstanceState(Bundle bundle) {
        Log.v("Control Panel", "In Restoring data Method");
        super.onRestoreInstanceState(bundle);
        toggleSwitch1 = bundle.getBoolean("switch1");
        toggleSwitch2 = bundle.getBoolean("switch2");
        toggleSwitch3 = bundle.getBoolean("switch3");

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

    }
}