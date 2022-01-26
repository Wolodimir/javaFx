package com.example.javafx;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static Sphere[] spheres = new Sphere[1000];
    public static double WIDTH = 1400;
    public static double HEIGHT = 800;

    @Override
    public void start(Stage stage) throws IOException {
        Group group = new Group();

        Camera camera = new PerspectiveCamera(true);
        camera.translateXProperty().set(0);
        camera.translateYProperty().set(0);
        camera.translateZProperty().set(-500);
        camera.setNearClip(1);
        camera.setFarClip(10000);

        Scene scene = new Scene(group, WIDTH, HEIGHT);
        scene.setCamera(camera);
        int camSpeed = 10;
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case RIGHT:
                        scene.getCamera().setTranslateX(camera.getTranslateX() + camSpeed);
                        break;
                    case LEFT:
                        scene.getCamera().setTranslateX(camera.getTranslateX() - camSpeed);
                        break;
                    case UP:
                        scene.getCamera().setTranslateY(camera.getTranslateY() - camSpeed);
                        break;
                    case DOWN:
                        scene.getCamera().setTranslateY(camera.getTranslateY() + camSpeed);
                        break;
                    case S:
                        scene.getCamera().setRotationAxis(new Point3D(1, 0, 0));
                        scene.getCamera().setRotate(scene.getCamera().getRotate() + 5);
                        break;
                    case W:
                        scene.getCamera().setRotationAxis(new Point3D(1, 0, 0));
                        scene.getCamera().setRotate(scene.getCamera().getRotate() - 5);
                        break;

                }
            }
        });


        int iter = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    Sphere sphere = new Sphere(2);
                    sphere.setMaterial(new PhongMaterial(Color.RED));
                    sphere.translateXProperty().set(((i + 1) * 2.469197806149681E-9 / 10) / 1.1 * 10E10);
                    sphere.translateYProperty().set(((j + 1) * 2.469197806149681E-9 / 10) / 1.1 * 10E10);
                    sphere.translateZProperty().set(((k + 1) * 2.469197806149681E-9 / 10) / 1.1 * 10E10);
                    spheres[iter] = sphere;
                    //System.out.println("номер --- " + iter + "     значение   " + particles[iter].x + "      " + particles[iter].y + "      " + particles[iter].z);
                    iter++;
                }
            }
        }
        group.getChildren().addAll(spheres);


        stage.setTitle("Diplom");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}