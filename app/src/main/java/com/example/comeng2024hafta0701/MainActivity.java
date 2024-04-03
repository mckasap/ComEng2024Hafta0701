package com.example.comeng2024hafta0701;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
public void Getir(View v){

    HavaDurumuGetir hdg= new HavaDurumuGetir();

    JSONObject obj= null;
    try {
        obj = hdg.execute().get();
    } catch (ExecutionException e) {
        throw new RuntimeException(e);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

    Log.d("HAVA DURUMU ",obj.toString());
}

}