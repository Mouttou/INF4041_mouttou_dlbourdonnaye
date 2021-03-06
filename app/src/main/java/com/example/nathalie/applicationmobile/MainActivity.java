package com.example.nathalie.applicationmobile;


import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MainActivity extends AppCompatActivity {

    Alarm alarm = new Alarm();
    android.text.format.Time t = new android.text.format.Time();
    Button bouton5;
    Button bouton2;
    ListView recyclerList;


    public void onCreate(Bundle savedInstanceState) {

//Chargement des informations du reveil
        charger();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Affichage
        affichage(alarm);
//Planification
        //planifierAlarm();

        bouton5 = (Button) findViewById(R.id.button5);

        bouton5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String url = "https://www.google.fr/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            };
        });
        bouton2 = (Button) findViewById(R.id.button2);

        bouton2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.toolbarB, Toast.LENGTH_LONG).show();
            };
        });



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setSubtitle(getString(R.string.ToolbarUse));
    }


    public void charger() {

        try {
            ObjectInputStream alarmOIS = new ObjectInputStream(openFileInput("alarm.serial"));
            alarm = (Alarm) alarmOIS.readObject();
            alarmOIS.close();
            sauver(alarm);
        } catch (FileNotFoundException fnfe) {
            android.text.format.Time t = new android.text.format.Time();
            t.hour = 10;
            t.minute = 30;
            alarm.setHeure(t);
            alarm.setActive(true);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }

    public void sauver(Alarm alarm) {
        /*try {
            ObjectOutputStream alarmOOS= new ObjectOutputStream(openFileOutput("alarm.serial",MODE_WORLD_WRITEABLE));
            alarmOOS.writeObject(alarm);
            alarmOOS.flush();
            alarmOOS.close();
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }*/
    }

    private void affichage(Alarm alarm) {
//Ici on a juste voulu créer un affichage de l'heure qui soit au format hh:mm.
        String heureReveil = "";
        heureReveil += alarm.getHeure().hour > 10 ? alarm.getHeure().hour : "0" + alarm.getHeure().hour;
        heureReveil += ":";
        heureReveil += alarm.getHeure().minute > 10 ? alarm.getHeure().minute : "0" + alarm.getHeure().minute;
        // CheckBox ck_alarm = (CheckBox)findViewById(R.id.heure);
        //    ck_alarm.setText(heureReveil);
        //   ck_alarm.setChecked(alarm.isActive());
    }

    public void changeHeure(View target) {

        CheckBox ck_alarm = (CheckBox) findViewById(R.id.heure);
        // TimePicker pick=new
//Si on active l’alarm alors on veut choisir l’heure.
        if (ck_alarm.isChecked()) {
            TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    android.text.format.Time t = new android.text.format.Time();
                    t.hour = hourOfDay;
                    t.minute = minute;
                    alarm.setHeure(t);
                    affichage(alarm);
                    //planifierAlarm();
                    Toast.makeText(getApplicationContext(), getString(R.string.toastSaver) + t.hour + " : " + t.minute, Toast.LENGTH_LONG).show();
                    TextView total = (TextView) findViewById(R.id.heure);
                    total.setText(t.hour + ":" + t.minute);
                }
            }, alarm.getHeure().hour, alarm.getHeure().minute, true);
            dialog.show();
        }
    }


    public void biere(View target)
    {
        Intent intent = new Intent(this, Request.class);
        startActivity(intent);
    }

}