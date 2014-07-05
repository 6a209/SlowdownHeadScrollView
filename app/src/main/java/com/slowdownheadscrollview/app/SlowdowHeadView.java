package com.slowdownheadscrollview.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by 6a209 on 4/4/14.
 */
public class SlowdowHeadView extends FrameLayout{


    public SlowdowHeadView(Context context){
        this(context, null);
    }

    public SlowdowHeadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        inflate(getContext(), R.layout.slowheadview, this);
        SlowdownHeadScrollView shs = (SlowdownHeadScrollView)findViewById(R.id.scroll);
        final View headView = findViewById(R.id.headView);
        final FrameLayout.LayoutParams headHeight = (LayoutParams) headView.getLayoutParams();
        shs.setOnScrollChangedListener(new SlowdownHeadScrollView.OnScrollChangedListener() {
            @Override
            public void onScrollChanged(SlowdownHeadScrollView view, int l, int t, int oldl, int oldt) {
                float headHeight = headView.getHeight();
                final float percent = Math.min(headHeight, Math.max(0, t)) / headHeight;
                float y = - headHeight / 3.0f * percent;
                headView.setTranslationY(- headHeight / 3.0f  * percent);
            }
        });
    }
}
