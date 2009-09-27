/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Vojin.data;

/**
 *
 * @author Administrator
 */
public class DayShift {
    public String Sunday = null;
    public String Monday = null;
    public String Tuesday = null;
    public String Wednesday = null;
    public String Thursday = null;
    public String Friday = null;
    public String Saturday = null;


    public DayShift() {
        this.Sunday = "slobodan termin";
        this.Monday = "slobodan termin";
        this.Tuesday = "slobodan termin";
        this.Wednesday = "slobodan termin";
        this.Thursday = "slobodan termin";
        this.Friday = "slobodan termin";
        this.Saturday = "slobodan termin";
    }

    public String getFriday() {
        return Friday;
    }

    public void setFriday(String Friday) {
        this.Friday = Friday;
    }

    public String getMonday() {
        return Monday;
    }

    public void setMonday(String Monday) {
        this.Monday = Monday;
    }

    public String getSaturday() {
        return Saturday;
    }

    public void setSaturday(String Saturday) {
        this.Saturday = Saturday;
    }

    public String getSunday() {
        return Sunday;
    }

    public void setSunday(String Sunday) {
        this.Sunday = Sunday;
    }

    public String getThursday() {
        return Thursday;
    }

    public void setThursday(String Thursday) {
        this.Thursday = Thursday;
    }

    public String getTuesday() {
        return Tuesday;
    }

    public void setTuesday(String Tuesday) {
        this.Tuesday = Tuesday;
    }

    public String getWednesday() {
        return Wednesday;
    }

    public void setWednesday(String Wednesday) {
        this.Wednesday = Wednesday;
    }

    
}
