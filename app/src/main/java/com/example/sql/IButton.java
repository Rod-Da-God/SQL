package com.example.sql;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public abstract class IButton implements IDrawable {
	private Vector2<Float> m_position, m_size;
	private Paint m_paint = new Paint(Color.BLACK);

	IButton(Vector2<Float> _position, Vector2<Float> _size) {
		this.m_position = _position;
		this.m_size = _size;
	}

	public void setPosition(Vector2<Float> m_position) {
		this.m_position = m_position;
	}

	public void setSize(Vector2<Float> m_size) {
		this.m_size = m_size;
	}

	public Vector2<Float> getPosition() {
		return m_position;
	}

	public Vector2<Float> getSize() {
		return m_size;
	}

	public Paint getPaint() {
		return m_paint;
	}

	public void setPaint(Paint m_paint) {
		this.m_paint = m_paint;
	}

	@Override
	public void draw(Canvas _canvas) {
		_canvas.drawRect(
				this.m_position.x,
				this.m_position.y,
				this.m_position.x + this.m_position.x,
				this.m_position.y + this.m_size.y,
				this.m_paint
		);
	}

	public boolean contains(Vector2<Float> _point) {
		return _point.x > this.m_position.x && _point.x < (this.m_position.x + this.m_size.x) && _point.y > this.m_position.y && _point.y < (this.m_position.y + this.m_size.y);
	}

}
