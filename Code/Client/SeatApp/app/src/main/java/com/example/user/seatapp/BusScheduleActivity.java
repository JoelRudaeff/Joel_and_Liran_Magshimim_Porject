package com.example.user.seatapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;

public class BusScheduleActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_schedule);

        Intent intent = getIntent();
        TextView cur = (TextView) findViewById(R.id.b_cur);
        TextView dest = (TextView) findViewById(R.id.b_dest);
        LinkedList<String> places_linkedlist = new LinkedList<String>(); // a linked list of the place
        LinkedList<Integer> times_linkedlist = new LinkedList<Integer>(); // a linked list of the time to go from a place to the next place in the places' list
        ArrayAdapter<CharSequence> places_adapter = ArrayAdapter.createFromResource(this, R.array.cities_array, android.R.layout.simple_spinner_item);

        int i;
        int add_to_lt = 0; //add this time to the leaving time - the time difference between 2 trains

        String current_place = "";
        String destination_place = "";
        String company = "";
        String leaving_time = "";
        String NextLeavingTime;
        String arriving_time;
        String BusNumber;

        if( !( intent.getExtras().getString("current").isEmpty() )) //If the user entered her/his current place
        {
            cur.setText(intent.getExtras().getString("current"));
            current_place = intent.getExtras().getString("current");
        }

        if( !( intent.getExtras().getString("destination").isEmpty() )) //If the user entered her/his current place
        {
            dest.setText(intent.getExtras().getString("destination"));
            destination_place = intent.getExtras().getString("destination");
        }

        if( !( intent.getExtras().getString("company").isEmpty() )) //If the user entered her/his current place
        {
            company = intent.getExtras().getString("company");
        }

        if( !( intent.getExtras().getString("leaving time").isEmpty() )) //If the user entered her/his current place
        {
            leaving_time = intent.getExtras().getString("leaving time");
        }


        for(i=0 ; i<places_adapter.getCount() ; i++)
        {
            String s = places_adapter.getItem(i).toString();
            places_linkedlist.add(i, s);
        }

        times_linkedlist.add(0, 0);
        times_linkedlist.add(1, 10);
        times_linkedlist.add(2, 25);
        times_linkedlist.add(3, 32);
        times_linkedlist.add(4, 40);
        times_linkedlist.add(5, 46);
        times_linkedlist.add(6, 71);
        times_linkedlist.add(7, 128);
        times_linkedlist.add(8, 170);
        times_linkedlist.add(9, 192);
        times_linkedlist.add(10, 312);

        TextView table_leaving_time_1 = (TextView) findViewById(R.id.b_lt1);
        TextView table_arriving_time_1 = (TextView) findViewById(R.id.b_at1);
        Button table_bus_number_1 = (Button) findViewById(R.id.bn1);
        arriving_time = getArrivingTime(current_place, destination_place, leaving_time, times_linkedlist, places_linkedlist);
        table_leaving_time_1.setText(leaving_time);
        table_arriving_time_1.setText(arriving_time);
        table_bus_number_1.setText("101");

        TextView table_leaving_time_2 = (TextView) findViewById(R.id.b_lt2);
        TextView table_arriving_time_2 = (TextView) findViewById(R.id.b_at2);
        Button table_bus_number_2 = (Button) findViewById(R.id.bn2);
        add_to_lt += 53;
        NextLeavingTime = get_next_leaving_time(leaving_time, add_to_lt);
        arriving_time = getArrivingTime(current_place, destination_place, NextLeavingTime, times_linkedlist, places_linkedlist);
        table_leaving_time_2.setText(NextLeavingTime);
        table_arriving_time_2.setText(arriving_time);
        table_bus_number_2.setText("23");

        TextView table_leaving_time_3 = (TextView) findViewById(R.id.b_lt3);
        TextView table_arriving_time_3 = (TextView) findViewById(R.id.b_at3);
        Button table_bus_number_3 = (Button) findViewById(R.id.bn3);
        add_to_lt += 40;
        NextLeavingTime = get_next_leaving_time(leaving_time, add_to_lt);
        arriving_time = getArrivingTime(current_place, destination_place, NextLeavingTime, times_linkedlist, places_linkedlist);
        table_leaving_time_3.setText(NextLeavingTime);
        table_arriving_time_3.setText(arriving_time);
        table_bus_number_3.setText("21");

        TextView table_leaving_time_4 = (TextView) findViewById(R.id.b_lt4);
        TextView table_arriving_time_4 = (TextView) findViewById(R.id.b_at4);
        Button table_bus_number_4 = (Button) findViewById(R.id.bn4);
        add_to_lt += 27;
        NextLeavingTime = get_next_leaving_time(leaving_time, add_to_lt);
        arriving_time = getArrivingTime(current_place, destination_place, NextLeavingTime, times_linkedlist, places_linkedlist);
        table_leaving_time_4.setText(NextLeavingTime);
        table_arriving_time_4.setText(arriving_time);
        table_bus_number_4.setText("12");

        TextView table_leaving_time_5 = (TextView) findViewById(R.id.b_lt5);
        TextView table_arriving_time_5 = (TextView) findViewById(R.id.b_at5);
        Button table_bus_number_5 = (Button) findViewById(R.id.bn5);
        add_to_lt += 53;
        NextLeavingTime = get_next_leaving_time(leaving_time, add_to_lt);
        arriving_time = getArrivingTime(current_place, destination_place, NextLeavingTime, times_linkedlist, places_linkedlist);
        table_leaving_time_5.setText(NextLeavingTime);
        table_arriving_time_5.setText(arriving_time);
        table_bus_number_5.setText("105");

        TextView table_leaving_time_6 = (TextView) findViewById(R.id.b_lt6);
        TextView table_arriving_time_6 = (TextView) findViewById(R.id.b_at6);
        Button table_bus_number_6 = (Button) findViewById(R.id.bn6);
        add_to_lt += 40;
        NextLeavingTime = get_next_leaving_time(leaving_time, add_to_lt);
        arriving_time = getArrivingTime(current_place, destination_place, NextLeavingTime, times_linkedlist, places_linkedlist);
        table_leaving_time_6.setText(NextLeavingTime);
        table_arriving_time_6.setText(arriving_time);
        table_bus_number_6.setText("23");

        TextView table_leaving_time_7 = (TextView) findViewById(R.id.b_lt7);
        TextView table_arriving_time_7 = (TextView) findViewById(R.id.b_at7);
        Button table_bus_number_7 = (Button) findViewById(R.id.bn7);
        add_to_lt += 27;
        NextLeavingTime = get_next_leaving_time(leaving_time, add_to_lt);
        arriving_time = getArrivingTime(current_place, destination_place, NextLeavingTime, times_linkedlist, places_linkedlist);
        table_leaving_time_7.setText(NextLeavingTime);
        table_arriving_time_7.setText(arriving_time);
        table_bus_number_7.setText("13");

        TextView table_leaving_time_8 = (TextView) findViewById(R.id.b_lt8);
        TextView table_arriving_time_8 = (TextView) findViewById(R.id.b_at8);
        Button table_bus_number_8 = (Button) findViewById(R.id.bn8);
        add_to_lt += 53;
        NextLeavingTime = get_next_leaving_time(leaving_time, add_to_lt);
        arriving_time = getArrivingTime(current_place, destination_place, NextLeavingTime, times_linkedlist, places_linkedlist);
        table_leaving_time_8.setText(NextLeavingTime);
        table_arriving_time_8.setText(arriving_time);
        table_bus_number_8.setText("17");
    }


    public String get_next_leaving_time (String leaving_time, int add_to_lt)
    {
        String NextLeavingTime = "";
        String[] LeavingTime = leaving_time.split(":");
        String LeavingTime_hours = LeavingTime[0];
        String LeavingTime_minutes = LeavingTime[1];

        int lt_hours = Integer.parseInt(LeavingTime_hours);
        int lt_minutes = Integer.parseInt(LeavingTime_minutes);
        int times;

        if(lt_minutes + add_to_lt >= 60)
        {
            lt_hours += (lt_minutes + add_to_lt) / 60; // add division, in an int number, to the hour number
            times = (lt_minutes+add_to_lt) / 60;
            lt_minutes = (lt_minutes + add_to_lt) - 60*times;
        }

        else
        {
            lt_minutes += add_to_lt;
        }

        if(lt_hours >= 24)
        {
            lt_hours -= 24; //if the hour is after midnight, turn it to 0:00 and so on..
        }

        LeavingTime_hours = String.valueOf(lt_hours);

        if(lt_minutes < 10)
        {
            LeavingTime_minutes = "0" + String.valueOf(lt_minutes);
        }

        else
        {
            LeavingTime_minutes = String.valueOf(lt_minutes);
        }

        NextLeavingTime = LeavingTime_hours + ":" + LeavingTime_minutes;
        return NextLeavingTime;
    }

    public String getArrivingTime(String current_place, String destination_place, String leaving_time, LinkedList<Integer> times_list, LinkedList<String> places_list)
    {
        String arriving_time = "";
        int i;
        int cur_pos = 0;
        int dest_pos = 0;
        int time_difference = 0;

        //getting the position of the 2 places, to calculate the time differnce between them
        for(i=0; i<places_list.size(); i++)
        {
            if(current_place.equals(places_list.get(i)))
            {
                cur_pos = i;
            }

            if(destination_place.equals(places_list.get(i)))
            {
                dest_pos = i;
            }
        }

        if(cur_pos < dest_pos) //if the current place is found before the destination place in the places' linked list
        {
            time_difference = times_list.get(dest_pos) - times_list.get(cur_pos);
        }

        else if (dest_pos < cur_pos) //if the current place is found after the destination place in the places' linked list
        {
            time_difference = times_list.get(cur_pos) - times_list.get(dest_pos);
        }

        arriving_time = get_next_leaving_time(leaving_time, time_difference); // This function return the time after X minutes, like we need

        return arriving_time;
    }

}