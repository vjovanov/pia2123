/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Vojin.data;

/**
 *
 * @author Administrator
 */
public class LaboratoryData {
    private int sId = 0;
    private String name = null;
    private String location = null;
    private int capacity = 0;
    private int pcNumber = 0;
    private int hasBlackboard = 0;
    private int hasProjector = 0;

    public LaboratoryData() {
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getHasBlackboard() {
        return hasBlackboard;
    }

    public void setHasBlackboard(int hasBlackboard) {
        this.hasBlackboard = hasBlackboard;
    }

    public int getHasProjector() {
        return hasProjector;
    }

    public void setHasProjector(int hasProjector) {
        this.hasProjector = hasProjector;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPcNumber() {
        return pcNumber;
    }

    public void setPcNumber(int pcNumber) {
        this.pcNumber = pcNumber;
    }

    public int getSId() {
        return sId;
    }

    public void setSId(int sId) {
        this.sId = sId;
    }

    

}
