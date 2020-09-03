package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
<<<<<<< HEAD
=======

import static com.example.myapplication.DbConnActivity.aaa;
>>>>>>> refs/remotes/origin/minseok

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

        Button register_button = (Button) findViewById(R.id.register_button);

        RadioGroup gender_select = (RadioGroup) findViewById(R.id.radioGroup_gender);
        gender_select.getCheckedRadioButtonId();


        register_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                try{
                    Toast.makeText(RegisterActivity.this, "버튼눌림", Toast.LENGTH_SHORT).show();
                    String result;
                    String id = id_text.getText().toString();
                    String pw = pw_text.getText().toString();
                    String name = name_text.getText().toString();
<<<<<<< HEAD
                    int birth = Integer.parseInt(birth_text.getText().toString());
=======
                    String birth = birth_text.getText().toString();
>>>>>>> refs/remotes/origin/minseok
                    String email = email_text.getText().toString();
                    String hp  = hp_text.getText().toString();

                    DbConnActivity task = new DbConnActivity();
                    result = task.execute(id, pw, name, birth, email, hp).get();
<<<<<<< HEAD

                }catch (Exception e ){
                    Log.i("DBtest",".......ERROR........!");
=======
                    Toast.makeText(RegisterActivity.this, aaa, Toast.LENGTH_SHORT).show();

                }catch (Exception e ){
                    Log.i("XE",".......ERROR........!");
>>>>>>> refs/remotes/origin/minseok
                }
            }
        });
    }
}