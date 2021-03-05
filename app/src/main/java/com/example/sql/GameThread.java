package com.example.sql;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;


public class GameThread extends Thread {
    private int clickPointX;
    private int clickPointY;
    private SurfaceHolder holder;
    private GameThread gameThread;

    private  boolean running = true;
    @Override
    public void run() {
        while (running) {
            Surface surfaceHolder = null;
            Canvas canvas = surfaceHolder.lockCanvas(null);
            if (canvas != null) {
                try {

                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }


    public static class GameView extends View {
    public GameView(Game game, Context context) {
        super(context);
    }
    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        @SuppressLint("DrawAllocation") Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawRGB(204,102,255);
    }

}

    public GameThread(Context context, Game game, SurfaceHolder holder, int format, int width, int height) {
this.holder = holder;
    }

    public void setTowardPoint(int x, int y) {
        clickPointX = x;
        clickPointY = y;
    }


    public void Stop() {
        running = false;

    }

    public void start() {


    }

    public void updateSize(float width, float height) {
    }
}
