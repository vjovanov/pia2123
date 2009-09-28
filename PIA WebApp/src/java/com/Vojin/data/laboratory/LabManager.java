/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Vojin.data.laboratory;

import com.Vojin.data.ConnectionManager;
import com.Vojin.data.DayShift;
import com.Vojin.data.LaboratoryData;
import com.Vojin.data.Schedule;
import com.sun.webui.jsf.model.Option;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 *
 * @author Administrator
 */
public class LabManager {
    private Date dateNow = new Date();
    private Date selectedDate = null;
    private String selected = null;
    private ArrayList<Option> lista = new ArrayList<Option>();
    private Schedule labSchedule = null;
    private LaboratoryData lab = new LaboratoryData();


    public LabManager() {
    }

    public LaboratoryData getLab() {
        return lab;
    }

    public void setLab(LaboratoryData lab) {
        this.lab = lab;
    }


    public Schedule getLabSchedule() {
        return labSchedule;
    }

    public void setLabSchedule(Schedule labSchedule) {
        this.labSchedule = labSchedule;
    }

    

    public Date getDateNow() {
        return dateNow;
    }

    public void setDateNow(Date dateNow) {
        this.dateNow = dateNow;
    }


    public Date getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(Date selectedDate) {
        this.selectedDate = selectedDate;
    }



    public ArrayList<Option> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Option> lista) {
        this.lista = lista;
    }

    
    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }



    public String laboratoryList () throws ClassNotFoundException, SQLException{
        lista.clear();
        String result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet res = null;
       
        try {               
               conn = ConnectionManager.getInstance().create();

               pst = conn.prepareStatement("select naziv from sala");
               res = pst.executeQuery();
               while (res.next()){                  
                        lista.add(new Option(res.getString("naziv")));
               }

               result = "labs_loaded";
        } catch (Exception ex) {
                result = "error";
        } finally{
            if ( pst != null){
            pst.close();
            }
            if ( conn !=null){
            conn.close();
            }
        }
        return result;
    }
    public String laboratorySelected() throws ClassNotFoundException, SQLException{
        String result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        try {
               
               conn = ConnectionManager.getInstance().create();


               pst = conn.prepareStatement("select * from sala where naziv=?");
               pst.setString(1, selected);
               res = pst.executeQuery();
               if ( res.next()){
                    lab.setSId(res.getInt("sid"));
                    lab.setLocation(res.getString("Lokacija"));
                    lab.setCapacity(res.getInt("Kapacitet"));
                    lab.setPcNumber(res.getInt("BrRacunara"));
                    lab.setHasBlackboard(res.getInt("ImaTablu"));
                    lab.setHasProjector(res.getInt("ImaProjektor"));
                    result = "loaded_lab_characteristics";
               } else {
                   result = "error";
               }

        } catch (Exception ex) {
                result = "error";
        } finally{
            if ( pst != null){
            pst.close();
            }
            if ( conn !=null){
            conn.close();
            }
        }
        return result;
    }


    public String laboratoryReservation() throws ClassNotFoundException, SQLException{
        labSchedule = new Schedule();
        Calendar cal = new GregorianCalendar();
        cal.setTime(selectedDate);
        Calendar cal2 = new GregorianCalendar();        
        String result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        ResultSet resUser = null;        
        int hourOfDay = 0;
        DayShift week = null;
        int shiftTime = 0;
        String text = null;

        try {            
            conn = ConnectionManager.getInstance().create();

            for( int i=0; i<7; i++){
                cal2.setTime(cal.getTime());
                cal2.roll(Calendar.DAY_OF_YEAR, (i-cal.get(Calendar.DAY_OF_WEEK)+1));
                pst = conn.prepareStatement("select * from neradni_dani where datum=? and sid=?");
                pst.setString(1, new java.sql.Date(cal2.getTime().getTime()).toString());
                pst.setInt(2, lab.getSId());
                res = pst.executeQuery();
                if (res.next()){
                    text = "neradni dan";
                    for( int k=0; k<14; k++){
                        week = labSchedule.schedule.get(k);
                        if(i==0){
                            week.setSunday(text);
                        } else if(i==1){
                            week.setMonday(text);
                        } else if(i==2){
                            week.setTuesday(text);
                        } else if(i==3){
                            week.setWednesday(text);
                        } else if(i==4){
                            week.setThursday(text);
                        } else if(i==5){
                            week.setFriday(text);
                        } else if(i==6){
                            week.setSaturday(text);
                        }
                    }
                } else {
                    pst = conn.prepareStatement("select * from rezervacija where datum=? and sid=?");
                    pst.setString(1, new java.sql.Date(cal2.getTime().getTime()).toString());
                    pst.setInt(2, lab.getSId());
                    res = pst.executeQuery();
                    while (res.next()){
                        shiftTime = res.getInt("Trajanje");
                        cal2.setTime(new java.sql.Time(res.getTime("PocevOd").getTime()));
                        hourOfDay = cal2.get(Calendar.HOUR_OF_DAY);
                        pst = conn.prepareStatement("select * from korisnik where kid=?");
                        pst.setInt(1, res.getInt("korisnik"));
                        resUser = pst.executeQuery();
                        resUser.next();
                        text = resUser.getString("ime") + " " + resUser.getString("ime")
                                        + "      " + res.getString("namena");
                        for (int j=0; j<shiftTime; j++){
                            week = labSchedule.schedule.get((hourOfDay - 8 + j));
                            if(i==0){
                                week.setSunday(text);
                            } else if(i==1){
                                week.setMonday(text);
                            } else if(i==2){
                                week.setTuesday(text);
                            } else if(i==3){
                                week.setWednesday(text);
                            } else if(i==4){
                                week.setThursday(text);
                            } else if(i==5){
                                week.setFriday(text);
                            } else if(i==6){
                                week.setSaturday(text);
                            }
                        }
                    }
                }


            }
            result = "izabrana_nedelja";
        } catch (Exception ex) {
                result = "error";
        } finally{
            if ( pst != null){
            pst.close();
            }
            if ( conn !=null){
            conn.close();
            }
        }
        return result;
    }


}
