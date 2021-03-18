package com.example.sql;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;

import java.time.Clock;
import java.util.Random;

public class GameState extends IState {
	private static Random random = new Random();
	private Paint backgroundPaint = new Paint(Color.BLACK);
	private Paint circlePaint = new Paint(Color.WHITE);
	private int towardPointX = -1;
	private int towardPointY = -1;
	private Bitmap bitmap1;
	private Bitmap bitmap2;

	/*@Override
    public int hashCode(){
		return (towardPointX+towardPointY )
	}*/
	public GameState(Context context) {
		Log.d("State", "GameState constructor started!");

		this.bitmap1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.android);
		this.bitmap2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.ios);

		Log.d("State", "GameState constructor finished!");
	}
    @Override
    public String toString(){
		return "object GameState initiated / "+towardPointY ;
    }
	@Override
	public void onCreate() {

	}

	@Override
	public void onDestroy() {

	}

	@Override
	public void onActivate(Bundle _bundle) {

	}

	@Override
	public Bundle onDeactivate() {
		return new Bundle();
	}

	@Override
	public void update(Clock _dt) {
	}

	@Override
	public void draw(Canvas _canvas) {
		int c1 = random.nextInt() % 10;
		int c2 = random.nextInt() % 10;
		int answer1 = 0;
		int answer2 = 0;
		int targetAnswer1 = c1;
		int targetAnswer2 = c2;
		boolean answerRight1 = false;
		boolean answerRight2 = false;

		for (int i = 0; i < c1; i++) {
			_canvas.drawColor(Color.WHITE);
			this.spawnPng(bitmap1, _canvas);

		}
		for (int i = 0; i < c2; i++) {
			_canvas.drawColor(Color.WHITE);
			this.spawnPng(bitmap2, _canvas);
		}
	}

	private void spawnPng(Bitmap _bitmap, Canvas _canvas) {
		int x = random.nextInt() % 1280 - 10, y = random.nextInt() % 280 + 10;
		_canvas.drawBitmap(_bitmap, x, y, this.backgroundPaint);
	}
}
