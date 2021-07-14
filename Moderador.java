package ficheros;

import java.io.IOException;

public class Moderador {
//Attributes
private Curso_Privado cp;
private Curso_Online co;
private Curso_OnDemand cod;
//----------------------------------------------------------------------
//CURSO PRIVADO
  //Method (1):
  void agregarCP(String nombre, String descripcion, int horas, String dirigidoa, double costo, int c) {
	    double cos=0;
	    cos=costo-((costo*10)/100);
		cp=new Curso_Privado(nombre, descripcion, horas, dirigidoa, cos);
		cp.agregarcurso(c);
  }//Method (1)
  
  //Method (2)
  String consultarCP(int p) throws IOException {
	  return cp.consultarcurso(p);
  }//End method (2)
  
  //Method (3)
  void eliminarCP(int p) throws IOException {
	  cp.eliminarcuso(p);
  }//End method (3)
  
  //Method (4)
  void actualizarCP(String nombre, String descripcion, int horas, String dirigidoa, double costo, int p) throws IOException {
	  double cos=0;
	  cos=costo-((costo*10)/100);
	  cp=new Curso_Privado(nombre, descripcion, horas, dirigidoa, cos);
	  cp.actualizarcurso(p);
  }//End method (4)
//----------------------------------------------------------------------
//CURSO ONLINE
  //Method (1):
  void agregarCOL(String nombre, String descripcion, int horas, String dirigidoa, double costo, int c) {
	    double cos=0;
	  	cos=costo-((costo*20)/100);
		co=new Curso_Online(nombre, descripcion, horas, dirigidoa, cos);
		co.agregarcurso(c);
  }//Method (1)
  
  //Method (2)
  String consultarCOL(int p) throws IOException {
	  return co.consultarcurso(p);
  }//End method (2)
  
  //Method (3)
  void eliminarCOL(int p) throws IOException {
	  co.eliminarcuso(p);
  }//End method (3)
  
  //Method (4)
  void actualizarCOL(String nombre, String descripcion, int horas, String dirigidoa, double costo, int p) throws IOException {
	    double cos=0;
	  	cos=costo-((costo*20)/100);
	  co=new Curso_Online(nombre, descripcion, horas, dirigidoa, cos);
	  co.actualizarcurso(p);
  }//End method (4)
//----------------------------------------------------------------------
//CURSO ON DEMAND
  //Method (1):
  void agregarCOD(String nombre, String descripcion, int horas, String dirigidoa, double costo, int c) {
	    double cos=0;
	  	cos=costo-((costo*30)/100);
		cod = new Curso_OnDemand(nombre, descripcion, horas, dirigidoa, cos);
		cod.agregarcurso(c);
  }//Method (1)
  
  //Method (2)
  String consultarCOD(int p) throws IOException {
	  return cod.consultarcurso(p);
  }//End method (2)
  
  //Method (3)
  void eliminarCOD(int p) throws IOException {
	  cod.eliminarcuso(p);
  }//End method (3)
  
  //Method (4)
  void actualizarCOD(String nombre, String descripcion, int horas, String dirigidoa, double costo, int p) throws IOException {
	    double cos=0;
	  	cos=costo-((costo*30)/100);
	  cod=new Curso_OnDemand(nombre, descripcion, horas, dirigidoa, cos);
	  cod.actualizarcurso(p);
  }//End method (4)
}//End class 'Moderador'
