package com.project2.db.flyr;

import java.util.Date;

/**
 * Created by Deepak on 11/16/2015.
 */
public class seats {

    private String fid;
    private Date fdate;
    private int remseats;

    public void setid(String fid){
        this.fid = fid;
    }
    public String getfid(){
        return this.fid;
    }

    public void setfdate(Date fdate){ this.fdate = fdate; }
    public Date getfdate(){
        return this.fdate;
    }

    public void setseats(int remseats) { this.remseats = remseats; }
    public int getseats() { return  this.remseats;}

}
