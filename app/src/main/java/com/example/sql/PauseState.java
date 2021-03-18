package com.example.sql;

import android.graphics.Canvas;
import android.os.Bundle;

import java.time.Clock;

public class PauseState extends IState {
	@Override
	public void onCreate() {
	}

	@Override
	public void onDestroy() {
	}

	@Override
	public void onActivate(Bundle _bundle) {
		this.m_isActive = true;
	}

	@Override
	public Bundle onDeactivate() {
		this.m_isActive = false;
		return new Bundle();
	}

	@Override
	public void update(Clock _dt) {

	}

	@Override
	public void draw(Canvas _canvas) {

	}
}
