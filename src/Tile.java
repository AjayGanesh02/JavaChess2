//Abstract class, splits into two subclasses: emptyTile and occupiedTile
public abstract class Tile {
	
	//8x8 grid of tiles makes up the board
	int tileCoord;
	
	//Constructor, tileCoord allows me to specify which of the 64 tiles it is
	Tile(int tileCoord) {
		this.tileCoord = tileCoord;
	}
	
	//Returns if tile is occupied by a Piece or not
	public abstract boolean isTileOccupied();
	
	//If tile is occupied, returns piece that is on it
	public abstract Piece getPiece();
	
	//Subclass 
	public static final class EmptyTile extends Tile {
		
		EmptyTile(int coord) {
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
	
	//Subclass
	public static final class OccupiedTile extends Tile {
		
		Piece pieceOnTile;
		
		//OccupiedTile constructor 
		OccupiedTile(int coord, Piece pieceOnTile) {
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
