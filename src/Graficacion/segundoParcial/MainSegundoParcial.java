package Graficacion.segundoParcial;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainSegundoParcial extends Application
{
    private Scene scene;
    private ComboBox<String> filtros;
    private VBox vBox;
    private Imagen imagen;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.createComponents();
        primaryStage.setTitle("Procesamiento de imagenes");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(500); primaryStage.setMinHeight(500);
        primaryStage.setResizable(false);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    private void createComponents(){
        vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        Label titulo = new Label("Procesamiento de Imagenes");
        filtros = new ComboBox<>();
        filtros.setValue("");
        filtros.setDisable(true);
        filtros.getItems().addAll("PasaBanda","PasaBaja","PasaAlta","Negativo","Media","Mediana","Roberts","Sobel");
        filtros.setOnAction(event -> eventos(1));
        Button button = new Button("Elegir Imagen");
        button.setOnAction(event -> eventos(0));
        vBox.getChildren().addAll(titulo,filtros,button);
        scene = new Scene(vBox);
    }
    private void eventos(int i){
        if (i==0){
            try{
                FileChooser selector = new FileChooser();
                selector.setTitle("ImagenATrabajar");
                selector.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG files", "*.jpg"));
                selector.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG files", "*.JPG"));
                imagen = new Imagen(selector.showOpenDialog(null));
                filtros.setDisable(false);
            }catch (IllegalArgumentException iae){ }

        }
        if (i==1){
            switch (filtros.getValue()){
                case "PasaBanda":
                    new DatosPasaBanda(imagen);
                    break;
                case "PasaBaja":
                    imagen.filtroPasaBaja();
                    break;
                case "PasaAlta":
                    imagen.filtroPasaAlta();
                    break;
                case "Negativo":
                    imagen.negativoImagen();
                    break;
                case "Media":
                    imagen.media();
                    break;
                case "Mediana":
                    imagen.mediana();
                    break;
                case "Roberts":
                    imagen.roberts();
                    break;
                case "Sobel":
                    imagen.sobel();
                    break;
            }
        }
    }
}