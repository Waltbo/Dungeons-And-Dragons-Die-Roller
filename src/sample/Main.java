package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Main extends Application {
    private class Timer extends AnimationTimer {

        private long previous = 0;


        public void handle(long now) {
            if (now - previous >= 2000000000) {
                previous=now;

            }

        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        ListView historyList = new ListView();
        Button dieFour = new Button("Roll D4");
        Button dieSix = new Button("Roll D6");
        Button dieEight = new Button("Roll D8");
        Button dieTen = new Button("Roll D10");
        Button dieTwelve = new Button("Roll D12");
        Button dieTwenty = new Button("Roll D20");
        ComboBox modifier =new ComboBox();
        for(int i=0;i<21;i++){
            modifier.getItems().addAll(new Integer(i));
        }
        modifier.getSelectionModel().selectFirst();
        Label addToRoll = new Label("Modifier: ");
        Label numberOfRollsLabel = new Label("Times Rolled: ");
        ComboBox numberOfRolls = new ComboBox();
        for(int i=1;i<11;i++){
            numberOfRolls.getItems().addAll(new Integer(i));
        }
        numberOfRolls.getSelectionModel().selectFirst();
        HBox buttonHold = new HBox();
        buttonHold.getChildren().addAll(dieFour, dieSix, dieEight, dieTen, dieTwelve, dieTwenty);
        String hold = "0";
        CircleButton circleButton = new CircleButton(hold);
        BorderPane pane = new BorderPane();
        dieFour.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int hold =((Integer)(numberOfRolls.getSelectionModel().getSelectedItem()));
                String blank="";
                historyList.getItems().add(0,blank);
                for (int i = 0; i <hold;  i++) {
                    Random stuff = new Random();
                    int roll = stuff.nextInt(4) + 1;
                    int modifierRoll=((Integer)(modifier.getSelectionModel().getSelectedItem()))+roll;
                    String holdValue = modifierRoll + "";
                    circleButton.getRoll().setText(holdValue);
                    String historyRoll = "You rolled a "+hold+ "D4 and got a " + roll+"+"+((Integer)(modifier.getSelectionModel().getSelectedItem()))+"="+modifierRoll;
                    historyList.getItems().add(0, historyRoll);


                }

            }
        });
        dieSix.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int hold = ((Integer) (numberOfRolls.getSelectionModel().getSelectedItem()));
                String blank="";
                historyList.getItems().add(0,blank);
                for (int i = 0; i < hold; i++) {
                    Random stuff = new Random();
                    int roll = stuff.nextInt(6) + 1;
                    int modifierRoll=((Integer)(modifier.getSelectionModel().getSelectedItem()))+roll;
                    String holdValue = modifierRoll + "";
                    circleButton.getRoll().setText(holdValue);
                    String historyRoll = "You rolled a "+hold+ "D6 and got a " + roll+"+"+((Integer)(modifier.getSelectionModel().getSelectedItem()))+"="+modifierRoll;
                    historyList.getItems().add(0, historyRoll);
                    Main.Timer time = new Main.Timer();
                    time.start();

                }
            }
        });
        dieEight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int hold = ((Integer) (numberOfRolls.getSelectionModel().getSelectedItem()));
                String blank="";
                historyList.getItems().add(0,blank);
                for (int i = 0; i < hold; i++) {
                    Random stuff = new Random();
                    int roll = stuff.nextInt(8) + 1;
                    int modifierRoll=((Integer)(modifier.getSelectionModel().getSelectedItem()))+roll;
                    String holdValue = modifierRoll + "";
                    circleButton.getRoll().setText(holdValue);
                    String historyRoll = "You rolled a "+hold+ "D8 and got a " + roll+"+"+((Integer)(modifier.getSelectionModel().getSelectedItem()))+"="+modifierRoll;
                    historyList.getItems().add(0, historyRoll);

                }
            }
        });
        dieTen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int hold = ((Integer) (numberOfRolls.getSelectionModel().getSelectedItem()));
                String blank="";
                historyList.getItems().add(0,blank);
                for (int i = 0; i < hold; i++) {
                    Random stuff = new Random();
                    int roll = stuff.nextInt(10) + 1;
                    int modifierRoll=((Integer)(modifier.getSelectionModel().getSelectedItem()))+roll;
                    String holdValue = modifierRoll + "";
                    circleButton.getRoll().setText(holdValue);
                    String historyRoll = "You rolled a "+hold+ "D10 and got a " + roll+"+"+((Integer)(modifier.getSelectionModel().getSelectedItem()))+"="+modifierRoll;
                    historyList.getItems().add(0, historyRoll);

                }
            }
        });
        dieTwelve.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int hold = ((Integer) (numberOfRolls.getSelectionModel().getSelectedItem()));
                String blank="";
                historyList.getItems().add(0,blank);
                for (int i = 0; i < hold; i++) {
                    Random stuff = new Random();
                    int roll = stuff.nextInt(12) + 1;
                    int modifierRoll=((Integer)(modifier.getSelectionModel().getSelectedItem()))+roll;
                    String holdValue = modifierRoll + "";
                    circleButton.getRoll().setText(holdValue);
                    String historyRoll = "You rolled a "+hold+ "D12 and got a " + roll+"+"+((Integer)(modifier.getSelectionModel().getSelectedItem()))+"="+modifierRoll;
                    historyList.getItems().add(0, historyRoll);

                }
            }
        });
        dieTwenty.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int hold = ((Integer) (numberOfRolls.getSelectionModel().getSelectedItem()));
                String blank="";
                historyList.getItems().add(0,blank);
                for (int i = 0; i < hold; i++) {
                    Random stuff = new Random();
                    int roll = stuff.nextInt(20) + 1;
                    int rollAndModifier=roll+((Integer)(modifier.getSelectionModel().getSelectedItem()));
                    String holdValue = rollAndModifier + "";
                    circleButton.getRoll().setText(holdValue);
                    if (roll == 20) {
                        String historyRoll = "Nice Roll, Critical Hit: " + rollAndModifier;
                        historyList.getItems().add(0, historyRoll);
                    } else if(roll==1){
                        String historyRoll = "Well Dang, Critical Fail: " + rollAndModifier;
                        historyList.getItems().add(0, historyRoll);
                    }else {
                        String historyRoll = "You rolled a "+hold+ "D20 and got a " + roll+"+"+((Integer)(modifier.getSelectionModel().getSelectedItem()))+"="+rollAndModifier;
                        historyList.getItems().add(0, historyRoll);
                    }

                }
            }
        });
        pane.setCenter(circleButton);
        pane.setBottom(buttonHold);
        BorderPane holdALl = new BorderPane();
        holdALl.setCenter(pane);
        historyList.setMaxHeight(100);
        BorderPane holdHistoryAndSelect= new BorderPane();
        HBox rollsStuff=new HBox();
        rollsStuff.getChildren().addAll(numberOfRollsLabel, numberOfRolls);
        HBox modifierStuff =new HBox();
        modifierStuff.getChildren().addAll(addToRoll, modifier);
        HBox rollsAndModifiers=new HBox(105);
        rollsAndModifiers.getChildren().addAll(rollsStuff,modifierStuff);
        holdHistoryAndSelect.setTop(rollsAndModifiers);
        holdHistoryAndSelect.setBottom(historyList);
        holdALl.setBottom(holdHistoryAndSelect);

        pane.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #14b5ce, #0705a8)");

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Die Roller");

        primaryStage.setScene(new Scene(holdALl, 348, 375));
        primaryStage.show();





    }
}
