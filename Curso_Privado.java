package ficheros;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

class Curso_Privado extends Curso {
//Attributes
	ArrayList<Curso_Privado> registro=new ArrayList<>();
	RandomAccessFile cuprivado;
	
 //Constructor (1)
 Curso_Privado(String nombre, String descripcion, int horas, String dirigidoa, double costo) {
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
	    try(RandomAccessFile cuprivado=new RandomAccessFile("CursoPrivado.txt", "rw")){
	    	/*Cada 72 bytes se va a posicionar un registro dentro del fichero*/
	    	/*Char = 1 byte
	    	 * Short = 2 bytes
	    	 * int = 4 bytes
	    	 * float = 4 bytes
	    	 * double = 8 bytes
	    	 * String = 2 x El tamaño de la cadena
	    	 * Siguiendo el orden de las variables, entonces:
	    	 * (10*2)+(10*2)+(4)+(10*2)+(8)=72*/
	    	cuprivado.seek(72*(p-1));
		    registro.add(new Curso_Privado(super.nombre, super.descripcion, super.horas, super.dirigidoa, super.costo));
		    for(Curso_Privado cp: registro) {
		    	StringBuffer sb=new StringBuffer(nombre);
		    	sb.setLength(10); 
		    	cuprivado.writeChars(sb.toString());
		    	
		    	sb=new StringBuffer(descripcion);
		    	sb.setLength(10);
		    	cuprivado.writeChars(sb.toString());
		    	
		    	cuprivado.writeInt(horas);
		    	
		    	sb=new StringBuffer(dirigidoa);
		    	sb.setLength(10);
		    	cuprivado.writeChars(sb.toString());
		    	
		    	cuprivado.writeDouble(costo);
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
	    try(RandomAccessFile cuprivado=new RandomAccessFile("CursoPrivado.txt", "rw")){
	    
	    	cuprivado.seek(72*(p-1));

 	
	    	String s="", m="", y="", cadena="";
			double z;
			int x;
	    	for(int i=0; i<10; i++) {
	    		s+=cuprivado.readChar();
	    	}//End loop (1)
	    	
	    	
	    	for(int i=0; i<10; i++) {
	    		m+=cuprivado.readChar();
	    	}//End loop (1)
	    	
	    	x=cuprivado.readInt();
	    	
	    	
	    	for(int i=0; i<10; i++) {
	    		y+=cuprivado.readChar();
	    	}//End loop (1)
	    	z=cuprivado.readDouble();
             
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
	    try(RandomAccessFile cuprivado=new RandomAccessFile("CursoPrivado.txt", "rw")){
	    	cuprivado.seek(72*(p-1));
		    registro.add(new Curso_Privado(super.nombre, super.descripcion, super.horas, super.dirigidoa, super.costo));
		    for(Curso_Privado cp: registro) {
		    	StringBuffer sb=new StringBuffer(nombre);
		    	sb.setLength(10); 
		    	cuprivado.writeChars(sb.toString());
		    	
		    	sb=new StringBuffer(descripcion);
		    	sb.setLength(10);
		    	cuprivado.writeChars(sb.toString());
		    	
		    	cuprivado.writeInt(horas);
		    	
		    	sb=new StringBuffer(dirigidoa);
		    	sb.setLength(10);
		    	cuprivado.writeChars(sb.toString());
		    	
		    	cuprivado.writeDouble(costo);
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
		 try(RandomAccessFile cuprivado=new RandomAccessFile("CursoPrivado.txt", "rw")){
		    	cuprivado.seek(72*(p-1));		 
		    	registro.add(new Curso_Privado(null, null, 0, null, 0));
			    for(Curso_Privado cp: registro) {
			    	StringBuffer sb=new StringBuffer(nombre);
			    	sb.setLength(10); 
			    	cuprivado.writeChars(sb.toString());
			    	
			    	sb=new StringBuffer(descripcion);
			    	sb.setLength(10);
			    	cuprivado.writeChars(sb.toString());
			    	
			    	cuprivado.writeInt(horas);
			    	
			    	sb=new StringBuffer(dirigidoa);
			    	sb.setLength(10);
			    	cuprivado.writeChars(sb.toString());
			    	
			    	cuprivado.writeDouble(costo);
			    }//End loop
		    }catch(FileNotFoundException e) {
		    	System.out.print(e.getMessage());
		    }catch(IOException e) {
		    	System.out.print(e.getMessage());
		    }//End exceptions		
	}//End method 'eliminar curso'	
	
}//End class 'Curso privado'
