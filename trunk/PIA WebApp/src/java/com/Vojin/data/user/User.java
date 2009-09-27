/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Vojin.data.user;

import com.Vojin.data.LaboratoryData;
import com.Vojin.data.ReservationData;
import com.Vojin.data.UserData;
import com.sun.webui.jsf.model.Option;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.faces.context.FacesContext;


/**
 *
 * @author Administrator
 */
public class User {

    private ArrayList<Option> lista = new ArrayList<Option>();
    private String registerStatus = null;
    private int kId = 0;
    private String username = null;
    private String password = null;
    private String name = null;
    private String lastname = null;
    private String email = null;
    private String title = null;
    private int isAdmin = 0;
    private UserData user = new UserData();
    private int selected = 0;
    private ReservationData reservation = new ReservationData();
    private Date selectedDate = null;
    private int selectedRes = 0;
    private LaboratoryData lab = new LaboratoryData();


    public User() {
    }

    public LaboratoryData getLab() {
        return lab;
    }

    public void setLab(LaboratoryData lab) {
        this.lab = lab;
    }



    public int getSelectedRes() {
        return selectedRes;
    }

    public void setSelectedRes(int selectedRes) {
        this.selectedRes = selectedRes;
    }



    public Date getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(Date selectedDate) {
        this.selectedDate = selectedDate;
    }



    public ReservationData getReservation() {
        return reservation;
    }

    public void setReservation(ReservationData reservation) {
        this.reservation = reservation;
    }



    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    


