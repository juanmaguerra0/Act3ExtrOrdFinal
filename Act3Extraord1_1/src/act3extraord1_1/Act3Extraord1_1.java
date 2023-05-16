/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package act3extraord1_1;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Person;
import view.PersonOverviewController;

/**
 * @author Juanma
 */
public class Act3Extraord1_1 extends Application {
    
    // Declaramos una variable para el escenario principal de la aplicación.
    private Stage primaryStage;
    
    // Declaramos una variable para el layout principal de la aplicación.
    private BorderPane rootLayout;

    // Declaramos una lista observable de objetos de tipo Person.
    private ObservableList<Person> personData = FXCollections.observableArrayList();

    /**
     * Constructor de la clase Act3Extraord1_1.
     * Aquí se añaden algunas personas a la lista observable.
     */
    public Act3Extraord1_1() {
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
    }
  
    /**
     * Método que devuelve la lista observable de personas.
     * @return personData, la lista observable de personas.
     */
    public ObservableList<Person> getPersonData() {
        return personData;
    }
    
    @Override
    public void start(Stage primaryStage) {
        // Guardamos el escenario principal.
        this.primaryStage = primaryStage;
        
        // Establecemos el título del escenario principal.
        this.primaryStage.setTitle("AddressApp");

        // Inicializamos el layout principal.
        initRootLayout();

        // Mostramos la vista general de las personas.
        showPersonOverview();
    }
    
    /**
     * Método que inicializa el layout principal.
     */
    public void initRootLayout() {
        try {
            // Cargamos el layout principal desde un archivo fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Act3Extraord1_1.class.getResource("/view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Mostramos la escena que contiene el layout principal.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Método que muestra la vista general de las personas dentro del layout principal.
     */
    public void showPersonOverview() {
        try {
            // Cargamos la vista general de las personas.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Act3Extraord1_1.class.getResource("/view/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Establecemos la vista general de las personas en el centro del layout principal.
            rootLayout.setCenter(personOverview);

            // Damos al controlador acceso a la aplicación principal.
            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Método que devuelve el escenario principal.
     * @return primaryStage, el escenario principal.
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    // Método principal que lanza la aplicación.
    public static void main(String[] args) {
        launch(args);
    }
    
}
