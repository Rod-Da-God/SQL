package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.game = new Game(this.getApplicationContext());
        setContentView(game);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        Log.d("TouchListener", "Touch was occurred: " + x + " " + y);

        Toast.makeText(this.getApplicationContext(), "zazaazazaz", Toast.LENGTH_SHORT).show();


        return true;
    }




    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
