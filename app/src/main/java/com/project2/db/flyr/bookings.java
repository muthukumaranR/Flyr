package com.project2.db.flyr;

import java.sql.Date;

/**
 * Created by karthick on 11/11/2015.
 */
public class bookings {
    private String bid,fid,uid,pid;
    private Date d;

    public String getBid() {
        return bid;
    }

    public String getFid() {
        return fid;
    }

    public String getUid() {
        return uid;
    }

    public String getPid() {
        return pid;
    }

    public Date getD() {
        return d;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setD(Date d) {
        this.d = d;
    }
}
