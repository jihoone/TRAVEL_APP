package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
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

        register_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

        login_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                try{
                    Toast.makeText(LoginActivity.this, "버튼눌림", Toast.LENGTH_SHORT).show();
                    String result;
                    String id = id_text.getText().toString();
                    String pw = pw_text.getText().toString();

                    LoginRequest task = new LoginRequest();
                    result = task.execute(id, pw).get();
                    if(!result.equals("SUCCESS")){
                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                        builder.setMessage("아이디/비밀번호를 다시 확인해주세요.")
                                .setNegativeButton("다시 시도",null)
                                .create()
                                .show();
                    }else{
                        Intent loginOk = new Intent(LoginActivity.this, LoginOkActivity.class);
                        LoginActivity.this.startActivity(loginOk);
                    }

                }catch (Exception e ){
                    Log.i("XE",".......ERROR........!");
                }
            }
        });

    }
}