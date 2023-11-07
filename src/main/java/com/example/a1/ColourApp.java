// NAME: JEET AGRAWAL
// NSID: jea316
// STUDENT ID: 11269096

package com.example.a1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class ColourApp extends Application {
//    @Override

    Color currentColor = Color.BLACK;
    Circle circle = createCircle();
    ColorPalette colorPalette = new ColorPalette();
    Integer index  = 3;


    public void start(Stage stage) throws IOException {
        HBox root = new HBox();
        root.setSpacing(20);
        root.setPadding(new Insets(10, 10 , 10, 10));

// FOR SLIDERS
        // SLIDER 1
        HBox forSlider1 = new HBox(15);
        forSlider1.setPadding(new Insets(10, 10 , 10, 10));

        Label s1t1 = new Label("Red:   ");
        Slider slider1 = new Slider(0,100,50);
        slider1.setMin(0);
        slider1.setMax(255);
        slider1.setValue(0);
        Label s1t2 = new Label("0");

        forSlider1.getChildren().addAll(s1t1,slider1,s1t2);

        // SLIDER 2
        HBox forSlider2 = new HBox(15);
        forSlider2.setPadding(new Insets(10, 10 , 10, 10));

        Label s2t1 = new Label("Green:");
        Slider slider2 = new Slider(0,100,50);
        slider2.setMin(0);
        slider2.setMax(255);
        slider2.setValue(0);
        Label s2t2 = new Label("0");

        forSlider2.getChildren().addAll(s2t1,slider2,s2t2);

        // SLIDER 3
        HBox forSlider3 = new HBox(15);
        forSlider3.setPadding(new Insets(10, 10 , 10, 10));

        Label s3t1 = new Label("Blue:  ");
        Slider slider3 = new Slider(0,100,50);
        slider3.setMin(0);
        slider3.setMax(255);
        slider3.setValue(0);
        Label s3t2 = new Label("0");

        forSlider3.getChildren().addAll(s3t1,slider3,s3t2);


        // EVENT HANDLER FOR SLIDER 1
        slider1.valueProperty().addListener((observableValue, oldVal, newVal) -> {
            // UPDATES LABEL FOR SLIDER 1
            s1t2.setText(String.valueOf(newVal.intValue()));
            currentColor = Color.rgb(Integer.parseInt(s1t2.getText()),Integer.parseInt(s2t2.getText()),Integer.parseInt(s3t2.getText()));
            setColor();
        });

        // EVENT HANDLER FOR SLIDER 2
        slider2.valueProperty().addListener((observableValue, oldVal, newVal) -> {
            // UPDATES LABEL FOR SLIDER 2
            s2t2.setText(String.valueOf(newVal.intValue()));
            currentColor = Color.rgb(Integer.parseInt(s1t2.getText()),Integer.parseInt(s2t2.getText()),Integer.parseInt(s3t2.getText()));
            setColor();
        });

        // EVENT HANDLER FOR SLIDER 3
        slider3.valueProperty().addListener((obs,oldVal,newVal) -> {
            s3t2.setText(String.valueOf(newVal.intValue()));
            currentColor = Color.rgb(Integer.parseInt(s1t2.getText()),Integer.parseInt(s2t2.getText()),Integer.parseInt(s3t2.getText()));
            setColor();
        });

        // END FOR SLIDERS.


        // Add to palette button

        Button addPalette = new Button("Add to Palette");
        addPalette.setPrefWidth(100);

        // CIRCLES THREE
        HBox circles = new HBox();
        circles.setAlignment(Pos.CENTER_LEFT);
        circles.setPadding(new Insets(10 ,10, 10 ,10));

        Circle c1 = new Circle(40, Color.WHITE);
        c1.setStroke(Color.BLACK);

        Circle c2 = new Circle(40, Color.WHITE);
        c2.setStroke(Color.BLACK);

        Circle c3 = new Circle(40,Color.WHITE);
        c3.setStroke(Color.BLACK);

        circles.getChildren().addAll(c1,c2,c3);

        // Event Handling for the add to palette button.
        EventHandler<ActionEvent> paletteColor = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // Updates the colorPalette as per the index specified which is according to the Palette order.
                colorPalette.addColor(currentColor,index%3);
                if (index%3 == 0) c1.setFill(colorPalette.c1);
                else if (index%3 == 1) c2.setFill(colorPalette.c2);
                else if(index%3 == 2) c3.setFill(colorPalette.c3);
                index++;  // Incrementing the index here

            }
        };
        addPalette.setOnAction(paletteColor);


        // Add to List button

        Button addList = new Button("Add to List");
        addList.setPrefWidth(100);

        // VERTICAL BOX LEFT

        VBox leftVertical = new VBox();
        leftVertical.setAlignment(Pos.CENTER);

        leftVertical.getChildren().addAll(circle,forSlider1,forSlider2,forSlider3,addPalette,circles,addList);

        // VERTICAL BOX RIGHT

        VBox rightVertical = new VBox();
        rightVertical.setAlignment(Pos.TOP_CENTER);

        ListView<HBox> listView = new ListView<>();
        listView.setPrefSize(300,500);

        rightVertical.getChildren().add(listView);

        root.getChildren().addAll(leftVertical,rightVertical);

        // EVENT HANDLING FOR THE ADD TO LIST BUTTON.

        EventHandler<ActionEvent> addToList = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                HBox rightCircles = new HBox();
                rightCircles.setAlignment(Pos.CENTER_LEFT);
                rightCircles.setPadding(new Insets(10 ,10, 10 ,10));

                Circle smallCircle1 = new Circle(40);
                smallCircle1.setStroke(Color.BLACK);
                smallCircle1.setFill(colorPalette.c1);

                Circle smallCircle2 = new Circle(40);
                smallCircle2.setStroke(Color.BLACK);
                smallCircle2.setFill(colorPalette.c2);

                Circle smallCircle3 = new Circle(40);
                smallCircle3.setStroke(Color.BLACK);
                smallCircle3.setFill(colorPalette.c3);

                rightCircles.getChildren().addAll(smallCircle1,smallCircle2,smallCircle3);
                listView.getItems().add(rightCircles);
            }
        };
        addList.setOnAction(addToList);

        Scene scene = new Scene(root);

        stage.setTitle("Color Palette");
        stage.setScene(scene);
        stage.show();

    }

    private Circle createCircle(){
        // Circle Class to create a circle
        Circle circle = new Circle();
        circle.setRadius(100);
        return circle;
    }

    public void setColor() {
        this.circle.setFill(currentColor);
    }

    public static void main(String[] args) {
        launch();
    }
}