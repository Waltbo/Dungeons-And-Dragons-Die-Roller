package sample;

import javafx.animation.FillTransition;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.util.Duration;

import static javafx.animation.Animation.INDEFINITE;

public class CircleButton extends StackPane {
    private Label roll;
    private Circle circle;

    public CircleButton() {
        roll = new Label("0");
        roll.setFont(new Font("Arial", 90));
        roll.setTextFill(Color.WHITE);
        circle = new Circle(90);

        FillTransition ft = new FillTransition(Duration.millis(3000), circle, Color.GREEN, Color.LIGHTSEAGREEN);
       ft.setCycleCount(INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();
        //circle.setFill(Color.GREEN);
        this.getChildren().addAll(circle, roll);
        circle.setStroke(Color.BLACK);
    }

    public CircleButton(String val) {
        this();
        roll.setText(val);
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Label getRoll() {
        return roll;
    }

    public void setRoll(Label roll) {
        this.roll = roll;
    }

    public Paint getColor() {
        return circle.getFill();
    }

    public void setColor(Paint color) {
        circle.setFill(color);
    }

    public String getValue() {
        return roll.getText();
    }

}

