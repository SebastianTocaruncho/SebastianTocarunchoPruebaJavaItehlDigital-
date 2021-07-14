package ficheros;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

class Curso_OnDemand extends Curso {
	//Attributes
		ArrayList<Curso_OnDemand> registro=new ArrayList<>();
		RandomAccessFile cuondemand;
		
	 //Constructor (1)
	 Curso_OnDemand(String nombre, String descripcion, int horas, String dirigidoa, double costo) {
		  super.costo=costo;
		  super.descripcion=descripcion;
		  super.horas=horas;
		  super.nombre=nombre;
		  super.dirigidoa=dirigidoa;
	 }//End constructor(1)
	 
	 
	//----------------------------------
	//Methods
		
		//Method (1): This method will add  registers into the file.
		@Override
		void agregarcurso(int p){
		    try(RandomAccessFile cuondemand=new RandomAccessFile("CursoOnDemand.txt", "rw")){
		    	/*Cada 72 bytes se va a posicionar un registro dentro del fichero*/
		    	/*Char = 1 byte
		    	 * Short = 2 bytes
		    	 * int = 4 bytes
		    	 * float = 4 bytes
		    	 * double = 8 bytes
		    	 * String = 2 x El tamaño de la cadena
		    	 * Siguiendo el orden de las variables, entonces:
		    	 * (10*2)+(10*2)+(4)+(10*2)+(8)=72*/
		    	cuondemand.seek(72*(p-1));
			    registro.add(new Curso_OnDemand(super.nombre, super.descripcion, super.horas, super.dirigidoa, super.costo));
			    for(Curso_OnDemand cod: registro) {
			    	StringBuffer sb=new StringBuffer(nombre);
			    	sb.setLength(10); 
			    	cuondemand.writeChars(sb.toString());
			    	
			    	sb=new StringBuffer(descripcion);
			    	sb.setLength(10);
			    	cuondemand.writeChars(sb.toString());
			    	
			    	cuondemand.writeInt(horas);
			    	
			    	sb=new StringBuffer(dirigidoa);
			    	sb.setLength(10);
			    	cuondemand.writeChars(sb.toString());
			    	
			    	cuondemand.writeDouble(costo);
			    }//End loop
		    	
		    }catch(FileNotFoundException e) {
		    	System.out.print(e.getMessage());
		    }catch(IOException e) {
		    	System.out.print(e.getMessage());
		    }//End exceptions
		}//End method 'Agregar curso'
		
		//Method (2): This method will look for something into the file.
		@Override
		String consultarcurso(int p)throws IOException {
		    try(RandomAccessFile cuondemand=new RandomAccessFile("CursoOnDemand.txt", "rw")){
		    
		    	cuondemand.seek(72*(p-1));

	 	
		    	String s="", m="", y="", cadena="";
				double z;
				int x;
		    	for(int i=0; i<10; i++) {
		    		s+=cuondemand.readChar();
		    	}//End loop (1)

		    	for(int i=0; i<10; i++) {
		    		m+=cuondemand.readChar();
		    	}//End loop (1)
		    	
		    	x=cuondemand.readInt();
		    	
		    	for(int i=0; i<10; i++) {
		    		y+=cuondemand.readChar();
		    	}//End loop (1)
		    	
		    	z=cuondemand.readDouble();

		    	cadena=s+"-"+m+"-"+x+"-"+y+"-"+z;
		    	return cadena;
		    }catch(FileNotFoundException e) {
		    	System.out.print(e.getMessage());
		    }catch(IOException e) {
		    	System.out.print(e.getMessage());
		    }//End exceptions
		    return null;
		}//End method 'Consultar curso'
		
		//Method (3): This method will update a registers into the file.
		@Override
		void actualizarcurso(int p) throws IOException {
		    try(RandomAccessFile cuondemand=new RandomAccessFile("CursoOnDemand.txt", "rw")){
		    	cuondemand.seek(72*(p-1));
			    registro.add(new Curso_OnDemand(super.nombre, super.descripcion, super.horas, super.dirigidoa, super.costo));
			    for(Curso_OnDemand cp: registro) {
			    	StringBuffer sb=new StringBuffer(nombre);
			    	sb.setLength(10); 
			    	cuondemand.writeChars(sb.toString());
			    	
			    	sb=new StringBuffer(descripcion);
			    	sb.setLength(10);
			    	cuondemand.writeChars(sb.toString());
			    	
			    	cuondemand.writeInt(horas);
			    	
			    	sb=new StringBuffer(dirigidoa);
			    	sb.setLength(10);
			    	cuondemand.writeChars(sb.toString());
			    	
			    	cuondemand.writeDouble(costo);
			    }//End loop
		    	
		    }catch(FileNotFoundException e) {
		    	System.out.print(e.getMessage());
		    }catch(IOException e) {
		    	System.out.print(e.getMessage());
		    }//End exceptions		
		}//End method 'Actualizar curso'
		
		//Method (4): This method will delete a register into the file.
		@Override
		void eliminarcuso(int p) throws IOException{
			 try(RandomAccessFile cuondemand=new RandomAccessFile("CursoOnDemand.txt", "rw")){
				 	cuondemand.seek(72*(p-1));		 
			    	registro.add(new Curso_OnDemand(null, null, 0, null, 0));
				    for(Curso_OnDemand cp: registro) {
				    	StringBuffer sb=new StringBuffer(nombre);
				    	sb.setLength(10); 
				    	cuondemand.writeChars(sb.toString());
				    	sb=new StringBuffer(descripcion);
				    	sb.setLength(10);
				    	cuondemand.writeChars(sb.toString());
				    	cuondemand.writeInt(horas);
				    	sb=new StringBuffer(dirigidoa);
				    	sb.setLength(10);
				    	cuondemand.writeChars(sb.toString());
				    	cuondemand.writeDouble(costo);
				    }//End loop
			    }catch(FileNotFoundException e) {
			    	System.out.print(e.getMessage());
			    }catch(IOException e) {
			    	System.out.print(e.getMessage());
			    }//End exceptions		
		}//End method 'eliminar curso'	
}//End class 'Curso OnDemand'
