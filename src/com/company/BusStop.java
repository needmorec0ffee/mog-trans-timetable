package com.company;


import java.util.ArrayList;

public class BusStop {
    private boolean is_weekend_;
    private String name_;
    private ArrayList<OneHourSchedule> schedule_;

    BusStop(String name, boolean is_weekend){
        name_ = name;
        is_weekend_ = is_weekend;
        schedule_ = new ArrayList<>();
    }

    void setSchedule(String schedule){
        String[] strList = schedule.split(" ");
        ArrayList<String> minutes = new ArrayList<>();
        String hour = "";
        for(String str : strList){
            if(str.length() == 4){
                if(!minutes.isEmpty()){
                    OneHourSchedule ohs = new OneHourSchedule();
                    ohs.setHour(hour);
                    ohs.setMinutes(minutes);
                    schedule_.add(ohs);
                }
                hour = str.substring(0, 2);
                minutes.clear();
                minutes.add(str.substring(2, 4));
            } else {
                minutes.add(str);
            }
        }
    }
}
