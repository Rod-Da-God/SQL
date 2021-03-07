package com.example.sql;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.Log;
import android.view.SurfaceHolder;

import androidx.annotation.RequiresApi;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class DrawThread extends Thread {
    private static Random random = new Random();
    private SurfaceHolder surfaceHolder;
    private volatile boolean running = true;
    private Paint backgroundPaint = new Paint();
    private Paint circlePaint = new Paint();
    private int towardPointX = -1;
    private int towardPointY = -1;
    private Bitmap bitmap1;
    private Bitmap bitmap2;

    {
        this.backgroundPaint.setColor(Color.BLUE);
        this.circlePaint.setColor(Color.YELLOW);
    }

    public DrawThread(Context context, SurfaceHolder surfaceHolder) {
        this.bitmap1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.android);
        this.bitmap2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.ios);
        this.surfaceHolder = surfaceHolder;

    }

    public void requestStop() {
        this.running = false;
    }

    /*public void setTowardPoint(int x, int y) {
        this.towardPointX = x;
        this.towardPointY = y;
    }*/

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void run() {
        while (this.running) {
            Canvas canvas = this.surfaceHolder.lockCanvas();
            int c1 = random.nextInt() % 10;
            int c2 = random.nextInt() % 10;
            for (int i = 0; i < c1; i++) {
                canvas.drawColor(Color.WHITE);
                this.spawnPng(bitmap1, canvas);
            }
            for (int i = 0; i < c2; i++) {
                canvas.drawColor(Color.WHITE);
                this.spawnPng(bitmap2, canvas);
            }

            try {
                this.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    private void spawnPng(Bitmap _bitmap, Canvas _canvas) {
        int x = random.nextInt() % 10 + 500, y = random.nextInt() % 10 + 1000;
        _canvas.drawBitmap(_bitmap, x, y, this.backgroundPaint);
    }
}
