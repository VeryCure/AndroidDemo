package com.jeff.demo.androiddemo.annotation;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import com.aidl.jefflee.annotation.JeffKnife;
import com.aidl.jefflee.annotation.JeffTest;
import com.jeff.demo.androiddemo.BaseActivity;
import com.jeff.demo.androiddemo.R;
import com.jeff.demo.androiddemo.annotation.type.TestHelper;
import com.jeff.demo.androiddemo.bean.Person;
import com.jeff.demo.androiddemo.utils.LogUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 创建时间：2018/07/26 14:51 <br>
 * 作者：JeffLee <br>
 * 描述：
 */
@JeffTest
public class AnnotationActivity extends BaseActivity {

  @JeffKnife(R.id.annotation_tv)
  TextView mTv;
  @JeffKnife(R.id.annotation_btn)
  Button mBtn;
  @BindView(R.id.annotation_tv)
  TextView mButterTv;

  @Override
  protected void initData() {
    getAllAnnotationView();
    mTv.setText("我已经被改了");
    mBtn.setText("我也被改了");
    mBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //TestHelper.testParameterizedType();
        //TestHelper.testTypeVariable();
        //TestHelper.printConstructor(Person.class.getName());
        Constructor constructor =
            TestHelper.getConstructor(Person.class.getName(), String.class, String.class);
        try {
          Object person = constructor.newInstance("北京", "中国");
          LogUtils.e(person.toString());
        } catch (InstantiationException e) {
          e.printStackTrace();
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        } catch (InvocationTargetException e) {
          e.printStackTrace();
        }
        LogUtils.e(constructor+"\n");
      }
    });
  }

  @Override
  protected int getLayoutId() {
    return R.layout.activity_annotation_layout;
  }

  private void getAllAnnotationView(){
    //获取成员变量
    Field[] fields = this.getClass().getDeclaredFields();
    for (Field field : fields){
      try{
        //判断注解
        if (field.getAnnotations() != null){
          //确定注解类型
          if (field.isAnnotationPresent(JeffKnife.class)){
            //允许修改反射属性
            field.setAccessible(true);
            JeffKnife knife = field.getAnnotation(JeffKnife.class);
            field.set(this,findViewById(knife.value()));
          }
        }
      }catch(Exception e){
        e.printStackTrace();
      }
    }
  }
}
