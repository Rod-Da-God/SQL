package com.example.sql;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

public class GameView extends View {

    public GameView(Context context) {
        super(context);
    }
    private GameThread gameThread;
    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        @SuppressLint("DrawAllocation") Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawRGB(204,102,255);
    }

}
