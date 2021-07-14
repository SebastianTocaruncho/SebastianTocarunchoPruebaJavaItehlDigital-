package ficheros;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PlantillaController {
//Attributes
	@FXML 
	private TextField nombre, descripcion, horas, dirigidoa, costo, campo, mostrarid, registro, registro2, registro3, nombre1, descripccion1, horas1, dirigidoa1, costo1, option;
	private Moderador m=new Moderador();

	
//------------------------------------------
//Methods

	@FXML private String send(ActionEvent event) {
		
		String modalidad=option.getText();
		if(modalidad.equals("1")) {
			return "1";
		}else {
			if(modalidad.equals("2")) {
				return "2";
			}else {
				if(modalidad.equals("3")) {
					return "3";
				}else {
					return null;
				}//End conditional(3)
			}//End conditional (2)
		}//End conditional (1)
		
	}	
	
	
	@FXML private void add(ActionEvent event) {
		String n=nombre.getText();
		String d=descripcion.getText();
		int h=Integer.parseInt(horas.getText());
		String da=dirigidoa.getText();
		double c=Double.parseDouble(costo.getText());
		int p=0;
		if(send(event).equals("1")) {
			p=p+1;
			m.agregarCP(n, d, h, da, c, p);
		}else {
			p=p+1;
			if(send(event).equals("2")) {
				p=p+1;
				m.agregarCP(n, d, h, da, c, p);;
			}else {
				if(send(event).equals("3")) {
					p=p+1;
					m.agregarCP(n, d, h, da, c, p);
					}//End conditional(3)
			}//End conditional (2)
		}//End conditional (1)
	}
	
	@FXML private void look(ActionEvent event) throws IOException {
		int p=Integer.parseInt(registro.getText());
		if(send(event).equals("1")) {
			campo.setText(m.consultarCP(p));
		}else {
			if(send(event).equals("2")) {
				campo.setText(m.consultarCOL(p));
			}else {
				if(send(event).equals("3")) {
					campo.setText(m.consultarCOD(p));
				}//End conditional(3)
			}//End conditional (2)
		}//End conditional (1)
	}
	
	@FXML private void delete(ActionEvent event) throws IOException {
		int p=Integer.parseInt(registro2.getText());
		if(send(event).equals("1")) {
			m.eliminarCP(p);
		}else {
			if(send(event).equals("2")) {
				m.eliminarCOL(p);
			}else {
				if(send(event).equals("3")) {
					m.eliminarCOD(p);
				}//End conditional(3)
			}//End conditional (2)
		}//End conditional (1)
	}
	
	@FXML private void update(ActionEvent event) throws IOException {
		String n=nombre1.getText();
		String d=descripccion1.getText();
		int h=Integer.parseInt(horas1.getText());
		String da=dirigidoa1.getText();
		double c=Double.parseDouble(costo1.getText());
		int p=Integer.parseInt(registro3.getText());
		if(send(event).equals("1")) {
			m.actualizarCP(n, d, h, da, c, p);
		}else {
			if(send(event).equals("2")) {
				m.actualizarCOL(n, d, h, da, c, p);
			}else {
				if(send(event).equals("3")) {
					m.actualizarCOD(n, d, h, d, c, p);
				}//End conditional(3)
			}//End conditional (2)
		}//End conditional (1)
	}
	
	@FXML private void exit(ActionEvent event) {
		
	}
	

}//End class 'Controlador de plantilla'
