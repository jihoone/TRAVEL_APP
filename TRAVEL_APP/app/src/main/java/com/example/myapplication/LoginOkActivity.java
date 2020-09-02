package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginOkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ok);

        EditText id_text = (EditText) findViewById(R.id.id_text);
        EditText pw_text = (EditText) findViewById(R.id.pw_text);
        TextView welcome_message = (TextView) findViewById(R.id.welcome_message);
    }
}