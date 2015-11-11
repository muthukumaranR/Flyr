package com.project2.db.flyr;

/**
 * Created by karthick on 06/10/2015.
 */

public class flight {
    private String fid, fname, origin, dest;
    private int maxseats, fare, start, end;

    public String getFid() {
        return fid;
    }

    public String getFname() {
        return fname;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDest() {
        return dest;
    }

    public int getMaxseats() {
        return maxseats;
    }

    public int getFare() {
        return fare;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setMaxseats(int maxseats) {
        this.maxseats = maxseats;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
