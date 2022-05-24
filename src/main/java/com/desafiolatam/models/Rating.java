package com.desafiolatam.models;

public enum Rating {

	MUY_MALA (-2),
	MALA (-1),
	OTRA_PELICULA (0),
	BUENA (1),
	MUY_BUENA (2);
	
	private final int rating;
	
	Rating(int rating){
		this.rating = rating;
	}
	
	public int getRating() {
		return rating;
	}
	
}
