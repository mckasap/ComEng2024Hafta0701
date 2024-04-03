package com.example.comeng2024hafta0701;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HavaDurumuGetir extends AsyncTask<String, Void, JSONObject> {

    @Override
    protected JSONObject doInBackground(String... strings) {
        String url="https://api.openweathermap.org/data/2.5/weather?lat=41.00213282964929&lon=39.71752631814765&appid=689e9049b1a24724ceca784c484685d3";
        String url2="https://api.openweathermap.org/data/2.5/weather?q="+ java.net.URLEncoder.encode(strings[0]).replace("+","%20")+"&appid=689e9049b1a24724ceca784c484685d3";
        StringBuilder sb= new StringBuilder();
        URL uri;
        try {
            if(strings[0]=="")
                uri = new URL(url);
            else
                uri=new URL(url2);

            HttpsURLConnection con= (HttpsURLConnection) uri.openConnection();
            con.connect();

            InputStream in = con.getInputStream();
            InputStreamReader reader= new  InputStreamReader(in);

            int data= reader.read();

            while(data!=-1){
             sb.append((char)data);
             data= reader.read();
            }

            JSONObject obj= new JSONObject(sb.toString());
            return obj;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }



    }
}
