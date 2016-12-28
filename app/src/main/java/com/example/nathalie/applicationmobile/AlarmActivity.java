package com.example.nathalie.applicationmobile;

/**
 * Created by nathalie on 13/12/2016.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class AlarmActivity extends Activity {
    Alarm alarm;
    Button bouton5;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_alarm);
        getInfos(alarm);
        save();



    }

    /*public void DoSomething()
    {
         TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                 @Override
                 public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                     Time t = new Time();
                     t.hour = hourOfDay;
                     t.minute = minute;
                     alarm.setHeure(t);
                     affichage(alarm);
                     planifierAlarm();
                 }
             }, alarm.getHeure().hour, alarm.getHeure().minute, true);
             dialog.show();
    }*/
    public void save(){


    }
    public  void getInfos(Alarm alarm){


    }


}