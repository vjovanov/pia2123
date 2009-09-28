

package com.Vojin.data.actionbeans;



import com.Vojin.data.ConnectionManager;
import com.sun.webui.jsf.model.Option;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Vojin
 */
public class UserRequestListing {

    private ArrayList<Option> requestList;
    private String result;

    public UserRequestListing() throws SQLException {
        requestList = new ArrayList<Option>();
        result = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet res = null;

        try {

                conn = ConnectionManager.getInstance().create();
                pst = conn.prepareStatement("select * from zahtevi_registracije where status=0");
                res = pst.executeQuery();
                while(res.next()){
                    requestList.add(new Option(res.getInt("zid"), res.getString("username")));
                }
                if (requestList.isEmpty()){
                    result = "no_more_requests";
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
    }

    public ArrayList<Option> getRequestList() {
        return requestList;
    }

    public void setRequestList(ArrayList<Option> requestList) {
        this.requestList = requestList;
    }

    

    public String action() throws SQLException{
        return result;
    }
}
