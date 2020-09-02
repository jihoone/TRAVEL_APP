package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText id_text = (EditText) findViewById(R.id.id_text);
        EditText pw_text = (EditText) findViewById(R.id.pw_text);
        EditText name_text = (EditText) findViewById(R.id.name_text);
        EditText birth_text = (EditText) findViewById(R.id.birth_text);
        EditText email_text = (EditText) findViewById(R.id.email_text);
        EditText hp_text = (EditText) findViewById(R.id.hp_text);

        Button register_button = (Button) findViewById(R.id.register_button);

        RadioGroup gender_select = (RadioGroup) findViewById(R.id.radioGroup_gender);
        gender_select.getCheckedRadioButtonId();
    }
}