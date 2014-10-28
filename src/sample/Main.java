package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static java.lang.Double.*;

public class Main extends Application {

    public String calculate(double betrag, double zinsen) {
        Double ergebnissDouble = betrag / 100 * zinsen;
        return ergebnissDouble.toString();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane mainPane = new Pane();
        Scene scene = new Scene(mainPane, 500, 400);

        primaryStage.setTitle("Zinsen Aufgabe");

        Label betragLabel = new Label("Betrag");
        Label zinsenLabel = new Label("Zinssatz in %");
        Label ergebnissLabel = new Label("Ergebniss");

        betragLabel.setPrefWidth(75);
        zinsenLabel.setPrefWidth(75);
        ergebnissLabel.setPrefWidth(75);

        TextField betragTextfield = new TextField("100");
        TextField zinsenTextfield = new TextField("5");
        TextField ergebnissgTextfield = new TextField("");

        HBox betragHBox = new HBox(betragLabel, betragTextfield);
        HBox zinsenHBox = new HBox(zinsenLabel, zinsenTextfield);
        HBox ergebnissHBox = new HBox(ergebnissLabel, ergebnissgTextfield);
        Button ergebnissBtn = new Button("Ergebniss anzeigen");

        Double betragDouble = parseDouble(betragTextfield.getText().toString());
        Double zinsenDouble = parseDouble(zinsenTextfield.getText().toString());


        ergebnissBtn.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //ergebnissgTextfield.setText(calculate(betragDouble, zinsenDouble));
               // ergebnissgTextfield.setText("test");
            }
        });

        VBox vBox = new VBox(betragHBox, zinsenHBox, ergebnissHBox, ergebnissBtn);
        vBox.setStyle("-fx-background-color:100,100,100");

        //vBox.setStyle("-fx-background-color: red");
        vBox.setSpacing(25);
        vBox.setLayoutX(50);
        vBox.setLayoutY(25);

        mainPane.getChildren().addAll(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
