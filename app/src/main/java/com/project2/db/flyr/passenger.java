package com.project2.db.flyr;

/**
 * Created by karthick on 11/15/2015.
 */
public class passenger {
    private String pid,pname,bid;
    int seatno;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public int getSeatno() {
        return seatno;
    }

    public void setSeatno(int seatno) {
        this.seatno = seatno;
    }
}
