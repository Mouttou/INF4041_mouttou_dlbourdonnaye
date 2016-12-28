package com.example.nathalie.applicationmobile;

/**
 * Created by nathalie on 13/12/2016.
 */

// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

        import android.app.AlertDialog;
        import android.app.TimePickerDialog;
        import android.content.Context;
        import android.content.DialogInterface;
        import android.content.DialogInterface.OnClickListener;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.text.format.Time;
        import android.widget.TimePicker;
        import android.widget.TimePicker.OnTimeChangedListener;

        import java.io.IOException;
        import java.net.HttpURLConnection;
        import java.net.ProtocolException;
        import java.net.URL;

public class TimeSet extends AlertDialog implements OnClickListener, OnTimeChangedListener {

    public TimeSet(Context context, TimePickerDialog.OnTimeSetListener listener, int hourOfDay, int minute, boolean is24HourView) {
        super((Context)null, 0);
        throw new RuntimeException("Stub!");
    }

    public TimeSet(Context context, int themeResId, TimePickerDialog.OnTimeSetListener listener, int hourOfDay, int minute, boolean is24HourView) {
        super((Context)null, 0);
        throw new RuntimeException("Stub!");
    }

    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        throw new RuntimeException("Stub!");
    }

    public void onClick(DialogInterface dialog, int which) {
        throw new RuntimeException("Stub!");
    }

    public void updateTime(int hourOfDay, int minuteOfHour) {
        throw new RuntimeException("Stub!");
    }


    public Bundle onSaveInstanceState() {
        throw new RuntimeException("Stub!");
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");

    }

    public interface OnTimeSetListener {
        // void onTimeSet(TimePicker var1, int var2, int var3);
        //new MyAsyncTask().execute();
    }

}
