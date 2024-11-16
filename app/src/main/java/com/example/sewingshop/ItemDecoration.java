package com.example.sewingshop;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class ItemDecoration extends RecyclerView.ItemDecoration {
    private final int spaceHeight;
    private final boolean shouldApplyBottomSpace;

    public ItemDecoration(int spaceHeight, boolean shouldApplyBottomSpace) {
        this.spaceHeight = spaceHeight;
        this.shouldApplyBottomSpace = shouldApplyBottomSpace;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (shouldApplyBottomSpace) {
            outRect.bottom = spaceHeight;
        } else {
            outRect.left = spaceHeight;
            outRect.right = spaceHeight;
        }
    }
}
