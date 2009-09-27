/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Vojin.data;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Schedule {
    public ArrayList<DayShift> schedule = new ArrayList<DayShift>();

    public Schedule() {
        for ( int i=0; i<14; i++){
            schedule.add(new DayShift());
        }
    }

    public ArrayList<DayShift> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<DayShift> schedule) {
        this.schedule = schedule;
    }
    
    
}
