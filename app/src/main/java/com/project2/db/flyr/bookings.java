package com.project2.db.flyr;

import java.util.Date;

/**
 * Created by karthick on 11/11/2015.
 */
public class bookings {
    private String bid,fid,uid,pid;
    private Date bookedDate;

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Date getD() {
        return bookedDate;
    }

    public void setD(Date bookedDate) {
        this.bookedDate = bookedDate;
    }
}
