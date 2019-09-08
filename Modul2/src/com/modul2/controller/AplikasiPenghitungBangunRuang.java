package com.modul2.controller;

import com.sun.prism.paint.Color;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.*;
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
    float lengthval, widthval, radval, heightval, area, vol, perimeter;
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
    }

    public void squareOpt(ActionEvent actionEvent) {
        lengthField.setEditable(true);
        lengthField.setStyle("-fx-background-color: white;");
        widthField.setEditable(true);
        widthField.setStyle("-fx-background-color: white;");
        radField.setEditable(false);
        radField.setStyle("-fx-background-color: grey;");
        heightField.setEditable(false);
        heightField.setStyle("-fx-background-color: grey;");
        widthField.setText("");
        lengthField.setText("");
        heightField.setText("");
        radField.setText("");
    }

    public void calculateOpt(ActionEvent actionEvent) {
        nf.setMaximumFractionDigits(2);
        if (radField.isEditable()) {
            if (radField.getText().isEmpty()) {
                alert.setTitle("Message");
                alert.setHeaderText("Message");
                alert.setContentText("Input numbers");
                alert.showAndWait();
            }
            else {
                radval = Float.parseFloat(radField.getText());
                alert.setTitle("Message");
                alert.setHeaderText("Message");
                alert.setContentText("Surface Area : " + nf.format(calculateBallArea(radval)) + ", Volume : " + nf.format(calculateBallVolume(radval)));
                alert.showAndWait();
            }
        }
        else if (widthField.isEditable() && lengthField.isEditable()) {
            if (widthField.getText().isEmpty() && lengthField.getText().isEmpty()) {
                alert.setTitle("Message");
                alert.setHeaderText("Message");
                alert.setContentText("Input numbers");
                alert.showAndWait();
            }
            else {
                lengthval = Float.parseFloat(lengthField.getText());
                widthval = Float.parseFloat(widthField.getText());
                alert.setTitle("Message");
                alert.setHeaderText("Message");
                alert.setContentText("Surface Area : " + nf.format(calculateSquareArea(lengthval, widthval)) + ", Perimeter : " + nf.format(calculateSquarePerimeter(lengthval, widthval)));
                alert.showAndWait();
            }

        }
        else if (radField.isEditable() && heightField.isEditable()) {
            if (radField.getText().isEmpty() & heightField.getText().isEmpty()) {
                alert.setTitle("Message");
                alert.setHeaderText("Message");
                alert.setContentText("Input numbers");
                alert.showAndWait();
            }
            else {
                radval = Float.parseFloat(radField.getText());
                heightval = Float.parseFloat(heightField.getText());
                alert.setTitle("Message");
                alert.setHeaderText("Message");
                alert.setContentText("Surface Area : " + nf.format(calculateTubeArea(radval,heightval)) + ", Volume : " + nf.format(calculateTubeVolume(radval,heightval)));
                alert.showAndWait();
            }
        }
        else {
            alert.setTitle("Message");
            alert.setHeaderText("Message");
            alert.setContentText("No input");
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

    /**
     *
     * @param radius jari-jari lingkaran
     * @return luas lingkaran
     */
    public float calculateBallArea(float radius) {
        area = (float) (4 * Math.PI * Math.pow(radius,2));
        return area;
    }

    /**
     *
     * @param radius jari-jari tabung
     * @param height tinggi tabung
     * @return luas tabung
     */
    public float calculateTubeArea(float radius, float height) {
        area = (float) (2 * Math.PI * radius*(radius+height));
        return area;
    }

    /**
     *
     * @param length panjang persegi
     * @param width lebar persegi
     * @return luas persegi
     */
    public float calculateSquareArea(float length, float width) {
        area = length * width;
        return area;
    }

    /**
     *
     * @param radius jari-jari tabung
     * @return volume tabung
     */
    public float calculateBallVolume(float radius) {
        vol = (float) ((4.0 / 3.0) * Math.PI * Math.pow(radius,3));
        return vol;
    }

    /**
     *
     * @param radius jari-jari tabung
     * @param height tinggi tabung
     * @return volume tabung
     */
    public float calculateTubeVolume(float radius, float height) {
        vol = (float) (Math.PI * radius * radius * height);
        return vol;
    }

    /**
     *
     * @param length panjang persegi
     * @param width lebar persegi
     * @return keliling persegi
     */
    public float calculateSquarePerimeter(float length, float width) {
        perimeter = 2*(length+width);
        return perimeter;
    }


}
