package com.example.nathalie.applicationmobile;

/**
 * Created by nathalie on 14/12/2016.
 */

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Request extends AppCompatActivity {

    String line = "";
    TextView tw;
    RelativeLayout rt;
    LinearLayout lt;

    private class Connection extends AsyncTask<Void, Void, ArrayList<Biere>>{

        @Override
        protected ArrayList<Biere> doInBackground(Void...arg0) {


            try {
                URL url = new URL("http://binouze.fabrigli.fr/bieres.json");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                String result = readStream(con.getInputStream());
                JSONArray myarray = new JSONArray(result);
                Log.d("Test", "connexion réussit");

                ArrayList<Biere> mylist = new ArrayList<>();

                for (int i = 0; i < myarray.length(); i++) {
                    JSONObject myobject = (JSONObject) myarray.get(i);
                    Biere mybiere = new Biere();
                    mybiere.name = myobject.getString("name");
                    mybiere.category_id = myobject.getString("category_id");
                    mylist.add(mybiere);

                }

                return mylist;

            } catch (Exception e) {
                e.printStackTrace();

                Log.d("test1","TEST POUR SIZE()" + e.getMessage());
            }
            return null;
        }


        protected void onPostExecute(ArrayList<Biere> mylist){

            Log.d("test300","Je sais pas ");

            tw.setText(mylist.size()+ " Bieres s" + mylist.get(0).name);

            for(int i=0; i<mylist.size(); i++){
                Biere mybiere = mylist.get(i);


                TextView tv = new TextView(Request.this);

                tv.setText(" " + mybiere.name);
                lt.addView(tv);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        Log.d("Test", "Initialisation classe");
        tw = (TextView) this.findViewById(R.id.textView);
        rt = (RelativeLayout) this.findViewById(R.id.activity_request);
        lt = (LinearLayout) this.findViewById(R.id.lt);

        new Connection().execute();
    }


    private String readStream(InputStream in) {
        BufferedReader reader = null;
        String result="";
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                result+=line;
                Log.d("test",line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } return result;
    }
}