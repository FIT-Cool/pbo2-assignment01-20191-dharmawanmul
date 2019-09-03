package com.modul1.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class RockPaperScissorForm {

    public ImageView img1;
    public ImageView img2;
    public TextField winCount;
    public TextField drawCount;
    public TextField loseCount;
    Image rockimage = new Image("rock.jpg");
    Image paperimage = new Image("paper.jpg");
    Image scissorsimage = new Image("scissors.jpg");
    ImageView imageView = new ImageView();
    int lose, draw, win;
    Random random = new Random();
    String userChoice;
    String comChoice;

    public void pilihanComputer() {
        int random1 = random.nextInt(3);
        if (random1 == 1) {
            img2.setImage(rockimage);
            comChoice = "batu";
        }
        else if (random1 == 2) {
            img2.setImage(paperimage);
            comChoice = "kertas";
        }
        else {
            img2.setImage(scissorsimage);
            comChoice = "gunting";
        }
    }

    public void matchResults() {
        if (userChoice.equals("kertas") && comChoice.equals("gunting") || userChoice.equals("gunting") && comChoice.equals("batu") || userChoice.equals("batu") && comChoice.equals("kertas")) {
            lose += 1;
            loseCount.setText(Integer.toString(lose));
        }
        else if (userChoice.equals("batu") && comChoice.equals("gunting") || userChoice.equals("kertas") && comChoice.equals("batu") || userChoice.equals("gunting") && comChoice.equals("kertas")) {
            win += 1;
            winCount.setText(Integer.toString(win));
        }
        else if (userChoice.equals("kertas") && comChoice.equals("kertas") || userChoice.equals("gunting") && comChoice.equals("gunting") || userChoice.equals("batu") && comChoice.equals("batu")) {
            draw += 1;
            drawCount.setText(Integer.toString(draw));
        }
    }

    public void choosePaper(ActionEvent actionEvent) {
        userChoice = "kertas";
        pilihanComputer();
        img1.setImage(paperimage);
        img1.setFitHeight(269);
        img1.setFitWidth(150);
        matchResults();
    }

    public void chooseRock(ActionEvent actionEvent) {
        userChoice = "batu";
        pilihanComputer();
        img1.setImage(rockimage);
        img1.setFitHeight(269);
        img1.setFitWidth(150);
        matchResults();
    }

    public void chooseScissors(ActionEvent actionEvent) {
        userChoice = "gunting";
        pilihanComputer();
        img1.setImage(scissorsimage);
        img1.setFitHeight(269);
        img1.setFitWidth(150);
        matchResults();
    }

    public void ExitProg(ActionEvent actionEvent) {
        Platform.exit();
    }
}
