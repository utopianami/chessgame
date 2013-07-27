package chessgame;



import java.util.ArrayList;

import pieces.Piece;
import util.StringUtil;
import junit.framework.TestCase;
import static pieces.Piece.Color.*;
import static pieces.Piece.Type.*;


 
public class BoardTest extends TestCase {
	
	private Board board;
	
	protected void setUp() {
		board = new Board();
	}
	

	//Board 생성 확인 
	public void testInit() throws Exception {
		
		assertEquals(8, board.chessBoard.size()); //체스판 사이즈 8 확인 

	}
	
	//체스판 좌표를 통해서 위치확인 
	public void testGetState() throws Exception {
		
		//0행, 1열 위치 확인 
		assertEquals('R', board.getMapInfo("a1").getSymbol());
		assertEquals('P', board.getMapInfo("b2").getSymbol());
		
	}
	
	public void testPieceCount() throws Exception {
		
		Board testBoard = new Board();
		System.out.println(testBoard.pieceCount());
		assertEquals(32, testBoard.pieceCount());
	}
	
	//색과 말의 종류 숫자 확인 메소드 
	public void testCountByTypeColor() throws Exception {
		int actual = board.countByTypeColor(BLACK, ROOK);
		System.out.println(board.countByTypeColor(BLACK, KING));
		assertEquals(2, actual);
	}
	
	//보드판 모습 확인 
	public void testBoardPrint() throws Exception {		
		System.out.println("boardPrint 메소드 테스트 결과");		
		System.out.println(new Board().boardPrint());		
		System.out.println("boardPrint 메소드 테스트 결과완료 ");
		String blankRank = StringUtil.appendNewLine("........");
			
		assertEquals(
		StringUtil.appendNewLine("RNBQKBNR") +
		StringUtil.appendNewLine("PPPPPPPP") +
		blankRank + blankRank +blankRank +blankRank +
		StringUtil.appendNewLine("pppppppp") +
		StringUtil.appendNewLine("rnbqkbnr"), new Board().boardPrint());
	
	}
	
	//원하는 위치에 원하는 말을 추가 
	public void testChangePiece() throws Exception {
		assertEquals('P', board.getMapInfo("b1").getSymbol());
		board.changePiece("b1", PAWN, WHITE);
		assertEquals('p', board.getMapInfo("b1").getSymbol());
		
	}
	
	//원하는 위치의 말을 원하는 위치로 이동 
	public void testMovePiece() throws Exception {
		System.out.println(board.getMapInfo("b2").getSymbol());
		System.out.println(board.getMapInfo("a3").getSymbol());
		board.movePiece("b2", "a3");
		System.out.println(board.getMapInfo("b2").getSymbol());
		System.out.println(board.getMapInfo("a3").getSymbol());
	}
	
	//같은 열에 위치한 pawn의 점수 변화 
	public void testCheckPawn2() throws Exception {
		board.checkPoint(BLACK);
		assertEquals(38.0, Piece.blackPoint);
		
		//피스 이동 4개의 말이 같은 열에 존재 
		board.movePiece("b2", "c1");
		board.movePiece("b3", "c4");
		System.out.println(board.boardPrint()); 
		
		board.checkPoint(BLACK);
		assertEquals(4, board.checkPawn(BLACK)); //0.5점을 줘야 될 말은 총 4개 
		assertEquals(36.0,Piece.blackPoint); 
	}
	
	public void testSortByPoint() throws Exception {
		board.sortByPoint(BLACK);
	}
	
}
