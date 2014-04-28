package com.alkandros.minilnthebox.custom;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ExpandCollapseAnimation extends Animation {
    int originalHeight;
    View view;
    boolean expand;
    
    public ExpandCollapseAnimation(View view, int originalHeight, boolean expand) {
        this.view = view;
        this.originalHeight = originalHeight;
        this.expand = expand;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        int newHeight;
        if (expand) {
            newHeight = (int) (originalHeight * interpolatedTime);
        } else {
            newHeight = (int) (originalHeight * (1 - interpolatedTime));
        }
        view.getLayoutParams().height = newHeight;
        view.requestLayout();
    }

    @Override
    public void initialize(int width, int height, int parentWidth,
            int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    public boolean willChangeBounds() {
        return true;
    }
}