package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText id_text = (EditText) findViewById(R.id.id_text);
        final EditText pw_text = (EditText) findViewById(R.id.pw_text);

        Button login_button = (Button) findViewById(R.id.login_button);
        TextView register_button = (TextView) findViewById(R.id.register_button);

//        register_button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
//                LoginActivity.this.startActivity(registerIntent);
//            }
//        });

        register_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                try{
                    Toast.makeText(LoginActivity.this, "버튼눌림", Toast.LENGTH_SHORT).show();
                    String result;
                    String id = id_text.getText().toString();
                    String pw = pw_text.getText().toString();

                    DbConnActivity task = new DbConnActivity();
                    result = task.execute(id, pw).get();

                }catch (Exception e ){
                    Log.i("DBtest",".......ERROR........!");
                }
            }
        });
    }
}