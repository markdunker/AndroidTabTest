package com.swust.issjj7.tabproj;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by issjj7 on 15-3-21.
 */
public class Tab1 extends LinearLayout {

    public Tab1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Tab1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Tab1(Context context) {
        super(context);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "123", Toast.LENGTH_LONG).show();

            }
        });
    }
}
