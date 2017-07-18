package com.zxp.bordertextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by xiaoxin on 2017/7/17.
 */

public class CostomTitleBar  extends RelativeLayout{

    private Button mLeftButton=null;
    private Button mRightButton=null;
    private TextView mTitleView=null;
    private int mLeftTextColor,mRighTextColor,mTitleTextColor;
    private Drawable mLeftBackground,mRightBackground;
    private String mLeftText,mRightText,mTitle;
    private float mTitleTextSize;
    private RelativeLayout.LayoutParams mLeftParams=null,mRightParams=null,mTitleParams=null;
    private topbarClickListener mListener;

    public CostomTitleBar(Context context) {
        super(context);
    }

    public CostomTitleBar(final Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta=context.obtainStyledAttributes(attrs,R.styleable.TopBar);
        mLeftTextColor=ta.getColor(R.styleable.TopBar_leftTextColor,0);
        mLeftBackground=ta.getDrawable(R.styleable.TopBar_leftBackground);
        mLeftText=ta.getString(R.styleable.TopBar_leftText);

        mRighTextColor=ta.getColor(R.styleable.TopBar_rightTextColor,0);
        mRightBackground=ta.getDrawable(R.styleable.TopBar_rightBackground);
        mRightText=ta.getString(R.styleable.TopBar_rightText);

        mTitleTextSize=ta.getDimension(R.styleable.TopBar_titleTextSize,10);
        mTitleTextColor=ta.getColor(R.styleable.TopBar_titleTextColor,0);
        mTitle=ta.getString(R.styleable.TopBar_title);
        //用完回收
        ta.recycle();
        mLeftButton=new Button(context);
        mRightButton=new Button(context);
        mTitleView=new TextView(context);

        mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setBackground(mLeftBackground);
        mLeftButton.setText(mLeftText);
        Log.i("CostomTitleBar",mLeftText);
        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener==null){
                    Toast.makeText(context,"请先设置监听器！",Toast.LENGTH_SHORT).show();
                }else {
                    mListener.leftClick();
                }
            }
        });

        mRightButton.setTextColor(mRighTextColor);
        mRightButton.setBackground(mRightBackground);
        mRightButton.setText(mRightText);
        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener==null){
                    Toast.makeText(context,"请先设置监听器！",Toast.LENGTH_SHORT).show();
                }else {
                    mListener.rightClick();
                }
            }
        });

        mTitleView.setText(mTitle);
        Log.i("CostomTitleBar",mTitle);
        mTitleView.setTextColor(mTitleTextColor);
        mTitleView.setTextSize(mTitleTextSize);
        mTitleView.setGravity(Gravity.CENTER);

        mLeftParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        addView(mLeftButton,mLeftParams);

        mRightParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        addView(mRightButton,mRightParams);

        mTitleParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        addView(mTitleView,mTitleParams);

        Log.i("CostomTitleBar","##########test#########");

    }


    /**
     *
     * @param listener  传入Listener
     */
    public void setonTopBarListener(topbarClickListener listener){

        this.mListener=listener;
        Log.i("SetONTopBarListener","#######test####");
        if (mListener==null){
            Log.i("SetONTopBarListener","#######test+=null####");
        }else{
            Log.i("SetONTopBarListener","#######test  sucess####");
        }
    }

    public void setButtonVisable(int id, boolean flag){
        if(flag){
            if(id==0){
                mLeftButton.setVisibility(View.VISIBLE);
            }else{
                mRightButton.setVisibility(View.VISIBLE);
            }
        }else{
            if(id==0){
                mLeftButton.setVisibility(View.GONE);
            }else{
                mRightButton.setVisibility(View.GONE);
            }

        }
    }


}
