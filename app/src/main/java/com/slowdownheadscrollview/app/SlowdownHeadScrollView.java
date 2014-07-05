package com.slowdownheadscrollview.app;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by 6a209 on 4/4/14.
 */
public class SlowdownHeadScrollView extends ScrollView{

    public interface OnScrollChangedListener{
        public void onScrollChanged(SlowdownHeadScrollView view, int l, int t, int oldl, int oldt);
    }

    private OnScrollChangedListener mListener;

    public SlowdownHeadScrollView(Context context){
       this(context, null);
    }

    public SlowdownHeadScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnScrollChangedListener(OnScrollChangedListener listener){
       mListener = listener;
    }


    @Override
    protected  void onScrollChanged(int l, int t, int oldl, int oldt){
        super.onScrollChanged(l, t, oldl, oldt);
        if(null != mListener){
            mListener.onScrollChanged(this, l, t, oldl, oldt);
        }
    }
}
