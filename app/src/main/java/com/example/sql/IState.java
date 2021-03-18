package com.example.sql;

import android.graphics.Canvas;
import android.os.Bundle;

import java.time.Clock;

public abstract class IState implements IUpdatable, IDrawable {
	public boolean m_isActive = false;

	public abstract void onCreate();
	public abstract void onDestroy();

	public abstract void onActivate(Bundle _bundle);
	public abstract Bundle onDeactivate();

	@Override
	public abstract void update(Clock _dt);
	@Override
	public abstract void draw(Canvas _canvas);
}
