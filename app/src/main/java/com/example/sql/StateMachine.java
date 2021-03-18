package com.example.sql;

import android.graphics.Canvas;
import android.os.Bundle;

import java.time.Clock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class StateMachine {
	private HashMap<Long, GameState> m_content=new HashMap<>();
	private HashMap<Long, Bundle> m_saved=new HashMap<>();

	void insert( long _id, GameState _state) {
		this.m_content.put(_id, _state);
	}

	void remove(long _id) {
		this.m_content.remove(_id);
	}

	void exec(StateCommand _cum, long _id) {
		switch (_cum) {
			case Start:
				this.m_content.get(_id).onCreate();
				break;
			case Finish:
				this.m_content.get(_id).onDestroy();
				break;
			case Pause:
				this.m_saved.put(_id, this.m_content.get(_id).onDeactivate());
				break;
			case Continue:
				this.m_content.get(_id).onActivate(this.m_saved.get(_id));
				this.m_saved.remove(_id);
				break;
			default:
				break;
		}
	}

	public void update(Clock _dt, Canvas _canvas) {
		for (IState it : this.m_content.values())
			if (it.m_isActive) {
				it.update(_dt);
			}
	}
}
