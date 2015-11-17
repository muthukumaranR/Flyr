package com.project2.db.flyr;

/**
 * Created by karthick on 11/15/2015.
 */
public class passenger {
    private String pname;
    private int pid,bid,seatno;

    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getBid() {
        return bid;
    }
    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getSeatno() {
       return seatno;
    }
    public void setSeatno(int seatno) {
        this.seatno = seatno;
    }
}
