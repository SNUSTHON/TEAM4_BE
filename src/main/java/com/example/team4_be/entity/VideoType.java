package com.example.team4_be.entity;

import lombok.Getter;

@Getter
public enum VideoType {
	BIRTHDAY("BIRTHDAY"),
	SINGING("SINGING"),
	WEDDING("WEDDING"),
	LAUGHING("LAUGHING"),
	WALKING("WALKING"),
	EATING("EATING");
	private final String name;

	VideoType(String name) {
		this.name = name;
	}
}
