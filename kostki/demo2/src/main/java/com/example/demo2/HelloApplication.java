package com.example.demo2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GridPane grid = new GridPane();
        GridPane grid2 = new GridPane();
        Label lbl1 = new Label("Ilość kostek do rzucenia ( 3 - 10 ):  ");
        ChoiceBox<Integer> kostki = new ChoiceBox<>();
        Label lblresult = new Label("Wynik: ");
        Button btn = new Button("Rzuć");
        Text result = new Text();
        kostki.getItems().addAll(3, 4, 5, 6, 7, 8, 9, 10);
        kostki.getSelectionModel().select(0);
        grid.add(lbl1, 0, 0);
        grid.add(kostki, 1, 0);
        grid.add(lblresult, 0, 3);
        grid.add(result, 1, 3);
        grid.add(btn, 0, 1);
        Scene scene = new Scene(grid, 300, 250);
        stage.setTitle("Kostki");
        stage.setScene(scene);
        stage.show();

        btn.setOnAction(e -> {
            grid2.getChildren().clear();
            int[] tab = new int[kostki.getSelectionModel().getSelectedItem()];
            Map<Integer, Integer> map = new HashMap<>();
            int suma = 0;
            for (int i = 0; i < tab.length; i++) {
                Random ran = new Random();
                int x = ran.nextInt(6) + 1;
                tab[i] = x;
                map.put(x, map.getOrDefault(x, 0) + 1);
            }


            for (int j = 0; j < tab.length; j++) {
                Text txt1 = new Text("Kostka " + (j + 1) + ": " + tab[j]);
                grid2.add(txt1, 0, j);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() >= 2) {
                    suma += entry.getKey() * entry.getValue();
                }
            }

            result.setText(String.valueOf(suma));
        });
        grid.add(grid2, 0, 2);
    }

    public static void main(String[] args) {
        launch();
    }
}