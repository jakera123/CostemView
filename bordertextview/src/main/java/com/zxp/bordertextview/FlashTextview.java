package com.zxp.bordertextview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by xiaoxin on 2017/7/15.
 */

public class FlashTextview extends AppCompatTextView {

    private int mViewWidth=0;
    private int mTranslate=0;
    private Paint mPaint=null;
    private LinearGradient mLinearGradient=null;
    private Matrix mGradientMatrix=null;

    public FlashTextview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        getMeasuredHeight();
        if(mViewWidth==0){
            mViewWidth=getMeasuredWidth();
            if(mViewWidth>0){
                mPaint=getPaint();
                mLinearGradient=new LinearGradient(0,0,mViewWidth,0,new int[] {Color.BLUE,0xffffffff,Color.GREEN,Color.BLACK},null, Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);
                mGradientMatrix=new Matrix();
            }
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mGradientMatrix!=null){
            mTranslate+=mViewWidth/5;
            if(mTranslate>2*mViewWidth){
                mTranslate=-mViewWidth;
            }
            mGradientMatrix.setTranslate(mTranslate,0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(100);
        }
    }
}
