package com.chess.engine.pieces;

import java.util.List;

import com.chess.engine.Alliance;
import com.chess.engine.board.*;

public abstract class Piece {
	
	//Each piece takes in a position, and an alliance
	protected final int piecePosition;
	protected final Alliance pieceAlliance;
	
	Piece(final int piecePosition, final Alliance pieceAlliance) {
		this.pieceAlliance = pieceAlliance;
		this.piecePosition = piecePosition;
	}
	
	public abstract List<Move> calculateLegalMoves(final Board board);
}
