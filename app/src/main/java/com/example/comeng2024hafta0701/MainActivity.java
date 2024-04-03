package com.example.comeng2024hafta0701;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
TextView tv;
EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= (TextView) findViewById(R.id.textView);
        et= (EditText) findViewById(R.id.editTextText);
    }
public void Getir(View v){

    HavaDurumuGetir hdg= new HavaDurumuGetir();

    JSONObject obj= null;
    try {
        if(et.getText().toString().equals(""))
                obj = hdg.execute().get();
        else
            obj=hdg.execute(et.getText().toString()).get();
    } catch (ExecutionException e) {
        throw new RuntimeException(e);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

    Log.d("HAVA DURUMU ",obj.toString());

    try {
        JSONObject main=obj.getJSONObject("main");
        double Temp = main.getDouble("temp")-275.13;
        tv.setText("" +Temp+" C");

    } catch (JSONException e) {
        throw new RuntimeException(e);
    }

}

}