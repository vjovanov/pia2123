package com.Vojin.data.user.admin;

import com.Vojin.data.ConnectionManager;
import com.Vojin.data.LaboratoryData;
import com.Vojin.data.RequestData;
import com.Vojin.data.ReservationData;
import com.Vojin.data.UserData;
import com.Vojin.data.user.User;
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
public class Admin {

    private Date dateNow = new Date();
    private Date selectedDate = null;
    private String selectedRequest = null;
    private ArrayList<Option> userList = new ArrayList<Option>();
    private RequestData userRequest = null;
    private String selectedUser = null;
    private UserData user = new UserData();
    private ArrayList<Option> lista = new ArrayList<Option>();
    private String selected = null;
    private LaboratoryData lab = new LaboratoryData();
    private String reason = null;
    private ReservationData reservation = new ReservationData();
    private int selectedRes = 0;
    private ArrayList<Option> daNe = new ArrayList<Option>();

    public Admin() {
        daNe = new ArrayList<Option>();
        daNe.add(new Option(1, "da"));
        daNe.add(new Option(0, "ne"));
    }

    public ArrayList<Option> getDaNe() {
        return daNe;
    }

    public void setDaNe(ArrayList<Option> daNe) {
        this.daNe = daNe;
    }



    public ReservationData getReservation() {
        return reservation;
    }

    public void setReservation(ReservationData reservation) {
        this.reservation = reservation;
    }

    public int getSelectedRes() {
        return selectedRes;
    }

    public void setSelectedRes(int selectedRes) {
        this.selectedRes = selectedRes;
    }




    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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



    public LaboratoryData getLab() {
        return lab;
    }

    public void setLab(LaboratoryData lab) {
        this.lab = lab;
    }



    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
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

    public String getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(String selectedUser) {
        this.selectedUser = selectedUser;
    }



    public String getSelectedRequest() {
        return selectedRequest;
    }

    public void setSelectedRequest(String selectedRequest) {
        this.selectedRequest = selectedRequest;
    }


