package com.api_customQueries02.api_customQueries02.Services;

import com.api_customQueries02.api_customQueries02.Entities.Month;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MonthServices {


    private ArrayList<Month> months = new ArrayList<>();


    public Month findMonthByNumber(Integer monthNumber) {
        for (Month month : months) {
            if (month.getMonthNumber().equals(monthNumber)){
                return month;
            }
        }
        return null;
    }


}