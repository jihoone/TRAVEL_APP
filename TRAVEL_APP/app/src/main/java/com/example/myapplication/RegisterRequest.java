package com.example.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class RegisterRequest extends AsyncTask<String , Void, String> {
    String sendMsg, receiveMsg;
    HashMap<String, String> sendPost;
    static String aaa = "안들어옴";
    @Override
    protected String doInBackground(String... strings){
        HttpURLConnection conn = null;
        try{
            aaa="try문은 들어옴";
            String str;
            //접속할 서버 주소 (이클립스에서 android.jsp 실행시 웹브라우저 주소)
            URL url = new URL("http://192.168.0.5:8091/DbConn/Android/register.jsp");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream(),"UTF-8");

            //전송할 데이터. GET 방식으로 작성
            sendMsg = "id="+strings[0]+"&pw=" + strings[1]+"&name=" + strings[2]+"&birth=" + strings[3]+"&email=" + strings[4]+"&hp=" + strings[5];
            sendPost = new HashMap<>();
            sendPost.put("id", strings[0]);
            sendPost.put("pw", strings[1]);
            sendPost.put("name", strings[2]);
            sendPost.put("birth", strings[3]);
            sendPost.put("email", strings[4]);
            sendPost.put("hp", strings[5]);
            osw.write(sendMsg);
            osw.flush();

            //jsp와 통신 성공시 수행
            if(conn.getResponseCode()==conn.HTTP_OK){
                aaa="통신성공";
                InputStreamReader tmp = new InputStreamReader(conn.getInputStream(),"UTF-8");
                BufferedReader reader = new BufferedReader(tmp);
                StringBuffer buffer = new StringBuffer();

                //jsp에서 보낸 값을 받는 부분
                while((str = reader.readLine())!=null){
                    buffer.append(str);
                }
                receiveMsg = buffer.toString();
            }else{
                //통신실패
                aaa="통신실패";
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        return receiveMsg;
    }
}
