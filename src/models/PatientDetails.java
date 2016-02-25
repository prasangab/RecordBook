/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.HashMap;
import ui.AddPatient;

/**
 *
 * @author prasanga
 */
public class PatientDetails {

    public String name;
    public String age;
    public String patientID;
    public String town;
    public String date;
    public String pc;
    public String hpc;
    public String management;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return the patientID
     */
    public String getPatientID() {
        return patientID;
    }

    /**
     * @param patientID the patientID to set
     */
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    /**
     * @return the town
     */
    public String getTown() {
        return town;
    }

    /**
     * @param town the town to set
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the pc
     */
    public String getPc() {
        return pc;
    }

    /**
     * @param pc the pc to set
     */
    public void setPc(String pc) {
        this.pc = pc;
    }

    /**
     * @return the hpc
     */
    public String getHpc() {
        return hpc;
    }

    /**
     * @param hpc the hpc to set
     */
    public void setHpc(String hpc) {
        this.hpc = hpc;
    }

    /**
     * @return the management
     */
    public String getManagement() {
        return management;
    }

    /**
     * @param management the management to set
     */
    public void setManagement(String management) {
        this.management = management;
    }

}
