package pedregal;

public class Casa {
	
	private int ancho;  // Es F. //
	private int profundo; // Es L. //
	
	public Casa(int ancho, int profundo)
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
