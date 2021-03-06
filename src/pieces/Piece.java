package pieces;


public class Piece  {
	
	//보드판위에 있는 말의 숫자와 말들의 point관리 
	public static int whiteCount;
	public static int blackCount;
	public static double whitePoint;
	public static double blackPoint;

	private Color color;
	private Type type;
	private char symbol;
	private double point;
	
	public enum Color {
		BLACK, WHITE, NONE
	}
	
	public enum Type{
		PAWN('p', 1.0), KNIGHT('n', 2.5), ROOK('r', 5.0), BISHOP('b', 3.0), QUEEN('q', 9.0), KING('k', 0.0), Empty('.', 0.0);
		
		private char symbol;
		private double point;

		private Type(char symbol, double point){
			this.symbol = symbol;
			this.point = point;
		}
		
		public char getSymbol(){
			return this.symbol;
		}
		public double getPoint(){
			return this.point;
		}
	}

	//생성자 
	private Piece(Color color, Type type) {
		this.color = color;
		this.type = type;
		this.symbol = type.getSymbol();
		this.point = type.getPoint();

		
		if (isBlack()) {
			this.symbol = (Character.toUpperCase(this.symbol));
			}
	}
	

	public static Piece createBlack(Type type) {
		blackCount++;
		blackPoint += type.getPoint();
		return new Piece(Color.BLACK, type);
	}
	public static Piece createWhite(Type type) {
		whiteCount++;
		whitePoint += type.getPoint();
		return new Piece(Color.WHITE, type);
	}

	public static Piece createEmpty(){
		return new Piece(Color.NONE, Type.Empty);
	}

	public static Piece createWhitePawn(){
		return createWhite(Type.PAWN);
	}

	public static Piece createBlackPawn(){
		return createBlack(Type.PAWN);
	}
	
	public static Piece createWhiteRook(){
		return createWhite(Type.ROOK);
	}
	
	public static Piece createBlackRook(){
		return createBlack(Type.ROOK);
	}
	
	public static Piece createWhiteKnight(){
		return createWhite(Type.KNIGHT);
	}
	
	public static Piece createBlackKnight(){
		return createBlack(Type.KNIGHT);
	}
	
	public static Piece createWhiteBishop(){
		return createWhite(Type.BISHOP);
	}
	
	public static Piece createBlackBishop(){
		return createBlack(Type.BISHOP);
	}

	public static Piece createWhiteQueen(){
		return createWhite(Type.QUEEN);
	}
	
	public static Piece createBlackQueen(){
		return createBlack(Type.QUEEN);
	}
	
	public static Piece createWhiteKing(){
		return createWhite(Type.KING);
	}
	public static Piece createBlackKing(){
		return createBlack(Type.KING);
	}

	public static void resetCount() {
		Piece.blackCount = 0 ; 
		Piece.whiteCount = 0 ;
		Piece.blackPoint = 0;
		Piece.whitePoint = 0;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public Type getType() {
		return this.type;
	}

	public char getSymbol() {
		return this.symbol;
	}

	public double getPoint() {
		return this.point;
	}

	public boolean isWhite() {
		return this.color.equals(Color.WHITE);
	}

	public boolean isBlack() {
		return this.color.equals(Color.BLACK);
	}
	
	public boolean isEmpty() {
		return this.getType().equals((Type.Empty));
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	public boolean isColor(Color color) {
		if (color.equals(this.getColor())){
			return true;
		}
		else;
		return false;
	}

	public double compare(Piece target) {
		return (this.getPoint() - target.getPoint());
	}

	public void changeInfo() {
			if (this.isWhite()) {
				Piece.whiteCount --;
				Piece.whitePoint -= this.getPoint();
			}
			else if (this.isBlack()){
				Piece.blackCount--;
				Piece.blackPoint -= this.getPoint();			
			}
		
	}


}
