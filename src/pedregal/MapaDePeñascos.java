package pedregal;

import java.util.ArrayList;

public class MapaDePeñascos {
	private boolean[][] peñascos;
	
	public MapaDePeñascos(int profundo, int ancho, Peñasco[] posDePeñascos)
	{
		peñascos=new boolean[profundo][ancho];
		for(int i=0; i<posDePeñascos.length; i++)
		{
			peñascos[posDePeñascos[i].getFila()][posDePeñascos[i].getColumna()]=true; // Los que no se inicialicen a true, por defecto, estaran inicializados en false. //
		}
	}

	public boolean[][] getPeñascos() {
		return peñascos;
	}

	public void setPeñascos(boolean[][] peñascos) {
		this.peñascos = peñascos;
	}
	
	
}
