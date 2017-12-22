package pedregal;

import java.util.Scanner;

import javax.swing.JOptionPane;

import java.io.*;

public class LogicaDeCreacion {
	
	private Terreno miTerreno;
	private Casa miCasa;
	MapaDePeñascos mdp;
	
	public LogicaDeCreacion()
	{
		Scanner sc;
		File archIn=new File(JOptionPane.showInputDialog("Ingrese la ruta completa del archivo de entrada"));
		try
		{
			sc=new Scanner(archIn);
			miTerreno=new Terreno(sc.nextInt(),sc.nextInt());
			miCasa=new Casa(sc.nextInt(),sc.nextInt());
			Peñasco[] peñascos=new Peñasco[sc.nextInt()];
			for(int i=0; i<peñascos.length;i++) // Creo el vector de peñascos. //
			{
				peñascos[i]=new Peñasco(sc.nextInt()-1,sc.nextInt()-1);
			}
			mdp=new MapaDePeñascos(miTerreno.getProfundo(),miTerreno.getAncho(),peñascos);
			try
			{
				sc.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.exit(1);
			}
		}
		catch(FileNotFoundException fnfe)
		{
			fnfe.printStackTrace();
			System.exit(1);
		}		
	}
	
	
	public void generarSalida()  // Hacer este metodo que es el principal. //
	{
		if( (miCasa.getAncho()<=miTerreno.getAncho() && miCasa.getProfundo()<=miTerreno.getProfundo()) || (miCasa.getProfundo()<=miTerreno.getAncho() && miCasa.getAncho()<=miTerreno.getProfundo())   ) // Si la casa entra, por dimensiones, dentro del terreno, procedo a fijarme si tambien ésta entra en cuanto al los peñascos. //
		{
			char orientacion='z'; // PREGUNTAR: Una forma de hacer que no tenga que poner esa 'z' que no sirve para nada y que no me de error en tiempo de compilacion. //
			int menorFilaDeCasaEstablecida=0;
			int menorColumnaDeCasaEstablecida=0;
			boolean salidaPorNo=true;
			
			for(int i=0;i<miTerreno.getProfundo()-miCasa.getProfundo()+1;i++) // Todo lo de dentro de este for es para ver si la casa entra con su frente en posicion horizontal. //
			{
				for(int j=0;j<miTerreno.getAncho()-miCasa.getAncho()+1;j++)
				{
					boolean seguir=true;

					for(int f=i; f<miCasa.getProfundo()+i && seguir==true;f++)
					{
						for(int c=j;c<miCasa.getAncho()+j;c++)
						{
							if(mdp.getPeñascos()[f][c]==true)
							{
								seguir=false;
								if(c>j) // f==i //
								{
									j=c;
								}
								break;
							}
						}
					}
					
					if(seguir==true)
					{
						salidaPorNo=false;
						orientacion='S';
						menorFilaDeCasaEstablecida=i+1;
						menorColumnaDeCasaEstablecida=j+1;
						i=miTerreno.getProfundo(); // Sobrepaso los valores que puede tomar "i" asi corta el for del "i". //
						j=miTerreno.getAncho(); // Idem a comentario de arriba pero para el for de "j". //
					}
				}
			}
			
			
			if(salidaPorNo)	//	En este for de abajo se entra solo si la casa no pudo ser colocada en posicion con su frente en horizontal y, por lo tanto, se procede a tratar de ubicarla en posicion vertical. //
			{
				for(int i=0;i<miTerreno.getProfundo()-miCasa.getAncho()+1;i++)
				{
					for(int j=0;j<miTerreno.getAncho()-miCasa.getProfundo()+1;j++)
					{
						boolean seguir=true;

						for(int f=i; f<miCasa.getAncho()+i && seguir==true;f++)
						{
							for(int c=j; c<miCasa.getProfundo()+j;c++)
							{
								if(mdp.getPeñascos()[f][c]==true)
								{
									seguir=false;
									if(c>j)
									{
										j=c;
									}
									break;
								}
							}
						}
						
						if(seguir==true)
						{
							salidaPorNo=false;
							orientacion='E';	
							menorFilaDeCasaEstablecida=i+1;
							menorColumnaDeCasaEstablecida=j+1;
							i=miTerreno.getProfundo(); // Sobrepaso los valores que puede tomar "i" asi corta el for del "i". //
							j=miTerreno.getAncho(); // Idem a comentario de arriba pero para el for de "j". //
						}
					}
				}
			}
			
			if(salidaPorNo)
			{
				FileWriter fw;
				PrintWriter pw;
				try
				{
					fw=new FileWriter(new File(JOptionPane.showInputDialog("Ingrese el path completo del archivo de salida")));
					pw=new PrintWriter(fw);
					pw.println("NO");
					try
					{
						fw.close();
						pw.close();
					}
					catch(Exception e)
					{
						e.printStackTrace();
						System.exit(1);
					}					
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.exit(1);
				}
			}
			else
			{
				FileWriter fw;
				PrintWriter pw;
				try
				{
					fw=new FileWriter(new File(JOptionPane.showInputDialog("Ingrese el path completo del archivo de salida")));
					pw=new PrintWriter(fw);
					pw.println("SI");
					pw.println(menorFilaDeCasaEstablecida+" "+menorColumnaDeCasaEstablecida);
					pw.print(orientacion);
					try
					{
						fw.close();
						pw.close();
					}
					catch(Exception e)
					{
						e.printStackTrace();
						System.exit(1);
					}					
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.exit(1);
				}
			}
			
			
		}
	}
	
	
}





