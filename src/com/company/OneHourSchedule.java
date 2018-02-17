package com.company;
import java.util.ArrayList;

public class OneHourSchedule {
    private Integer hour_;
    private ArrayList<Integer> minutes_;

    OneHourSchedule(){

    }

    void setHour(String hour){
        hour_ = Integer.valueOf(hour);
        minutes_ = new ArrayList<>();
    }

    void setMinutes(ArrayList<String> minutes){
        for(String min : minutes){
            minutes_.add(Integer.valueOf(min));
        }
    }
}
