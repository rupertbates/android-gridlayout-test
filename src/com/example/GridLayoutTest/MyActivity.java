package com.example.GridLayoutTest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.GridLayout;
import android.widget.LinearLayout;

public class MyActivity extends Activity implements View.OnClickListener {
    private GridLayout grid;
    int cellHeight = 150;
    int cellWidth = 200;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        grid = new GridLayout(this);
        grid.setOnClickListener(this);
        grid.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));

        setContentView(grid);

        addChild(0, 0, 2, 2, Color.RED);
        addChild(2, 0, 2, 1, Color.GREEN);
        addChild(2, 1, 1, 1, Color.BLUE);
        addChild(3, 1, 1, 1, Color.MAGENTA);

    }

    private void addChild(int left, int top, int numCols, int numRows, int colour){
        GridLayout.Spec colSpec = GridLayout.spec(left, numCols);
        GridLayout.Spec rowSpec = GridLayout.spec(top, numRows);
        LinearLayout layout = new CustomLayout(this);
        layout.setBackgroundColor(colour);
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(rowSpec, colSpec);
        layoutParams.width = cellWidth * numCols;
        layoutParams.height = cellHeight * numRows;
        layoutParams.setGravity(Gravity.LEFT);

        grid.addView(layout, layoutParams);
    }


    @Override
    public void onClick(View v) {
        grid.removeViewAt(1);
        addChild(2, 0, 2, 1, Color.YELLOW);
    }
}
