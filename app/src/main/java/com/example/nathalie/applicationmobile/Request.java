package com.example.nathalie.applicationmobile;

/**
 * Created by nathalie on 14/12/2016.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static android.content.ContentValues.TAG;

public class Request extends AppCompatActivity {

    //String line = "";
   // TextView tw;
   // RelativeLayout rt;
   // LinearLayout lt;
    BiereAdapter biereAdap;
    RecyclerView rv;

   /* private class Connection extends AsyncTask<Void, Void, ArrayList<Biere>>{

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
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        Log.d("Test", "Initialisation classe");
       // tw = (TextView) this.findViewById(R.id.textView);
       // rt = (RelativeLayout) this.findViewById(R.id.activity_request);
        //lt = (LinearLayout) this.findViewById(R.id.lt);

       //new Connection().execute();

        biereAdap= new BiereAdapter();
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new GridLayoutManager(this,2));
        rv.setAdapter(biereAdap);



        GetBieresService.startActionGetBieres(this);
        IntentFilter intentFilter = new IntentFilter(BIERES_UPDATE);
        LocalBroadcastManager.getInstance(this).registerReceiver(new BieresUpdate(), intentFilter);



    }
    public static final String BIERES_UPDATE = "BIERES_UPDATE";
    public class BieresUpdate extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, intent.getAction());
            biereAdap.setData(getBieresFromFile());
            if (intent.getAction().equals(BIERES_UPDATE))
                Toast.makeText(Request.this, R.string.succeed, Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(Request.this, R.string.failed, Toast.LENGTH_SHORT).show();
        }
    }
    public JSONArray getBieresFromFile() {
        try {
            InputStream is = new FileInputStream(getCacheDir() + "/" + "bieres.json");
            byte[] buf = new byte[is.available()];
            is.read(buf);
            is.close();
            return new JSONArray(new String(buf, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
            return new JSONArray();
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }

    /*private String readStream(InputStream in) {
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
    }*/
}