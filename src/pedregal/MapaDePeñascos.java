package pedregal;

import java.util.ArrayList;

public class MapaDePe�ascos {
	private boolean[][] pe�ascos;
	
	public MapaDePe�ascos(int profundo, int ancho, Pe�asco[] posDePe�ascos)
	{
		pe�ascos=new boolean[profundo][ancho];
		for(int i=0; i<posDePe�ascos.length; i++)
		{
			pe�ascos[posDePe�ascos[i].getFila()][posDePe�ascos[i].getColumna()]=true; // Los que no se inicialicen a true, por defecto, estaran inicializados en false. //
		}
	}

	public boolean[][] getPe�ascos() {
		return pe�ascos;
	}

	public void setPe�ascos(boolean[][] pe�ascos) {
		this.pe�ascos = pe�ascos;
	}
	
	
}
