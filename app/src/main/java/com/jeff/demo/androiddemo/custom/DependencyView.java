package com.jeff.demo.androiddemo.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/**
 * Created by ttxs on 2018/1/10.
 */

public class DependencyView extends AppCompatTextView
{

    private int mTouchSlop;
    private float mLastX;
    private float mLastY;

    public DependencyView(Context context)
    {
        this(context, null);
    }

    public DependencyView(Context context, @Nullable AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public DependencyView(Context context, @Nullable AttributeSet attrs, int
            defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        setClickable(true);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int action = event.getAction();
        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                mLastX = event.getX();
                mLastY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = (int) (event.getX() - mLastX);
                int deltaY = (int) (event.getY() - mLastY);
                if (Math.abs(deltaX) > mTouchSlop || Math.abs(deltaY) >
                        mTouchSlop)
                {
                    ViewCompat.offsetLeftAndRight(this, deltaX);
                    ViewCompat.offsetTopAndBottom(this, deltaY);
                    mLastX = event.getX();
                    mLastY = event.getY();
                }
                break;
            case MotionEvent.ACTION_UP:
                mLastX = event.getX();
                mLastY = event.getY();
                break;
            default:
                break;
        }
        return true;
    }
}
