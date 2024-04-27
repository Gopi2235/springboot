
package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Passenger
{
    @Id
    @GeneratedValue
    int passengerid;
    String passengerName;
    String startingpoint;
    String destination;
    String mblno;
    String seatno;
    public Passenger(){

    }
    public Passenger(int passengerid, String passengerName, String startingpoint, String destination, String mblno,String seatno)
    {
        this.passengerid = passengerid;
        this.passengerName = passengerName;
        this.startingpoint = startingpoint;
        this.destination = destination;
        this.mblno = mblno;
        this.seatno = seatno;
    }
    public int getPassengerId() {
        return passengerid;
    }
    public void setPassengerId(int passengerid) {
        this.passengerid = passengerid;
    }
    public String getPassengerName() {
        return passengerName;
    }
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }
    public String getstartingpoint() {
        return startingpoint;
    }
    public void setstartingpoint(String startingpoint) {
        this.startingpoint = startingpoint;
    }
    public String getdestination() {
        return destination;
    }
    public void setdestination(String destination) {
        this.destination = destination;
    }
    public String getmblno() {
        return mblno;
    }
    public void setmblno(String mblno) {
        this.mblno = mblno;
    }
    public String getseatno() {
        return seatno;
    }
    public void setseatno(String seatno) {
        this.seatno = seatno;
    }
}



