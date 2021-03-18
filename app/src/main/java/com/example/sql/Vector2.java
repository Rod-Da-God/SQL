package com.example.sql;

import java.util.Vector;

public class Vector2<Type> {
	public Type x, y;

    /*Vector2(Type _x, Type _y) {
        this.x = _x;
        this.y = _y;
    }*/

	<Another> Vector2(Another _x, Another _y) {
		this.x = (Type) _x;
		this.y = (Type) _y;
	}
}
