package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.myapplication.RegisterRequest.aaa;

public class RegisterActivity extends AppCompatActivity {
    EditText id_text, pw_text, name_text, birth_text, email_text, hp_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        id_text = (EditText) findViewById(R.id.id_text);
        pw_text = (EditText) findViewById(R.id.pw_text);
        name_text = (EditText) findViewById(R.id.name_text);
        birth_text = (EditText) findViewById(R.id.birth_text);
        email_text = (EditText) findViewById(R.id.email_text);
        hp_text = (EditText) findViewById(R.id.hp_text);

        final Button register_button = (Button) findViewById(R.id.register_button);

        RadioGroup gender_select = (RadioGroup) findViewById(R.id.radioGroup_gender);
        gender_select.getCheckedRadioButtonId();

        register_button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    register_button.setBackgroundResource(R.drawable.buttonshapecolored);
                }else if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    register_button.setBackgroundResource(R.drawable.buttonshape);
                }
                return false;
            }
        });

        register_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                try{
                    Toast.makeText(RegisterActivity.this, "버튼눌림", Toast.LENGTH_SHORT).show();
                    String result;
                    String id = id_text.getText().toString();
                    String pw = pw_text.getText().toString();
                    String name = name_text.getText().toString();
                    String birth = birth_text.getText().toString();
                    String email = email_text.getText().toString();
                    String hp  = hp_text.getText().toString();

                    RegisterRequest task = new RegisterRequest();
                    result = task.execute(id, pw, name, birth, email, hp).get();
                    if(result.equals("SUCCESS")){
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                        builder.setMessage("회원가입 성공")
                                .setPositiveButton("확인",null)
                                .create()
                                .show();
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        RegisterActivity.this.startActivity(intent);
                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                        builder.setMessage("회원가입 실패")
                                .setNegativeButton("다시 시도",null)
                                .create()
                                .show();
                    }
                    Toast.makeText(RegisterActivity.this, aaa, Toast.LENGTH_SHORT).show();

                }catch (Exception e ){
                    Log.i("XE",".......ERROR........!");
                }
            }
        });
    }
}