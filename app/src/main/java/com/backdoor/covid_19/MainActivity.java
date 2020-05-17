package com.backdoor.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList arrayList;

    LinearLayout myCountryLinearLayout, globalLinearLayout;
    TextView myCountryTxt, globalTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getGraphEntries();

        myCountryLinearLayout = findViewById(R.id.myCountryLinearLayout);
        globalLinearLayout = findViewById(R.id.globalLinearLayout);
        myCountryTxt = findViewById(R.id.myCountryTxt);
        globalTxt = findViewById(R.id.globalTxt);

        myCountryLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountryLinearLayout.setBackgroundResource(R.drawable.selected_bar_top_white);
                globalLinearLayout.setBackgroundResource(R.drawable.selected_bar_top);
                myCountryTxt.setTextColor(getResources().getColor(R.color.background));
                globalTxt.setTextColor(getResources().getColor(R.color.white));

            }
        });

        globalLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountryLinearLayout.setBackgroundResource(R.drawable.selected_bar_top);
                globalLinearLayout.setBackgroundResource(R.drawable.selected_bar_top_white);
                myCountryTxt.setTextColor(getResources().getColor(R.color.white));
                globalTxt.setTextColor(getResources().getColor(R.color.background));
            }
        });


    }

    private void getGraphEntries(){
        barChart = findViewById(R.id.barChart);
        arrayList = new ArrayList();
        arrayList.add(new BarEntry(1f, 5000));
        arrayList.add(new BarEntry(2f, 1));
        arrayList.add(new BarEntry(3f, 4));
        arrayList.add(new BarEntry(4f, 5));

        barDataSet = new BarDataSet(arrayList, "Daily New Cases");
        barData = new BarData(barDataSet);
        barChart.setData(barData);
        barDataSet.setColor(Color.RED);
        barDataSet.setValueTextColor(Color.BLACK);
    }

}
