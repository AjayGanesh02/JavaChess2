package com.chess.engine.board;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.chess.engine.pieces.Piece;

//Abstract class, splits into two subclasses: emptyTile and occupiedTile
//Abstract class cannot be instantiated
public abstract class Tile {
	
	//8x8 grid of tiles makes up the board
	protected final int tileCoord;
	
	//Every possible empty tile that could possibly exist is created all at once through this, can use EMPTY_TILES_CACHE.get(1-64)
	private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();
	
	//Constructor, tileCoord allows me to specify which of the 64 tiles it is
	private Tile(int tileCoord) {
		this.tileCoord = tileCoord;
	}
	
	private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
		final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
		
		for(int i = 0; i < 64;i++) {
			emptyTileMap.put(i, new EmptyTile(i));
		}
		
		return Collections.unmodifiableMap(emptyTileMap);
	}
	
	//Only way to create a tile, empty tiles are cached and occupied tiles are newly created
	public static Tile createTile(final int tileCoord, final Piece piece) {
		//? (conditional operator) acts like if statement
		//if piece is null, returns the cached empty tile
		//if piece is not null, returns the new OccupiedTile
		return piece != null ? new OccupiedTile(tileCoord, piece) : EMPTY_TILES_CACHE.get(tileCoord);
	}

	//Returns if tile is occupied by a Piece or not
	public abstract boolean isTileOccupied();
	
	//If tile is occupied, returns piece that is on it
	public abstract Piece getPiece();
	
	//Subclasses in same file as abstract
	public static final class EmptyTile extends Tile {
		
		private EmptyTile(final int coord) {
			super(coord);
		}
		
		//Overrides abstract class's method
		//by definition EmptyTile is not occupied
		@Override
		public boolean isTileOccupied() {
			return false;
		}
		
		//No piece to return on an empty tile
		@Override
		public Piece getPiece() {
			return null;
		}
	}
	
	public static final class OccupiedTile extends Tile {
		
		private final Piece pieceOnTile;
		
		//OccupiedTile constructor 
		private OccupiedTile(final int coord, Piece pieceOnTile) {
			super(coord);
			this.pieceOnTile = pieceOnTile;
		}
		
		@Override
		public boolean isTileOccupied() {
			return true;
		}
		
		@Override
		public Piece getPiece() {
			return this.pieceOnTile;
		}
	}
}
