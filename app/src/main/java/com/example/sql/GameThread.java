package com.example.sql;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;


public class GameThread extends Thread {
    private int clickPointX;
    private int clickPointY;
    private SurfaceHolder holder;

    private boolean running = true;
    private Object Context;

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
            canvas.drawRGB(204, 102, 255);
        }

    }

    public GameThread(Context context, Game game, SurfaceHolder holder, int format, int width, int height) {
        this.holder = holder;

    }

    public void Random() {
        int some = (int) (Math.random() * 100);
        int[] images = {R.drawable.android};
        Random rand = new Random();
        ImageView imageView = new ImageView((android.content.Context) Context);
        imageView.setImageResource(images[rand.nextInt(images.length)]);
    }

    public void setTowardPoint(int x, int y) {
        clickPointX = x;
        clickPointY = y;
    }


    public void Stop() {
        running = false;

    }

    public void start() {
        running = true;


    }

    public void updateSize(float width, float height) {

    }
}
