package com.example.tema_nuevo;

import static java.lang.invoke.VarHandle.AccessMode.GET;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextClock;
import android.widget.TextView;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import WebService.Asynchtask;
import WebService.WebService;

public class MainActivity extends AppCompatActivity
implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

            public void btlogin (View view){
                Map<String, String> datos = new HashMap<String, String>();
                String url ="https://revistas.uteq.edu.ec/ws/login.php?usr=fernando&pass=fernando123";
                WebService ws= new WebService(url, datos,
                        MainActivity.this, MainActivity.this);
                ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {

        if(result.equals("Login Correcto ")){
            Intent intent = new  Intent (MainActivity.this, MainActivity.class);
            startActivity(intent);
        }else {
TextView txtmensaje = (TextView) findViewById(R.id.txtmensaje);
txtmensaje.setText("error al iniciar sesion :  "+ result);
    }
}