package pedregal;

public class Terreno {
	
	private int ancho;
	private int profundo;
	
	public Terreno(int ancho, int profundo)
	{
		this.ancho=ancho;
		this.profundo=profundo;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getProfundo() {
		return profundo;
	}

	public void setProfundo(int profundo) {
		this.profundo = profundo;
	}
}
