package com.project2.db.flyr;

import java.util.Date;

/**
 * Created by karthick on 11/11/2015.
 */
public class bookings {
    private String fid;
    private int uid,pid;
    private String bookedDate;
    private int bid;


    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getD() {
        return bookedDate;
    }

    public void setD(String bookedDate) {
        this.bookedDate = bookedDate;
    }
}
