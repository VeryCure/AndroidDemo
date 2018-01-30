package com.jeff.demo.androiddemo.chart;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.jeff.demo.androiddemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ttxs on 2018/1/29.
 */

public class DataChartActivity extends AppCompatActivity
{
    @BindView(R.id.linechart)
    LineChart mLineChart;
    @BindView(R.id.linechart2)
    LineChart mLineChart2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_layout);
        ButterKnife.bind(this);
        initView();
        setLineChart2Data();
    }

    private void setLineChart2Data()
    {
        //设置
        mLineChart2.getDescription().setEnabled(false);
        mLineChart2.setTouchEnabled(true);
        mLineChart2.setScaleEnabled(true);
        mLineChart2.setPinchZoom(false);
        mLineChart2.setDoubleTapToZoomEnabled(false);
        mLineChart2.zoom(3,1,8,0, YAxis.AxisDependency.RIGHT);
//        mLineChart2.zoomToCenter(3,1);
        XAxis xAxis = mLineChart2.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisLineColor(Color.parseColor("#00ffffff"));
        xAxis.setGridDashedLine(new DashPathEffect(new float[]{10f,10f},0f));
        xAxis.setGranularity(1f);
        xAxis.enableAxisLineDashedLine(10f,10f,0f);
        YAxis axisLeft = mLineChart2.getAxisLeft();
        axisLeft.setEnabled(false);
        YAxis axisRight = mLineChart2.getAxisRight();
        axisRight.setEnabled(false);
        Legend legend = mLineChart2.getLegend();
        legend.setEnabled(false);
        //数据
        List<Entry> values = new ArrayList<>();
        for (int i=0;i<10;i++){
            float val = (float) (Math.random() * 20) + 3;
            values.add(new Entry(i, val, getResources().getDrawable(R
                    .drawable.ic_line_chart_select_dot)));
        }
        LineDataSet linechart2 = new LineDataSet(values, "");
        linechart2.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        linechart2.setCircleColor(Color.parseColor("#ff7c00"));
        linechart2.setDrawIcons(true);
        // set the line to be drawn like this "- - - - - -"
//        linechart2.enableDashedLine(10f, 5f, 0f);
//        linechart2.enableDashedHighlightLine(10f, 5f, 0f);
        linechart2.setColor(Color.BLACK);
        linechart2.setCircleColor(Color.BLACK);
        linechart2.setLineWidth(1f);
        linechart2.setCircleRadius(3f);
        linechart2.setDrawCircleHole(false);
        linechart2.setValueTextSize(9f);
        linechart2.setDrawFilled(false);
        linechart2.setFormLineWidth(1f);
        linechart2.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
        linechart2.setFormSize(15.f);

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(linechart2); // add the datasets

        // create a data object with the datasets
        LineData data = new LineData(dataSets);

        // set data
        mLineChart2.setData(data);
    }

    private void initView()
    {
        LineChartManager lineChartManager = new LineChartManager(mLineChart);
        //设置x轴的数据
        ArrayList<Float> xValues = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            xValues.add((float) i);
        }

        //设置y轴的数据()
        List<List<Float>> yValues = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<Float> yValue = new ArrayList<>();
            for (int j = 0; j <= 10; j++) {
                yValue.add((float) (Math.random() * 80));
            }
            yValues.add(yValue);
        }
        lineChartManager.showLineChart(this,xValues,yValues.get(0),"chart测试",
                getResources().getColor(R.color.color_00b98c));
    }

}
