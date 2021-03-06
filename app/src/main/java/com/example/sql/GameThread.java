package com.example.sql;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

class DrawThread extends Thread {

    private SurfaceHolder surfaceHolder;
    private volatile boolean running = true;
    private Paint backgroundPaint = new Paint();
    private Paint circlePaint = new Paint();
    private int towardPointX = -1;
    private int towardPointY = -1;
    private int radius = 0;
    private Bitmap bitmap1;
    private Bitmap bitmap2;

    {
        backgroundPaint.setColor(Color.BLUE);
        circlePaint.setColor(Color.YELLOW);
    }

    public DrawThread(Context context, SurfaceHolder surfaceHolder) {
        bitmap1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.android);
        bitmap2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.ios);
        this.surfaceHolder = surfaceHolder;

    }

    public void requestStop() {
        running = false;
    }

    public void setTowardPoint(int x, int y) {
        towardPointX = x;
        towardPointY = y;
        radius = 0;
    }

    @Override
    public void run() {
        while (running) {
            Canvas canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {

                try {
                    canvas.drawColor(Color.BLUE);
                    if (towardPointX > -1 && towardPointY > -1) {
                        canvas.drawCircle(towardPointX, towardPointY, radius, circlePaint);
                        radius += 5;
                    }

                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }

                try{
                    sleep(100);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
