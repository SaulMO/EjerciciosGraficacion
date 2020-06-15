package Graficacion.segundoParcial;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DatosPasaBanda extends Stage
{
    private Scene scene;
    private VBox vBox;
    private Button button;
    private TextField txtUmbRA,txtUmbRB,txtUmbGA,txtUmbGB,txtUmbBA,txtUmbBB;
    private Imagen imagen;

    public DatosPasaBanda(Imagen imagen){
        this.imagen = imagen;
        this.initAndCreateComponents();
        this.setScene(scene);
        this.initStyle(StageStyle.UNDECORATED);
        this.initModality(Modality.APPLICATION_MODAL);
        this.show();
    }

    private void initAndCreateComponents(){
        vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        Label titulo = new Label("Especificaciones Pasa Banda");
        Label lbUmbRA = new Label("Umbral RED A");
        Label lbUmbRB = new Label("Umbral RED B");
        Label lbUmbGA = new Label("Umbral GREEN A");
        Label lbUmbGB = new Label("Umbral GREEN B");
        Label lbUmbBA = new Label("Umbral BLUE A");
        Label lbUmbBB = new Label("Umbral BLUE B");

        txtUmbRA = new TextField();
        txtUmbRB = new TextField();
        txtUmbGA = new TextField();
        txtUmbGB = new TextField();
        txtUmbBA = new TextField();
        txtUmbBB = new TextField();

        txtUmbRA.setPromptText("  < umbralRB");
        txtUmbRB.setPromptText("  > umbralRA");
        txtUmbGA.setPromptText("  < umbralGB");
        txtUmbGB.setPromptText("  > umbralGA");
        txtUmbBA.setPromptText("  < umbralBB");
        txtUmbBB.setPromptText("  > umbralBA");

        HBox hBoxRED = new HBox(10);
        hBoxRED.setAlignment(Pos.CENTER);
        HBox hBoxGREEN = new HBox(10);
        hBoxGREEN.setAlignment(Pos.CENTER);
        HBox hBoxBLUE = new HBox(10);
        hBoxBLUE.setAlignment(Pos.CENTER);

        button = new Button("RealizarPasaBanda");
        button.setOnAction(event -> evento());

        hBoxRED.getChildren().addAll(lbUmbRA,txtUmbRA,lbUmbRB,txtUmbRB);
        hBoxGREEN.getChildren().addAll(lbUmbGA,txtUmbGA,lbUmbGB,txtUmbGB);
        hBoxBLUE.getChildren().addAll(lbUmbBA,txtUmbBA,lbUmbBB,txtUmbBB);
        vBox.getChildren().addAll(titulo,hBoxRED,hBoxGREEN,hBoxBLUE,button);
        scene = new Scene(vBox);
    }
    private void evento(){
        imagen.filtroBanda(Integer.parseInt(txtUmbRA.getText()),
                Integer.parseInt(txtUmbGA.getText()),
                Integer.parseInt(txtUmbBA.getText()),
                Integer.parseInt(txtUmbRB.getText()),
                Integer.parseInt(txtUmbGB.getText()),
                Integer.parseInt(txtUmbBB.getText()));
        this.close();
    }
}