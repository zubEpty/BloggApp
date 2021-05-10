package com.example.blogg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.GetChars;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private static String JSON_URL = "https://raw.githubusercontent.com/Muhaiminur/muhaiminur.github.io/master/misfitflutter.tech";
   // private static String JSON_URL = "https://run.mocky.io/v3/6434eef5-6303-4bb1-ba5e-805e4a7f51ae";
    private static String JSON_URL = "https://run.mocky.io/v3/7fcf094a-c114-4b22-902a-e40896d921ab";


    List<blogModel> blogLists;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blogLists = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);

        GetData getData = new GetData();
        getData.execute();
    }


    public class GetData extends AsyncTask<String,String,String>
    {

        @Override
        protected String doInBackground(String... strings) {
            String current = "";

            try {
                URL url;
                HttpURLConnection urlConnection = null;

                try {
                    url = new URL(JSON_URL);
                    urlConnection = (HttpURLConnection) url.openConnection();


                    InputStream is = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);

                    int data = isr.read();
                    while(data != -1)
                    {
                        current += (char) data;
                        data = isr.read(); }

                    return  current;


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(urlConnection != null)
                    {
                        urlConnection.disconnect();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


            return current;
        }

        @Override
        protected void onPostExecute(String s) {

            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("blogs");
                for(int i =0;i<jsonArray.length(); i++)
                {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);


                    blogModel model = new blogModel();
                    model.setId(jsonObject1.getString("id"));
                    model.setTitle(jsonObject1.getString("title"));
                    model.setDescription(jsonObject1.getString("description"));
                    model.setImage(jsonObject1.getString("cover_photo"));
                    JSONArray categor = jsonObject1.getJSONArray("categories");
                    String value = categor.getString(0);
                    String value1 = categor.getString(1);
                    model.setCateg(value);
                    model.setCateg1(value1);


                   String author = jsonObject1.getString("author");
                    JSONObject jobj = new JSONObject(author);
                    String avt = jobj.getString("avatar");
                    String nameo = jobj.getString("name");
                    String prof = jobj.getString("profession");

                    model.setName(nameo);
                    model.setProf(prof);
                   model.setAvatar(avt);



                   // for(int j =0;j<categor.length();j++)
                   // {
                   //     model.setCateg(categor.getJSONObject(j).toString());
                   // }


                   ///////// model.setCateg(jsonObject1.getString("categories"));
                   // String author = jsonObject1.getString("author");

                  //  JSONObject jobj = new JSONObject(author);
                  //  String img = jobj.getString("avatar");
                  //  model.setImage(img);

                    //Log.e("ID",model.setId(jsonObject1.getString("id")));





                    //model.setImage(image.getString("avatar"));

                    //model.setTitle(jsonObject1.getString("title"));

                    blogLists.add(model);

                }



            } catch (JSONException e) {
                e.printStackTrace();
            }

            putDataintorecyclerView(blogLists);

        }
    }

    private void putDataintorecyclerView(List<blogModel> blogLists)
    {
        blogAdapter blogAdapter = new blogAdapter(this,blogLists);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        recyclerView.setAdapter(blogAdapter);
    }
}
