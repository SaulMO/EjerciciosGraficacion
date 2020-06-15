package Graficacion.PrimerParcial;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;

public class Main extends Application
{

    private Scene scene;
    private VBox panePrincipal;
    private GridPane layoutDatos;
    private TextField x1,y1,x2,y2,radio,a,b,c;
    private ComboBox<String> opciones;
    private Button btnHacer,btnSalir;
    private PanelDibujo planoCartesiano;
    private Alert alert;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        createMenu();
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Graficación");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void createMenu(){
        panePrincipal = new VBox(15); panePrincipal.setAlignment(Pos.CENTER);
        panePrincipal.setId("main");
        opciones = new ComboBox<>();
        opciones.getItems().addAll("Círculo","Linea","Función Cuadrática");
        opciones.setOnAction(event -> desplegarDatos());
        btnHacer = new Button("Dibujar");
        btnHacer.setCursor(Cursor.HAND);
        btnHacer.setOnAction(event -> hacerDibujo());
        btnSalir = new Button("Salir");
        btnSalir.setCursor(Cursor.HAND);
        btnSalir.setOnAction(event -> {
            planoCartesiano.close();
            primaryStage.close();
        });
        planoCartesiano = new PanelDibujo(primaryStage);
        layoutDatos = new GridPane();
        x1=new TextField(); x1.setPromptText("x1"); x1.setVisible(false); layoutDatos.add(x1,0,0);
        y1=new TextField(); y1.setPromptText("y1"); y1.setVisible(false); layoutDatos.add(y1,1,0);
        x2=new TextField(); x2.setPromptText("x2"); x2.setVisible(false); layoutDatos.add(x2,0,1);
        y2=new TextField(); y2.setPromptText("y2"); y2.setVisible(false); layoutDatos.add(y2,1,1);
        radio=new TextField(); radio.setPromptText("radio"); radio.setVisible(false); layoutDatos.add(radio,0,1,2,1);
        a=new TextField(); a.setPromptText("a x^2"); a.setVisible(false); layoutDatos.add(a,0,0);
        b=new TextField(); b.setPromptText("b x"); b.setVisible(false); layoutDatos.add(b,1,0);
        c=new TextField(); c.setPromptText("c"); c.setVisible(false); layoutDatos.add(c,0,1,2,1);
        HBox layoutBotones = new HBox(10);  layoutBotones.setAlignment(Pos.CENTER);
        layoutBotones.getChildren().addAll(btnHacer,btnSalir);
        panePrincipal.getChildren().addAll(opciones,layoutDatos,layoutBotones);
        //Alerta datos erroneos
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Brou");
        alert.initStyle(StageStyle.UNDECORATED);
        alert.setContentText("Error a la hora de ingresar datos");
        //Modificación de la scene
        scene = new Scene(panePrincipal);
        scene.getStylesheets().add(getClass().getResource("estilo.css").toExternalForm());
    }
    private void desplegarDatos(){
        switch (opciones.getValue()){
            case "Círculo":
                x1.setVisible(true); x1.setText("");
                y1.setVisible(true); y1.setText("");
                radio.setVisible(true); radio.setText("");
                x2.setVisible(false);
                y2.setVisible(false);
                a.setVisible(false);
                b.setVisible(false);
                c.setVisible(false);
                break;
            case "Linea":
                x1.setVisible(true); x1.setText("");
                y1.setVisible(true); y1.setText("");
                radio.setVisible(false);
                x2.setVisible(true); x2.setText("");
                y2.setVisible(true); y2.setText("");
                a.setVisible(false);
                b.setVisible(false);
                c.setVisible(false);
                break;
            case "Función Cuadrática":
                x1.setVisible(false);
                y1.setVisible(false);
                radio.setVisible(false);
                x2.setVisible(false);
                y2.setVisible(false);
                a.setVisible(true); a.setText("");
                b.setVisible(true); b.setText("");
                c.setVisible(true); c.setText("");
                break;
        }
    }
    private void hacerDibujo(){
        switch(opciones.getValue()){
            case "Círculo":
                //x1,y1,x2,y2,radio,a,b,c;
                if (probarDato(x1) && probarDato(y1) && probarDato(radio)){
                    planoCartesiano.dibujarCirculo(Integer.parseInt(x1.getText()),
                                                    Integer.parseInt(y1.getText()),
                                                    Integer.parseInt(radio.getText()));
                }else
                    alert.showAndWait();
                break;
            case "Linea":
                if (probarDato(x1) && probarDato(y1) && probarDato(x2) && probarDato(y2)){
                    planoCartesiano.dibujarLinea(Double.parseDouble(x1.getText()),
                                                Double.parseDouble(y1.getText()),
                                                Double.parseDouble(x2.getText()),
                                                Double.parseDouble(y2.getText()));
                }else
                    alert.showAndWait();
                break;
            case "Función Cuadrática":
                if (probarDato(a) && probarDato(b) && probarDato(c)){
                    planoCartesiano.dibujarFuncionCuadratica(Double.parseDouble(a.getText()),
                                                            Double.parseDouble(b.getText()),
                                                            Double.parseDouble(c.getText()));
                }else
                    alert.showAndWait();
                break;
        }
    }
    private boolean probarDato(TextField tF){
        try{
            Double.parseDouble(tF.getText());
            return true;
        }catch (NumberFormatException nfe){
            return false;
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
