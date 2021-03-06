package pedregal;

import java.util.ArrayList;

public class MapaDePeņascos {
	private boolean[][] peņascos;
	
	public MapaDePeņascos(int profundo, int ancho, Peņasco[] posDePeņascos)
	{
		peņascos=new boolean[profundo][ancho];
		for(int i=0; i<posDePeņascos.length; i++)
		{
			peņascos[posDePeņascos[i].getFila()][posDePeņascos[i].getColumna()]=true; // Los que no se inicialicen a true, por defecto, estaran inicializados en false. //
		}
	}

	public boolean[][] getPeņascos() {
		return peņascos;
	}

	public void setPeņascos(boolean[][] peņascos) {
		this.peņascos = peņascos;
	}
	
	
}
