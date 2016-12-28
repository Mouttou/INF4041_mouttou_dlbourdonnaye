package com.example.nathalie.applicationmobile;

/**
 * Created by nathalie on 13/12/2016.
 */

import java.io.Serializable;
import android.text.format.Time;



public class Alarm implements Serializable{
    private static final long serialVersionUID = 1L;
    private Time heure;
    private boolean active;
    public Time getHeure() {
        return heure;
    }
    public void setHeure(Time heure) {
        this.heure = heure;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

}
