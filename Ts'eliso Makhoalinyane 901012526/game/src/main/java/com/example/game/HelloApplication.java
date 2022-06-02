package com.example.game;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {
private Label label = new Label("SCORE : "+0);
private int score;
    @Override
    public void start(Stage stage) throws IOException{
        stage.setTitle("Helicopter game!");
        BorderPane root=new BorderPane();
        Scene scene = new Scene(root,800,600);
        scene.getStylesheets().add("style.css");

        Button btn = new Button("Continue");
        btn.toFront();
        ImageView ship = createShip(scene);
        ImageView cloud=createCloud(scene);
        ImageView leru =createLeru(scene);
        ImageView lik=createLik(scene);
        ImageView molatsi=createMolatsi(scene);
        ImageView coin=createCoin(scene);
        ImageView chen=createChen(scene);
        ImageView five=createFive(scene);

        label.setLayoutX(800);
        label.setLayoutY(600);
        root.getChildren().addAll(label,ship,cloud,coin,leru,lik,molatsi,five,chen,btn);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
                    double x = ship.getX();
                    double y = ship.getY();

                    switch (event.getCode()) {
                        case LEFT -> ship.setX(x -10);
                        case RIGHT -> ship.setX(x +10);
                        case UP -> ship.setY(y - 10);
                        case DOWN -> ship.setY(y + 10);

                    }

                    if (ship.getBoundsInParent().intersects(cloud.getBoundsInParent())||ship.getBoundsInParent().intersects(leru.getBoundsInParent())||ship.getBoundsInParent().intersects(lik.getBoundsInParent())||ship.getBoundsInParent().intersects(molatsi.getBoundsInParent())) {

                        System.out.println("game over");
                        ship.setImage(new Image("game-over-.gif"));

                        scene.addEventFilter(KeyEvent.KEY_PRESSED, event1 -> {
                            double x1 = ship.getX();
                            double y1 = ship.getY();

                            switch (event.getCode()) {
                                case UP -> ship.setY(y - 0);
                                case DOWN -> ship.setY(y + 0);
                                case LEFT -> ship.setX(y -0);
                                case RIGHT -> ship.setX(y +0);

                            }


                        });

                    }
                    if (ship.getBoundsInParent().intersects(coin.getLayoutBounds())||ship.getBoundsInParent().intersects(five.getLayoutBounds())||ship.getBoundsInParent().intersects(chen.getLayoutBounds())){
                        score++;
                        String text="SCORE : ";
                        if (score<10){
                            text=text+"0";
                        }
                        label.setText(text+score);
                    }
                });


        stage.setScene(scene);
        stage.show();
    }
    private ImageView createCloud(Scene scene){
        ImageView cloud = new ImageView(new Image("cloud3.png"));
        cloud.setFitWidth(100);
        cloud.setFitHeight(100);
        cloud.setY(100);
        cloud.setX(1800);
        TranslateTransition c = new TranslateTransition(Duration.millis(12000),cloud);
        c.setByX(-2000);
        c.setCycleCount(Integer.MAX_VALUE);
        c.play();

        return cloud;

    }
    private ImageView createLeru(Scene scene){
        ImageView leru = new ImageView(new Image("leru.png"));
        leru.setFitWidth(100);
        leru.setFitHeight(100);
        leru.setY(500);
        leru.setX(1800);
        TranslateTransition c = new TranslateTransition(Duration.millis(8800),leru);
        c.setByX(-2600);
        c.setCycleCount(Integer.MAX_VALUE);
        c.play();

        return leru;
    }
    private ImageView createLik(Scene scene){
        ImageView lik = new ImageView(new Image("lik.png"));
        lik.setFitWidth(100);
        lik.setFitHeight(100);
        lik.setY(300);
        lik.setX(1800);
        TranslateTransition c = new TranslateTransition(Duration.millis(15000),lik);
        c.setByX(-2200);
        c.setCycleCount(Integer.MAX_VALUE);
        c.play();

        return lik;
    }
    private ImageView createMolatsi(Scene scene){
        ImageView molatsi = new ImageView(new Image("molatsi.png"));
        molatsi.setFitWidth(100);
        molatsi.setFitHeight(100);
        molatsi.setY(300);
        molatsi.setX(1500);
        TranslateTransition c = new TranslateTransition(Duration.millis(7000),molatsi);
        c.setByX(-1800);
        c.setCycleCount(Integer.MAX_VALUE);
        c.play();

        return molatsi;
    }
    private ImageView createCoin(Scene scene){
        ImageView coin = new ImageView(new Image("D.png"));
        coin.setFitWidth(100);
        coin.setFitHeight(100);
        coin.setY(300);
        coin.setX(1500);
        TranslateTransition c = new TranslateTransition(Duration.millis(14000),coin);
        c.setByX(-1800);
        c.setCycleCount(Integer.MAX_VALUE);
        c.play();

        return coin;
    }
    private ImageView createChen(Scene scene){
        ImageView chen = new ImageView(new Image("chen.png"));
        chen.setFitWidth(100);
        chen.setFitHeight(100);
        chen.setY(500);
        chen.setX(1500);
        TranslateTransition c = new TranslateTransition(Duration.millis(6000),chen);
        c.setByX(-1800);
        c.setCycleCount(Integer.MAX_VALUE);
        c.play();

        return chen;
    }
    private ImageView createFive(Scene scene){
        ImageView five = new ImageView(new Image("5.png"));
        five.setFitWidth(100);
        five.setFitHeight(100);
        five.setY(100);
        five.setX(1500);
        TranslateTransition c = new TranslateTransition(Duration.millis(10000),five);
        c.setByX(-1800);
        c.setCycleCount(Integer.MAX_VALUE);
        c.play();

        return five;
    }
    private ImageView createShip(Scene scene) {
        ImageView image = new ImageView(new Image("hill.png"));
        image.setFitWidth(100);
        image.setFitHeight(100);
        image.setY(scene.getHeight() - image.getFitHeight());
        return image;
    }


    public static void main(String[] args) {
        launch();
    }
}