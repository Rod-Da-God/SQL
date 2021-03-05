package com.example.sql;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.NonNull;

public class Game extends SurfaceView implements SurfaceHolder.Callback {

    private Game game;
    private GameThread gameThread;

    int x = 0;
    int y =0;

    public Game(Game game, Context context) {
        super(context);
        Log.d("Game", "Game activity created");
        getHolder().addCallback(this);
        this.game = game;
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
            gameThread = new GameThread(getContext(), game, holder, format, width, height);
            gameThread.start();

        } else {
            gameThread.updateSize(Width, Height);
        }

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        Log.d("Game", "Game was destroyed");
        gameThread = null;
        assert gameThread != null;
        gameThread.Stop();


    }



    @Override
    public void setX(float x) {
        super.setX(x);
    }

    @Override
    public void setY(float y) {
        super.setY(y);
    }

    @Override
    public float getX() {
        return super.getX();
    }

    @Override
    public float getY() {
        return super.getY();
    }


}
