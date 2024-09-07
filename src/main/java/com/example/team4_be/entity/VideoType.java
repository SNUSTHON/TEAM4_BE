package com.example.team4_be.entity;

import lombok.Getter;

@Getter
public enum VideoType {
	BIRTHDAY("생일파티"),
	SINGING("노래"),
	WEDDING("결혼식"),
	LAUGHING("웃음"),
	WALKING("산책"),
	EATING("음식");
	private final String name;

	VideoType(String name) {
		this.name = name;
	}
}
