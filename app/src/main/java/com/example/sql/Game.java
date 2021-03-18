package com.example.sql;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.time.Clock;

public class Game extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    public static Player p1;
    private SurfaceHolder m_surfaceHolder;
    private volatile boolean m_running = true;
    private StateMachine m_machine;
    private GameState gameState;
    private Clock m_clock;
    //private DrawThread drawThread;

    public StateMachine getMachine() {
        return m_machine;
    }

    public void requestStop() {
        this.m_running = false;
    }

    /*public void setTowardPoint(int x, int y) {
        this.towardPointX = x;
        this.towardPointY = y;
    }*/

    public Game(Context context) {
        super(context);
        Log.d("State", "gameState constructor started");
        getHolder().addCallback(this);
        Game.p1 = new Player();

        this.gameState = new GameState(context);

        Log.d("State", "gameState init finished! "+gameState.toString());

        this.m_machine.insert( 0, gameState);
        //this.m_machine.exec(StateCommand.Start, 0);
       // this.m_machine.exec(StateCommand.Continue, 0);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        this.requestStop();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void run() {
        while (this.m_running) {
			/*
			Canvas canvas = this.surfaceHolder.lockCanvas();
			*/

            Canvas canvas = this.m_surfaceHolder.lockCanvas();
            this.m_machine.update(this.m_clock, canvas);
            this.m_surfaceHolder.unlockCanvasAndPost(canvas);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}




