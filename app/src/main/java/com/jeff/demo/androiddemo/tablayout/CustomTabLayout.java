package com.jeff.demo.androiddemo.tablayout;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jeff.demo.androiddemo.R;
import com.jeff.demo.androiddemo.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建时间：2018/08/28 22:19 <br>
 * 作者：JeffLee <br>
 * 描述：
 */
public class CustomTabLayout extends FrameLayout {
  @BindView(R.id.indicator_2)
  View mIndicator2;
  @BindView(R.id.indicator)
  View mIndicator;
  @BindView(R.id.tv_1)
  TextView mTv1;
  @BindView(R.id.tv_2)
  TextView mTv2;
  @BindView(R.id.tv_3)
  TextView mTv3;
  private Context mContext;
  private int mIndicatorWidth;
  private int mTextWidth;
  private List<Integer> mTextWidthList = new ArrayList<>();

  public CustomTabLayout(@NonNull Context context) {
    this(context, null);
  }

  public CustomTabLayout(@NonNull Context context,
      @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public CustomTabLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    this.mContext = context;
    View contentView = LayoutInflater.from(context).inflate(R.layout.item_custom_tab_layout, this);
    ButterKnife.bind(this, contentView);
  }

  @OnClick({ R.id.tv_1, R.id.tv_2, R.id.tv_3 })
  public void OnClick(View view) {
    switch (view.getId()) {
      case R.id.tv_1:
        setIndicateChange(0);
        break;
      case R.id.tv_2:
        setIndicateChange(1);
        break;
      case R.id.tv_3:
        setIndicateChange(2);
        break;
    }
  }

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    mIndicatorWidth = getWidth() / 3;
    mIndicator.getLayoutParams().width = mIndicatorWidth;
    LinearLayout.LayoutParams layoutParams =
        (LinearLayout.LayoutParams) mIndicator.getLayoutParams();
    layoutParams.leftMargin = Math.abs(mIndicatorWidth / 2 - mIndicator.getMeasuredWidth() / 2);
    mIndicator.setLayoutParams(layoutParams);
    LogUtils.e("onSizeChanged........调用");
    for (int i = 0; i < 3; i++) {
      if (i == 0) {
        mTextWidthList.add(getTextViewWidth(mTv1));
      } else if (i == 1) {
        mTextWidthList.add(getTextViewWidth(mTv2));
      } else {
        mTextWidthList.add(getTextViewWidth(mTv3));
      }
    }
  }

  private void setIndicateChange(int index) {
    ObjectAnimator.ofFloat(mIndicator, "TranslationX", mIndicatorWidth * index)
        .setDuration(200)
        .start();
  }

  private int getTextViewWidth(TextView tv) {
    String s = tv.getText().toString();
    Rect rect = new Rect();
    TextPaint paint = tv.getPaint();
    paint.getTextBounds(s, 0, s.length(), rect);
    return rect.width();
  }
}
