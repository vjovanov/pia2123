/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Vojin.data;

/**
 *
 * @author Administrator
 */
public class ReservationData {

    private int rId = 0;
    private int sId = 0;
    private int kId = 0;
    private String korisnik = null;
    private String namena = null;
    private String datum = null;
    private String datumRezervisanja = null;
    private int pocevOd = 0;
    private int trajanje = 0;
    private String sala = null;


    public ReservationData() {
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }



    public String getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(String korisnik) {
        this.korisnik = korisnik;
    }



    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getDatumRezervisanja() {
        return datumRezervisanja;
    }

    public void setDatumRezervisanja(String datumRezervisanja) {
        this.datumRezervisanja = datumRezervisanja;
    }

    public int getKId() {
        return kId;
    }

    public void setKId(int kId) {
        this.kId = kId;
    }

    public String getNamena() {
        return namena;
    }

    public void setNamena(String namena) {
        this.namena = namena;
    }

    public int getPocevOd() {
        return pocevOd;
    }

    public void setPocevOd(int pocevOd) {
        this.pocevOd = pocevOd;
    }

    

    public int getRId() {
        return rId;
    }

    public void setRId(int rId) {
        this.rId = rId;
    }

    public int getSId() {
        return sId;
    }

    public void setSId(int sId) {
        this.sId = sId;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    

}
