package edu.iis.mto.time;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class AdjustableDateTime implements Clock {

    private List<DateTime> datesToReturn;

    public AdjustableDateTime() {
        datesToReturn = new ArrayList<>();
    }

    public void addDateToReturn(int year, int month, int day, int hour, int minute) {
        datesToReturn.add(new DateTime(year, month, day, hour, minute));
    }

    public DateTime getDate() {
        return datesToReturn.remove(0);
    }
}
