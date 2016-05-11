package com.etechclub.kuchbhi;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ControlPanel extends AppCompatActivity {

    private boolean toggleSwitch1 = false;
    private boolean toggleSwitch2 = false;
    private boolean toggleSwitch3 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control_panel);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_file, menu);

        return true;
    }

    public void connect(MenuItem item){
        TextView textView = (TextView) findViewById(R.id.connect_status);
        textView.setTextColor(Color.WHITE);
        textView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        textView.setText("Connected");
    }

    public void toggleSwitch1(View view) {
        TextView textView = (TextView)findViewById(R.id.toggle_text_switch1);
        ImageView imageView = (ImageView)findViewById(R.id.toggle_button_switch1);
        toggleSwitch1 = toggleSwitch1 ? false : true;
        if(toggleSwitch1){
            textView.setText("ON");
            imageView.setImageResource(android.R.drawable.button_onoff_indicator_on);
        }else{
            textView.setText("OFF");
            imageView.setImageResource(android.R.drawable.button_onoff_indicator_off);
        }
    }
}