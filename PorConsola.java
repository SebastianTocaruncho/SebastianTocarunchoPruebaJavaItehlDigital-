package ficheros;

import java.io.IOException;
import java.util.Scanner;

public class PorConsola {
//Attributes
	private Moderador m=new Moderador();
//----------------------------------
//Methods
   //Method (1): This method will manage the curses
	void mainconsola() throws IOException, NumberFormatException {
		System.out.println("Select a curse mode: \n1) Private curse (Curso privado)\n2) Online curse (Curso Online) \n3)Curse On Demand");
		Scanner o=new Scanner(System.in);
		int op=o.nextInt();
		if((op==1)||(op==2)||(op==3)) {
			if(op==1) {
				//CURSO PRIVADO
				String nombre, descripcion, dirigidoa;		
				int horas, option, p, c=0;
				double costo;
				Scanner s=new Scanner(System.in);
				while(true) {
			
					System.out.println("\nSELECT AN OPTION:");
					System.out.println("1) Add a curse \n2) Search for a register with ID \n3) Delete\n4)Update \n5) Exit");
					option=s.nextInt();
					if((option>0)&&(option<5)) {
						switch(option) {
						//---------------------------------------
						//ADD A NEW CURSE
						case(1):
							System.out.println("ATTENTION: The string's size to add has to be 10.");
							System.out.println("Set a curse ");
							s=new Scanner(System.in);
							nombre=s.nextLine();
							System.out.println("Set a description for the curse");
							s=new Scanner(System.in);
							descripcion=s.nextLine();
			
							System.out.println("Set how many hours");
							s=new Scanner(System.in);
							horas=s.nextInt();
							System.out.println("Set for who");
							s=new Scanner(System.in);
							dirigidoa=s.nextLine();
							System.out.println("Set a price");
							s=new Scanner(System.in);
							costo=s.nextDouble();
							c=c+1;
							System.out.println("You've just added a register with the ID:"+c);
							m.agregarCP(nombre, descripcion, horas, dirigidoa, costo, c);
							break;
						//--------------------------------------
						//READ FILE
						case (2):
							System.out.println("Put a register number to read it.");
							s=new Scanner(System.in);
							p=s.nextInt();
							System.out.println(m.consultarCP(p));
							break;
						//--------------------------------------
						//DELETE
						case (3):
							System.out.println("Put a register number to delete it.");
							s=new Scanner(System.in);
							p=s.nextInt();
							m.eliminarCP(p);
							break;
						//---------------------------------------
						//UPDATE
							
						case (4):
							System.out.println("ATTENTION: The string's size to add has to be 10.");
							System.out.println("Set a curse ");
							s=new Scanner(System.in);
							nombre=s.nextLine();
							System.out.println("Set a description for the curse");
							s=new Scanner(System.in);
							descripcion=s.nextLine();
		
							System.out.println("Set how many hours");
							s=new Scanner(System.in);
							horas=s.nextInt();
							System.out.println("Set a for who");
							s=new Scanner(System.in);
							dirigidoa=s.nextLine();
							System.out.println("Set a price");
							s=new Scanner(System.in);
							costo=s.nextDouble();
							System.out.println("In what position do you want to update?");
							s=new Scanner(System.in);
							p=s.nextInt();
							m.actualizarCP(nombre, descripcion, horas, dirigidoa, costo, p);
							break;
						}//End switch
				
					}else {
				
						if(option==5) {
							break;
						}else {
							
						}//End conditional (4)
			       }//End conditional (1)
				}//End conditional (0)				
			}else {
				if(op==2) {
					//CURSO ONLINE
					String nombre, descripcion, dirigidoa;		
					int horas, option, p, c=0;
					double costo;
					Scanner s=new Scanner(System.in);
					while(true) {
						System.out.println("\nSELECT AN OPTION:");
						System.out.println("1) Add a curse \n2) Search for a register with ID \n3) Delete\n4)Update \n5) Exit");
						option=s.nextInt();
						if((option>0)&&(option<5)) {
							switch(option) {
							//---------------------------------------
							//ADD A NEW CURSE
							case(1):
								System.out.println("ATTENTION: The string's size to add has to be 10.");
								System.out.println("Set a curse ");
								s=new Scanner(System.in);
								nombre=s.nextLine();
								System.out.println("Set a description for the curse");
								s=new Scanner(System.in);
								descripcion=s.nextLine();
				
								System.out.println("Set how many hours");
								s=new Scanner(System.in);
								horas=s.nextInt();
								System.out.println("Set a for who");
								s=new Scanner(System.in);
								dirigidoa=s.nextLine();
								System.out.println("Set a price");
								s=new Scanner(System.in);
								costo=s.nextDouble();
								c=c+1;
								System.out.println("You've just added a register with the ID:"+c);
								m.agregarCOL(nombre, descripcion, horas, dirigidoa, costo, c);
								break;
							//--------------------------------------
							//READ FILE
							case (2):
								System.out.println("Put a register number to read it.");
								s=new Scanner(System.in);
								p=s.nextInt();
								System.out.println(m.consultarCOL(p));
								break;
							//--------------------------------------
							//DELETE
							case (3):
								System.out.println("Put a register number to delete it.");
								s=new Scanner(System.in);
								p=s.nextInt();
								m.eliminarCOL(p);
								break;
							//---------------------------------------
							//UPDATE
							case (4):
								System.out.println("ATTENTION: The string's size to add has to be 10.");
								System.out.println("Set a curse ");
								s=new Scanner(System.in);
								nombre=s.nextLine();
								System.out.println("Set a description for the curse");
								s=new Scanner(System.in);
								descripcion=s.nextLine();
			
								System.out.println("Set how many hours");
								s=new Scanner(System.in);
								horas=s.nextInt();
								System.out.println("Set a for who");
								s=new Scanner(System.in);
								dirigidoa=s.nextLine();
								System.out.println("Set a price");
								s=new Scanner(System.in);
								costo=s.nextDouble();
								System.out.println("In what position (ID)do you want to update?");
								s=new Scanner(System.in);
								p=s.nextInt();
								m.actualizarCOL(nombre, descripcion, horas, dirigidoa, costo, p);
								break;
							}//End switch
					
						}else {
					
							if(option==5) {
								break;
							}else {
							}//End conditional (4)
				       }//End conditional (1)
					}//End conditional (0)	
				}else {
					//CURSO ON DEMAND
					String nombre, descripcion, dirigidoa;		
					int horas, option, p, c=0;
					double costo;
					Scanner s=new Scanner(System.in);
					while(true) {
				
						System.out.println("\nSELECT AN OPTION:");
						System.out.println("1) Add a curse \n2) Search for a register with ID \n3) Delete\n4)Update \n5) Exit");
						option=s.nextInt();
						if((option>0)&&(option<5)) {
							switch(option) {
							//---------------------------------------
							//ADD A NEW CURSE
							case(1):
								System.out.println("ATTENTION: The string's size to add has to be 10.");
								System.out.println("Set a curse ");
								s=new Scanner(System.in);
								nombre=s.nextLine();
								System.out.println("Set a description for the curse");
								s=new Scanner(System.in);
								descripcion=s.nextLine();
				
								System.out.println("Set how many hours");
								s=new Scanner(System.in);
								horas=s.nextInt();
								System.out.println("Set a for who");
								s=new Scanner(System.in);
								dirigidoa=s.nextLine();
								System.out.println("Set a price");
								s=new Scanner(System.in);
								costo=s.nextDouble();
								c=c+1;
								System.out.println("You've just added a register with the ID:"+c);
								m.agregarCOD(nombre, descripcion, horas, dirigidoa, costo, c);
								break;
							//--------------------------------------
							//READ FILE
							case (2):
								System.out.println("Put a register number to read it.");
								s=new Scanner(System.in);
								p=s.nextInt();
								System.out.println(m.consultarCOD(p));
								break;
							//--------------------------------------
							//DELETE
							case (3):
								System.out.println("Put a register number to delete it.");
								s=new Scanner(System.in);
								p=s.nextInt();
								m.consultarCOD(p);
								break;
							//---------------------------------------
							//UPDATE
							case (4):
								System.out.println("ATTENTION: The string's size to add has to be 10.");
								System.out.println("Set a curse ");
								s=new Scanner(System.in);
								nombre=s.nextLine();
								System.out.println("Set a description for the curse");
								s=new Scanner(System.in);
								descripcion=s.nextLine();
			
								System.out.println("Set how many hours");
								s=new Scanner(System.in);
								horas=s.nextInt();
								System.out.println("Set a for who");
								s=new Scanner(System.in);
								dirigidoa=s.nextLine();
								System.out.println("Set a price");
								s=new Scanner(System.in);
								costo=s.nextDouble();
								System.out.println("In what position (ID) do you want to update?");
								s=new Scanner(System.in);
								p=s.nextInt();
								m.actualizarCOD(nombre, descripcion, horas, dirigidoa, costo, p);
								break;
							}//End switch
					
						}else {
					
							if(option==5) {
								break;
							}else {
								
							}//End conditional (4)
				       }//End conditional (1)
					}//End conditional (0)
				}//End conditional (3)
			}//End conditional (2)
		}else {
			System.out.print("You've written a wrong option");
		}//End conditional(1)	
	}//End method (1)
}//End class 'Por Consola'
