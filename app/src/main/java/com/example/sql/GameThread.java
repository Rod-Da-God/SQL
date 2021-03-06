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

import java.util.concurrent.ThreadLocalRandom;

class DrawThread extends Thread {

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
        running = false;
    }

    /*public void setTowardPoint(int x, int y) {
        this.towardPointX = x;
        this.towardPointY = y;
    }*/

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void run() {
        int randomNum = ThreadLocalRandom.current().nextInt(551, 555 + 1);
        float b1y = (float) ((Math.random() * ((1500 - 150) + 1)) + 150);
        float b2x = (float) ((Math.random() * ((551 - 75.5) + 1)) + 75.5);
        float b2y = (float) ((Math.random() * ((1500 - 150) + 1)) + 150);
        while (this.running) {
            Canvas canvas = this.surfaceHolder.lockCanvas();
            if (canvas != null) {
                try {
                    canvas.drawColor(Color.WHITE);
                    canvas.drawBitmap(this.bitmap1, randomNum , b1y - 1, this.backgroundPaint);
                    Log.d("bitmap", "Bitmap1 : " + randomNum + b1y);
                } finally {
                    this.surfaceHolder.unlockCanvasAndPost(canvas);
                }
                try {
                    this.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (canvas != null) {
                canvas = this.surfaceHolder.lockCanvas();
                try {
                    canvas.drawColor(Color.WHITE);
                    canvas.drawBitmap(this.bitmap2, b2x * 2, b2y - 1, this.backgroundPaint);
                    Log.d("b", "Bitmap2 :  " + b2x + b2y);
                } finally {
                    this.surfaceHolder.unlockCanvasAndPost(canvas);
                }
                try {
                    this.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }
    }
}
