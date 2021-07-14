package ficheros;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println("Muy buen d�a, inegnieros. Mi nombre es Sebasti�n Tocaruncho. \n"
				+ "Solo quiero excusarme, por el error de ejecucci�n de la interfaz, \n"
				+ "la aplicaci�n sirve, sin embargo, para hacer una entrega puntual \n"
				+ "no alcanc� a pulir la interfaz gr�fica para completar el MVC. \n"
				+ "Habiendo dicho eso, agradezco por este reto. Saludos cordiales.\n");
		PorConsola consola=new PorConsola();
		
		System.out.println("Select a view: \n1) Console. \n2) Graphic interface.");
		try {
			Scanner s=new Scanner (System.in);
			int o=s.nextInt();
			if(o==1) {
				consola.mainconsola();
			}else {
				if(o==2) {
					launch(args);
				}else {
					System.out.print("Wrong option");
				}//End conditional (2)
			}//End conditional(1)
			
		}catch(NumberFormatException e) {
			System.out.print(e.getMessage());
		}//End exception
	}//End method 'main'
	
	//M�todo generado por la implementaci�n de Java Fx
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/ficheros/plantilla.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
