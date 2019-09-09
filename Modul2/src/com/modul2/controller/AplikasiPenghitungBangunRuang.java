package com.modul2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

public class AplikasiPenghitungBangunRuang implements Initializable{
    public Button submitBtn;
    public Button tubeBtn;
    public Button ballBtn;
    public Button squareBtn;
    public TextField lengthField;
    public TextField widthField;
    public TextField radField;
    public TextField heightField;
    public String opt;
    public int lengthVal, widthVal, radVal, heightVal;
    NumberFormat nf = NumberFormat.getInstance();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        disableAllButton();
    }

    public void ballOpt(ActionEvent actionEvent) {
        radField.setEditable(true);
        radField.setStyle("-fx-background-color: white;");
        widthField.setEditable(false);
        widthField.setStyle("-fx-background-color: grey;");
        lengthField.setEditable(false);
        lengthField.setStyle("-fx-background-color: grey;");
        heightField.setEditable(false);
        heightField.setStyle("-fx-background-color: grey;");
        widthField.setText("");
        lengthField.setText("");
        heightField.setText("");
        radField.setText("");
        opt = "ball";
    }

    public void tubeOpt(ActionEvent actionEvent) {
        radField.setEditable(true);
        radField.setStyle("-fx-background-color: white;");
        heightField.setEditable(true);
        heightField.setStyle("-fx-background-color: white;");
        widthField.setEditable(false);
        widthField.setStyle("-fx-background-color: grey;");
        lengthField.setEditable(false);
        lengthField.setStyle("-fx-background-color: grey;");
        widthField.setText("");
        lengthField.setText("");
        heightField.setText("");
        radField.setText("");
        opt = "tube";
    }

    public void squareOpt(ActionEvent actionEvent) {
        lengthField.setEditable(false);
        lengthField.setStyle("-fx-background-color: grey;");
        widthField.setEditable(true);
        widthField.setStyle("-fx-background-color: white;");
        radField.setEditable(false);
        radField.setStyle("-fx-background-color: grey;");
        heightField.setEditable(true);
        heightField.setStyle("-fx-background-color: white;");
        widthField.setText("");
        lengthField.setText("");
        heightField.setText("");
        radField.setText("");
        opt = "square";
    }

    public void calculateOpt(ActionEvent actionEvent) {
        /*lengthVal = Integer.parseInt(lengthField.getText());*/
        nf.setMaximumFractionDigits(2);
        if (opt.equals("ball")) {
            radVal = Integer.parseInt(radField.getText());
            alert.setTitle("Message");
            alert.setHeaderText("Message");
            alert.setContentText("Surface Area : " + nf.format((4*Math.PI*Math.pow(radVal,2))) + ", Volume : " + nf.format((4.0 / 3.0 * Math.PI*Math.pow(radVal,3))));
            alert.showAndWait();
        } else if (opt.equals("tube")) {
            radVal = Integer.parseInt(radField.getText());
            heightVal = Integer.parseInt(heightField.getText());
            alert.setTitle("Message");
            alert.setHeaderText("Message");
            alert.setContentText("Surface Area : " + nf.format((2*Math.PI*radVal*(radVal+heightVal))) + ", Volume : " + nf.format(Math.PI*Math.pow(radVal,2)*heightVal));
            alert.showAndWait();
        } else {
            widthVal = Integer.parseInt(widthField.getText());
            heightVal = Integer.parseInt(heightField.getText());
            alert.setTitle("Message");
            alert.setHeaderText("Message");
            alert.setContentText("Surface Area : " + (widthVal*heightVal) + ", Perimeter : " + (2*(heightVal+widthVal)));
            alert.showAndWait();
        }
    }

    public void disableAllButton() {
        lengthField.setEditable(false);
        widthField.setEditable(false);
        radField.setEditable(false);
        heightField.setEditable(false);
        lengthField.setStyle("-fx-background-color: grey;");
        widthField.setStyle("-fx-background-color: grey;");
        radField.setStyle("-fx-background-color: grey;");
        heightField.setStyle("-fx-background-color: grey;");
    }
}