    public ArrayList<Option> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<Option> userList) {
        this.userList = userList;
    }

    public RequestData getUserRequest() {
        return userRequest;
    }

    public void setUserRequest(RequestData userRequest) {
        this.userRequest = userRequest;
    }


    public String userRequestsList() throws  ClassNotFoundException, SQLException{
        userList.clear();
        String result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet res = null;

        try {
                
                conn = ConnectionManager.getInstance().create();
                pst = conn.prepareStatement("select * from zahtevi_registracije where status=0");
                res = pst.executeQuery();
                while(res.next()){
                    userList.add(new Option(res.getString("username")));
                }
                if (userList.isEmpty()){
                    return "no_more_requests";
                } else {
                    result = "requests_loaded";
                }
            }   catch (Exception ex) {
                result = "error";
            }   finally {
                    if ( pst != null){
                        pst.close();
                    }
                    if ( conn !=null){
                        conn.close();
                    }
            }
   
        return result;

    }

    public String selectedUserReqeust() throws ClassNotFoundException, SQLException{
        String result = null;
        Connection conn = null;
        PreparedStatement pst = null;       
        ResultSet res = null;
        userRequest = new RequestData();

        try {                
                conn = ConnectionManager.getInstance().create();
                pst = conn.prepareStatement("select * from zahtevi_registracije where username=?");
                pst.setString( 1, selectedRequest);
                res = pst.executeQuery();

                if ( res.next()){
                    userRequest.setZId(res.getInt("zid"));
                    userRequest.setUsername(res.getString("username"));
                    userRequest.setPassword(res.getString("lozinka"));
                    userRequest.setName(res.getString("ime"));
                    userRequest.setLastname(res.getString("prezime"));
                    userRequest.setEmail(res.getString("email"));
                    userRequest.setTitle(res.getString("funkcija"));
                    userRequest.setRequestDate(res.getString("vreme_zahteva"));
                    result = "request_loaded";
                } else {
                    result = "error";
                }

            }   catch (Exception ex) {
                result = "error";
            }   finally {
                    if ( pst != null){
                        pst.close();
                    }
                    if ( conn !=null){
                        conn.close();
                    }
            }

        return result;
    }

    public String acceptRequest() throws ClassNotFoundException, SQLException{
        String result = null;
        Connection conn = null;
        PreparedStatement pst = null;        
        ResultSet res = null;
        try {                
                conn = ConnectionManager.getInstance().create();
                pst = conn.prepareStatement("update zahtevi_registracije set vreme_odluke=? where zId=?");
                pst.setTimestamp( 1, new Timestamp(new Date().getTime()));
                pst.setInt( 2, userRequest.getZId());
                pst.executeUpdate();
                pst = conn.prepareStatement("update zahtevi_registracije set status=? where zId=?");
                pst.setInt( 1, 1);
                pst.setInt( 2, userRequest.getZId());
                pst.executeUpdate();
                pst = conn.prepareStatement("insert into korisnik (username, lozinka, ime, prezime, email, funkcija) values (?,?,?,?,?,?)");
                pst.setString(1, userRequest.getUsername());
                pst.setString(2, userRequest.getPassword());
                pst.setString(3, userRequest.getName());
                pst.setString(4, userRequest.getLastname());
                pst.setString(5, userRequest.getEmail());
                pst.setString(6, userRequest.getTitle());
                pst.executeUpdate();

                result = userRequestsList();


            }   catch (Exception ex) {
                result = "error";
            }   finally {
                    if ( pst != null){
                        pst.close();
                    }
                    if ( conn !=null){
                        conn.close();
                    }
            }

        return result;
    }

    public String denyRequest() throws ClassNotFoundException, SQLException{
        String result = null;
        Connection conn = null;
        PreparedStatement pst = null;        
        ResultSet res = null;
        try {                
                conn = ConnectionManager.getInstance().create();
                pst = conn.prepareStatement("update zahtevi_registracije set vreme_odluke=? where zId=?");
                pst.setTimestamp( 1, new Timestamp(new Date().getTime()));
                pst.setInt( 2, userRequest.getZId());
                pst.executeUpdate();
                pst = conn.prepareStatement("update zahtevi_registracije set status=? where zId=?");
                pst.setInt( 1, 2);
                pst.setInt( 2, userRequest.getZId());
                pst.executeUpdate();

                result = userRequestsList();


            }   catch (Exception ex) {
                result = "error";
            }   finally {
                    if ( pst != null){
                        pst.close();
                    }
                    if ( conn !=null){
                        conn.close();
                    }
            }

        return result;
    }
    public String userListing() throws ClassNotFoundException, SQLException{
        userList.clear();
        String result = null;
        Connection conn = null;
        PreparedStatement pst = null;       
        ResultSet res = null;

        try {
                conn = ConnectionManager.getInstance().create();
                pst = conn.prepareStatement("select username from korisnik where isAdmin=0");
                res = pst.executeQuery();
                while(res.next()){
                    userList.add(new Option(res.getString("username")));
                }
                if (userList.isEmpty()){
                    return "no_users";
                } else {
                    result = "users_loaded";
                }
            }   catch (Exception ex) {
                result = "error";
            }   finally {
                    if ( pst != null){
                        pst.close();
                    }
                    if ( conn !=null){
                        conn.close();
                    }
            }

        return result;
    }
    public String selectedUserManage() throws ClassNotFoundException, SQLException{
        user = new UserData();
        String result = null;
        Connection conn = null;
        PreparedStatement pst = null;        
        ResultSet res = null;

        try {
                
                conn = ConnectionManager.getInstance().create();
                pst = conn.prepareStatement("select * from korisnik where username=?");
                pst.setString(1, selectedUser);
                res = pst.executeQuery();
                if(res.next()){
                    user.setKId(res.getInt("kid"));
                    user.setUsername(res.getString("username"));
                    user.setName(res.getString("ime"));
                    user.setLastname(res.getString("prezime"));
                    user.setEmail(res.getString("email"));
                    user.setTitle(res.getString("funkcija"));
                    result = "user_loaded";
                } else {
                    result = "error";
                }
            }   catch (Exception ex) {
                result = "error";
            }   finally {
                    if ( pst != null){
                        pst.close();
                    }
                    if ( conn !=null){
                        conn.close();
                    }
            }

        return result;
    }
    public String deleteUser() throws ClassNotFoundException, SQLException{
        String result = null;
        Connection conn = null;
        PreparedStatement pst = null;        
        ResultSet res = null;

        try {
                
                conn = ConnectionManager.getInstance().create();
                pst = conn.prepareStatement("delete from rezervacija where korisnik=?");
                pst.setInt(1, user.getKId());
                pst.executeUpdate();
                pst = conn.prepareStatement("delete from korisnik where username=?");
                pst.setString(1, selectedUser);
                pst.executeUpdate();
                result = userListing();

            }   catch (Exception ex) {
                result = "error";
            }   finally {
                    if ( pst != null){
                        pst.close();
                    }
                    if ( conn !=null){
                        conn.close();
                    }
            }

        return result;
    }

    public String addUser() throws ClassNotFoundException, SQLException{
        String result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        

        try {
            conn = ConnectionManager.getInstance().create();
                pst = conn.prepareStatement("insert into korisnik (username, lozinka, ime, prezime, email, funkcija) values (?,?,?,?,?,?)");
                pst.setString(1, user.getUsername());
                pst.setString(2, user.getPassword());
                pst.setString(3, user.getName());
                pst.setString(4, user.getLastname());
                pst.setString(5, user.getEmail());
                pst.setString(6, user.getTitle());
                pst.executeUpdate();
                result = "user_added";

            }   catch (Exception ex) {
                result = "error";
            }   finally {
                    if ( pst != null){
                        pst.close();
                    }
                    if ( conn !=null){
                        conn.close();
                    }
            }

        return result;
    }

    public String labListing() throws ClassNotFoundException, SQLException{
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

    public String selectLab() throws SQLException, ClassNotFoundException{
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
                   //result = "error";
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

    public String editLab() throws ClassNotFoundException, SQLException{
        String result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet res = null;        

        try {               
               conn = ConnectionManager.getInstance().create();
               pst = conn.prepareStatement("update sala set Lokacija=? where sid=?");
               pst.setString(1, lab.getLocation());
               pst.setInt(2, lab.getSId());
               pst.executeUpdate();
               pst = conn.prepareStatement("update sala set Kapacitet=? where sid=?");
               pst.setInt(1, lab.getCapacity());
               pst.setInt(2, lab.getSId());
               pst.executeUpdate();
               pst = conn.prepareStatement("update sala set BrRacunara=? where sid=?");
               pst.setInt(1, lab.getPcNumber());
               pst.setInt(2, lab.getSId());
               pst.executeUpdate();
               pst = conn.prepareStatement("update sala set ImaTablu=? where sid=?");
               pst.setInt(1, lab.getHasBlackboard());
               pst.setInt(2, lab.getSId());
               pst.executeUpdate();
               pst = conn.prepareStatement("update sala set ImaProjektor=? where sid=?");
               pst.setInt(1, lab.getHasProjector());
               pst.setInt(2, lab.getSId());
               pst.executeUpdate();
               
               result = labListing();

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

    public String daySet() throws SQLException, ClassNotFoundException{
        Calendar cal = new GregorianCalendar();
        cal.setTime(selectedDate);
        String result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet res = null;        
        int labCount = 0;

        try {            
            conn = ConnectionManager.getInstance().create();

            pst = conn.prepareStatement("select sid from sala");
            res = pst.executeQuery();
            while(res.next()){
                labCount++;
            }
            User userbean = (User)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
            for( int i=1; i<(labCount+1); i++){
                pst = conn.prepareStatement("insert into neradni_dani (sid, datum, vreme_evidentiranja, korisnik, razlog) VALUES (?,?,?,?,?)");
                pst.setInt(1, i);
                pst.setString(2, new java.sql.Date(cal.getTime().getTime()).toString());
                pst.setString(3, new java.sql.Date( new java.util.Date().getTime()).toString());
                pst.setInt(4, userbean.getKId());
                pst.setString(5, reason);
                pst.executeUpdate();
            }

            result = "day_added";
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

    public String userReservations() throws ClassNotFoundException, SQLException{
        lista.clear();
        String result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet res = null;        

        try {               
               conn = ConnectionManager.getInstance().create();


               pst = conn.prepareStatement("select * from rezervacija where korisnik=?");
               pst.setInt(1, user.getKId());
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
        

        try {
               
               conn = ConnectionManager.getInstance().create();


               pst = conn.prepareStatement("select * from rezervacija where rid=?");
               pst.setInt(1, selectedRes);
               res = pst.executeQuery();
               if( res.next()){
                    reservation.setRId(res.getInt("rid"));
                    reservation.setSId(res.getInt("sid"));
                    reservation.setNamena(res.getString("namena"));
                    reservation.setDatum(res.getString("datum"));
                    reservation.setTrajanje(res.getInt("Trajanje"));
                    reservation.setPocevOd(res.getInt("PocevOd"));
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
        

        try {
               
               conn = ConnectionManager.getInstance().create();

               pst = conn.prepareStatement("delete from rezervacija where rid=?");
               pst.setInt(1, reservation.getRId());
               pst.executeUpdate();

               result = userReservations();

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
        

        try {
               
               conn = ConnectionManager.getInstance().create();


               pst = conn.prepareStatement("select * from sala");
               res = pst.executeQuery();
               while (res.next()){
                        lista.add(new Option(res.getInt("sid"),res.getString("naziv")));
               }

               result = "reservation";
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
        reservation.setDatum(new java.sql.Date(selectedDate.getTime()).toString());
        int reservedTime = 0;
        int reservedLongitude = 0;
        Calendar vreme = new GregorianCalendar();
        vreme.set(Calendar.HOUR_OF_DAY, reservation.getPocevOd());
        vreme.set(Calendar.MINUTE, 0);
        vreme.set(Calendar.SECOND, 0);
        try {               
               conn = ConnectionManager.getInstance().create();

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
                   reservedLongitude = res.getInt("Trajanje");
                   if(((reservedTime+reservedLongitude)<reservation.getPocevOd()) || ((reservation.getPocevOd()+reservation.getTrajanje())<reservedTime)){
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
                       result = "already_reserved";
                   }
               }
               if(result==null){
                    result = userReservations();
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

