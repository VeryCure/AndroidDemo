package com.jeff.demo.androiddemo.behavior;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.jeff.demo.androiddemo.custom.DependencyView;
import com.jeff.demo.androiddemo.utils.LogUtils;

/**
 * Created by ttxs on 2018/1/10.
 */

public class DependencyBehavior extends CoordinatorLayout.Behavior<View>
{
    public DependencyBehavior()
    {

    }

    public DependencyBehavior(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View
            dependency)
    {
        return false;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View
            child, View dependency)
    {
        int dependBottom = dependency.getBottom();
        child.setY(dependBottom + 20);
        child.setX(dependency.getLeft());
        return true;
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout
                                               coordinatorLayout, @NonNull
            View child, @NonNull View directTargetChild, @NonNull View
            target, int axes, int type)
    {
        LogUtils.d("onStartNestedScroll");
        return child instanceof ImageView && axes == View.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type)
    {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy,
                consumed, type);
        ViewCompat.offsetTopAndBottom(child,dy);
        LogUtils.d("onNestedPreScroll");
    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout,
                               @NonNull View child, @NonNull View target, int
                                       dxConsumed, int dyConsumed, int
                                       dxUnconsumed, int dyUnconsumed,
                               int type)
    {
        LogUtils.d("onNestedScroll");
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed,
                dyConsumed, dxUnconsumed, dyUnconsumed, type);
    }

    @Override
    public void onNestedScrollAccepted(@NonNull CoordinatorLayout
                                               coordinatorLayout, @NonNull
            View child, @NonNull View directTargetChild, @NonNull View
            target, int axes, int type)
    {
        LogUtils.d("onNestedScrollAccepted");
        super.onNestedScrollAccepted(coordinatorLayout, child,
                directTargetChild, target, axes, type);
    }

    @Override
    public void onStopNestedScroll(@NonNull CoordinatorLayout
                                           coordinatorLayout, @NonNull View
            child, @NonNull View target, int type)
    {
        super.onStopNestedScroll(coordinatorLayout, child, target, type);
        LogUtils.d("onStopNestedScroll");
    }

    @Override
    public boolean onNestedFling(@NonNull CoordinatorLayout
                                             coordinatorLayout, @NonNull View
            child, @NonNull View target, float velocityX, float velocityY,
                                 boolean consumed)
    {
        LogUtils.d("onNestedFling");
        return true;
    }

    @Override
    public boolean onNestedPreFling(@NonNull CoordinatorLayout
                                            coordinatorLayout, @NonNull View
            child, @NonNull View target, float velocityX, float velocityY)
    {
        LogUtils.d("onNestedPreFling");
        if (velocityY > 0){
            child.animate().scaleX(2.0f).scaleY(2.0f).setDuration(1000).start();
        }else {
            child.animate().scaleX(1.0f).scaleY(1.0f).setDuration(1000).start();
        }
        return true;
    }

}