    public ArrayList<Option> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Option> lista) {
        this.lista = lista;
    }

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }



    public int getKId() {
        return kId;
    }

    public void setKId(int kId) {
        this.kId = kId;
    }



    public String getRegisterStatus() {
        return registerStatus;
    }

    public void setRegisterStatus(String registerStatus) {
        this.registerStatus = registerStatus;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


// Class ActionLogin
    //
    public String userLogin() throws ClassNotFoundException, SQLException {
        String result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        Class c = Class.forName("com.mysql.jdbc.Driver");
         try {
               c.newInstance();
               conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_rezervacija","root","jebaga");
               pst = conn.prepareStatement("select * from korisnik where username=? and lozinka=?");
               pst.setString(1, username);
               pst.setString(2, password);
               res = pst.executeQuery();
               if (res.next()) {
                    kId = res.getInt("kid");
                    name = res.getString("ime");
                    lastname = res.getString("prezime");
                    email = res.getString("email");
                    title = res.getString("funkcija");
                    isAdmin = res.getInt("isAdmin");
                    if ( isAdmin == 1){
                        result = "admin_logged";
                    } else {
                        result = "user_logged";
                    }

                } else {
                    result = "bad_pass_or_user";
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
    public String userRegister() throws ClassNotFoundException, SQLException{
        String result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        Class c = Class.forName("com.mysql.jdbc.Driver");
       
        try {
               c.newInstance();
               conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_rezervacija","root","jebaga");


               pst = conn.prepareStatement("select * from korisnik where username=?");
               pst.setString(1, username);
               res = pst.executeQuery();
               if (res.next()) {
                    registerStatus = "Korisnik sa korisnickim imenom " + username + " vec postoji";
                    result = "no_error";

               } else {
                    pst = conn.prepareStatement("select * from zahtevi_registracije where username=?");
                    pst.setString(1, username);
                    res = pst.executeQuery();
                    if (res.next()) {
                        int status = res.getInt("status");
                        if ( status == 0){
                            registerStatus = "Vas zahtev je i dalje na razmatranju";
                            result = "no_error";
                        } else if ( status == 1 ) {
                            registerStatus = "Vas zahtev je vec odobren";
                            result = "no_error";
                        } else {
                            registerStatus = "Vas zahtev je odbijen";
                            result = "no_error";
                        }
                    } else {                        
                        pst = conn.prepareStatement("insert into zahtevi_registracije (username,lozinka,ime,prezime,email,funkcija,vreme_zahteva) " +
                                                    "values (?,?,?,?,?,?,?)");
                        pst.setString(1, username);
                        pst.setString(2, password);
                        pst.setString(3, name);
                        pst.setString(4, lastname);
                        pst.setString(5, email);
                        pst.setString(6, title);
                        Timestamp tms = new Timestamp(new Date().getTime());
                        pst.setString(7, tms.toString());
                        pst.executeUpdate();
                        registerStatus = "Vas zahtev je uspesno prosledjen";
                        result = "no_error";
                    }


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

    public String reservationList() throws ClassNotFoundException, SQLException{
        lista.clear();
        String result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        Class c = Class.forName("com.mysql.jdbc.Driver");

        try {
               c.newInstance();
               conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_rezervacija","root","jebaga");


               pst = conn.prepareStatement("select * from rezervacija where korisnik=?");
               pst.setInt(1, kId);
               res = pst.executeQuery();
               while ( res.next()){
                    lista.add(new Option(res.getInt("rid"),res.getString("datum")));
               }
               if (lista.isEmpty()){
                   result = "no_reservations";
               } else {
                   result = "reservations_loaded";
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

    public String reservationSelected() throws ClassNotFoundException, SQLException{
        String result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        Class c = Class.forName("com.mysql.jdbc.Driver");

        try {
               c.newInstance();
               conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_rezervacija","root","jebaga");


               pst = conn.prepareStatement("select * from rezervacija where rid=?");
               pst.setInt(1, selected);
               res = pst.executeQuery();
               if( res.next()){
                    reservation.setPocevOd(res.getInt("PocevOd"));
                    reservation.setRId(res.getInt("rid"));
                    reservation.setSId(res.getInt("sid"));
                    reservation.setNamena(res.getString("namena"));
                    reservation.setDatum(res.getString("datum"));
                    reservation.setTrajanje(res.getInt("Trajanje"));
               } else {
                   result = "error";
               }
               pst = conn.prepareStatement("select * from sala where sid=?");
               pst.setInt(1, reservation.getSId());
               res = pst.executeQuery();
               if(res.next()){
                   reservation.setSala(res.getString("naziv"));
                   result = "reservation_loaded";
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

    public String reservationDelete() throws ClassNotFoundException, SQLException{
        String result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        Class c = Class.forName("com.mysql.jdbc.Driver");

        try {
               c.newInstance();
               conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_rezervacija","root","jebaga");

               pst = conn.prepareStatement("delete from rezervacija where rid=?");
               pst.setInt(1, reservation.getRId());
               pst.executeUpdate();

               result = reservationList();

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

    public String manageReservation() throws ClassNotFoundException, SQLException{
        reservation = new ReservationData();
        lista.clear();
        String result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        Class c = Class.forName("com.mysql.jdbc.Driver");

        try {
               c.newInstance();
               conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_rezervacija","root","jebaga");


               pst = conn.prepareStatement("select * from sala");
               res = pst.executeQuery();
               while (res.next()){
                        lista.add(new Option(res.getInt("sid"),res.getString("naziv")));
               }

               result = "reserve";
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
    public String tryReservation() throws ClassNotFoundException, SQLException{
        String result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        Class c = Class.forName("com.mysql.jdbc.Driver");
        reservation.setDatum(new java.sql.Date(selectedDate.getTime()).toString());
        int reservedTime = 0;
        Calendar vreme = new GregorianCalendar();
        vreme.set(Calendar.HOUR_OF_DAY, reservation.getPocevOd());
        vreme.set(Calendar.MINUTE, 0);
        vreme.set(Calendar.SECOND, 0);
        try {
               c.newInstance();
               conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_rezervacija","root","jebaga");

               pst = conn.prepareStatement("select * from rezervacija where sid=? and datum=?");
               pst.setInt(1, selectedRes);
               pst.setString(2, reservation.getDatum());
               res = pst.executeQuery();


               if (!res.next()){
                   pst = conn.prepareStatement("INSERT INTO rezervacija (sid, korisnik, Namena,Datum,PocevOd,Trajanje,datumRezervisanja) VALUES (?,?,?,?,?,?,?)");
                   pst.setInt(1, selectedRes);
                   pst.setInt(2, user.getKId());
                   pst.setString(3, reservation.getNamena());
                   pst.setString(4, reservation.getDatum());
                   pst.setString(5, new java.sql.Time(vreme.getTime().getTime()).toString());
                   pst.setInt(6, reservation.getTrajanje());
                   pst.setString(7, new java.sql.Timestamp(new java.util.Date().getTime()).toString());
                   pst.executeUpdate();
               } else {
                   reservedTime = res.getInt("PocevOd");
                   for (int i=0; i<reservation.getTrajanje(); i++){
                       if (reservedTime == reservation.getPocevOd()){
                           result = "already_reserved";
                       }
                       reservedTime++;
                   }
                   if(result==null){
                       pst = conn.prepareStatement("INSERT INTO rezervacija (sid, korisnik, Namena,Datum,PocevOd,Trajanje,datumRezervisanja) VALUES (?,?,?,?,?,?,?)");
                       pst.setInt(1, selectedRes);
                       pst.setInt(2, user.getKId());
                       pst.setString(3, reservation.getNamena());
                       pst.setString(4, reservation.getDatum());
                       pst.setString(5, new java.sql.Time(vreme.getTime().getTime()).toString());
                       pst.setInt(6, reservation.getTrajanje());
                       pst.setString(7, new java.sql.Timestamp(new java.util.Date().getTime()).toString());
                       pst.executeUpdate();
                   }
               }
               if(result==null){
                    result = reservationList();
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
    

}
