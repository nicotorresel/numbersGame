package backend;

public class Juego {
	
	private int rows; 		//cantidad filas en caso de escalar en el juego
	private int columns;	// cantidad de columnas
	private int[][] board; // matriz que representa el tablero del juego
	private int[] rowsInput;	// arreglo en el que cada elemento representa la suma de la fila correspondiente
	private int[] columnsInput; // idem anterior pero con filas
	
	private int[][] boardResult;
	private int[] rowsResult; // array que representa el resultado de las filas
	private int[] columnsResult; // array que representa el resultado de las columnas

	
	//CONSTRUCTOR
	public Juego (int rows, int columns ) {
		
		this.rows = rows;
		this.columns = columns;
		
		//primero creo el tablero y los resultados de cada fila y columna
		this.boardResult = new int[rows][columns];
		this.rowsResult = new int[rows];
		this.columnsResult = new int[columns];
		
		
		
		//inicializo el tablero del resultado con valores random
		for (int i = 0; i<rows; i++) {
			for (int j = 0; j<columns; j++) {
				double a = Math.random()*5+1;  //genero un numero random entre el 1 y el 5
				boardResult[i][j] = (int) a;
			}
		}
		
		//inicializo los valores del los resultado de las filas		
		for (int i=0;i<this.rowsResult.length;i++) {
			int valor = 0;
			for (int j=0; j<this.columnsResult.length;j++) {
				valor=valor+this.boardResult[i][j];
			}
			this.rowsResult[i]=valor;
		}
		
		//inicializo los valores del los resultado de las columnas	
		for (int i=0;i<this.columnsResult.length;i++) {
			int valor = 0;
			for (int j=0; j<this.rowsResult.length;j++) {
				valor=valor+this.boardResult[j][i];
			}
			this.columnsResult[i]=valor;
		}
			
		//creo el tablero en base a los paremtros que se pasan en el constuctor
		this.board = new int[rows][columns];
		this.rowsInput = new int[rows];
		this.columnsInput = new int[columns];
		
	}
	
			
	//pone en el tablero el numero pasado por parametro	en la fila y columna asignada
	public void inputNumber(int number, int row, int column) {

		validNumber(number); //valido el numero
		validRow(row);		//valido la fila
		validColumn(column); //valido la columna
		
		if (this.board[row][column]==0) {
			
			this.board [row][column] = number; 
			
			//luego de agregar el numero en la fila y columna correspondiente sumo ese valor a dicha fila y columna para ir teniendo el parcial
			this.sumNumberInRows(number, row, this.rowsInput);
			this.sumNumberInColumns(number, column, this.columnsInput);
		}
		else {
			throw new IllegalArgumentException("La posición donde se quiere agregar el número ya se encuentra ocupada");
		}
		
	}

	//valido si el numero agregado es valido
	private void validNumber(int number) {
		if ( number<=0 )
			throw new IllegalArgumentException("el numero: " + number + " debe ser mayor a cero");
	}
	
	//valido la fila en la que quiero agregar el numero
	private void validRow(int row) {	
		if ( row >= this.rows || row < 0)
			throw new IllegalArgumentException("la fila " + row + " no existe en el tablero de juego");
	}
	
	//valido la columna en la que quiero agregar el numero
	private void validColumn(int column) {
		if ( column >= this.columns || column < 0 )
			throw new IllegalArgumentException("la columna " + column + "no existe en ele tablero de juego");
	}
	
	//agrega el numero pasado por parametro al array de filas en las que se esta jugando para luego comparar resultados
	private void sumNumberInRows(int number, int row, int[] rows) {
		rows[row] = rows[row] + number;
	}
	
	//agrega el numero pasado por parametro al array de columnas en las que se esta jugando para luego comparar resultdos
	private void sumNumberInColumns(int number, int column, int[] columns) {
		columns[column] = columns[column] + number;
	}
	
	//devuelve true si el resultado de la fila pasada por parametro es correcta
	public boolean compareRows(int row) {
		validRow(row);
		return ( this.rowsResult[row] == this.rowsInput[row] );
	}
	
	//devuelve true si el resultado de la columna pasada por parametro es correcta
	public boolean compareColumns(int column) {
		validColumn(column);
		return ( this.columnsResult[column] == this.columnsInput[column] );
	}
	
	//devuelve el array de inputs de fila
	public int[] getRowsInput() {
		return this.rowsInput;
	}
	
	//devuelve el array de inputs de columnas
	public int[] getColumnsInput()	{
		return this.columnsInput;
	}
	
	//devuelve el array de resultado de filas
	public int[] getRowsResult() {
		return this.rowsResult;
	}
	
	//devuelve el array de resultado de las columnas
	public int[] getColumnsResult() {
		return this.columnsResult;
	}

	//devuelve el resultado de la fila indicada
	public int rowResult(int row) {
		validRow(row);
		return getRowsResult()[row];
	}
	
	//devuelve el resultado de la columna indicada
	public int columnResult(int column) {
		validColumn(column);
		return getColumnsResult()[column];
	}
	
	//devuelve la suma parcial de la fila indicada
	public int parcialRow(int row) {
		validRow(row);
		return this.rowsInput[row];
	}
	
	//devuelve la suma parcial de la columna indicada
	public int parcialColumn(int column) {
		return this.columnsInput[column];
	}
	
	//devuelve true si gano la partida
	public boolean win() {
		boolean ret = true;
		boolean ret2 = true;
		for (int i=0; i<this.rowsResult.length; i++ ) {
			ret = ret && compareRows(i);
		}
		for (int j=0; j<this.columnsResult.length; j++) {
			ret2 = ret && compareColumns(j);
		}
		return ret && ret2;
	}

}
