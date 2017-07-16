package com.zxp.bordertextview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by xiaoxin on 2017/7/15.
 */

public class MyTextView extends AppCompatTextView {
    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint mpaint1=new Paint();
        mpaint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
        mpaint1.setStyle(Paint.Style.FILL);
        Paint mpaint2=new Paint();
        mpaint2.setColor(Color.YELLOW);
        mpaint2.setStyle(Paint.Style.FILL);

        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mpaint1);

        canvas.drawRect(10,10,getMeasuredWidth()-10,getMeasuredHeight()-10,mpaint2);

        canvas.save();

        //移动的位置
        canvas.translate(100,0);

        super.onDraw(canvas);

        canvas.restore();

    }
}
