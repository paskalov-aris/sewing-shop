package com.example.sewingshop;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class ItemDecoration extends RecyclerView.ItemDecoration {
    private final int spaceHeight;

    public ItemDecoration(int spaceHeight) {
        this.spaceHeight = spaceHeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = spaceHeight;
        outRect.right = spaceHeight;
    }
}
