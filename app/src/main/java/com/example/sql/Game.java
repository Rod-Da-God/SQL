package com.example.sql;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class Game extends SurfaceView implements SurfaceHolder.Callback {

    private Game gameThread;

    int x = 0;
    int y = 0;

    public Game(Context context) {
        super(context);
        Log.d("Game", "Game activity created");
        getHolder().addCallback(this);
    }

    private SurfaceHolder surfaceHolder;
    private int clickPointX;
    private int clickPointY;
    private Bitmap bitmap;
    private SurfaceHolder holder;
    Paint backgroundPaint = new Paint();


    private boolean running = true;
    private Object Context;


    public void SurfaceView(Context context) {
      bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.android);
    }




    public void run() {
        int pictureX = 0;
        int pictureY = 0;
        while (running) {
            Canvas canvas = surfaceHolder.lockCanvas(null);
            if (canvas != null) {
                try {
                    canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), backgroundPaint);
                    canvas.drawBitmap(bitmap, pictureX, pictureY, backgroundPaint);
                    if (pictureX + bitmap.getWidth() / 2 > clickPointX) {
                        pictureX += 10;
                    }
                    if (pictureX + bitmap.getWidth() / 2 < clickPointX) {
                        pictureX -= 10;
                    }
                    if (pictureY + bitmap.getHeight() / 2 > clickPointY) {
                        pictureX += 10;
                    }
                    if (pictureY + bitmap.getHeight() / 2 < clickPointY) {
                        pictureX -= 10;
                    }


                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }


    private float Width = 0f, Height = 0f;

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        Log.d("Game", "Game created");


    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
        Log.d("Game", "Game changed");
        Width = width;
        Height = height;
        if (gameThread == null) {
            gameThread.start();

        } else {
            gameThread.updateSize(Width, Height);
        }

    }

    private void updateSize(float width, float height) {
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        Log.d("Game", "Game was destroyed");
        gameThread = null;
        assert gameThread != null;
        gameThread.Stop();


    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gameThread.setTowardPoint((int) event.getX(), (int) event.getY());
        Log.d("dd", "fff" + x + y);
        return true;
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
}
