package com.dlsc.preferencesfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppStarter extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    RootPaneI18n rootPane = new RootPaneI18n();
    Scene myScene = new Scene(rootPane);

    primaryStage.setTitle("PreferencesFx Demo");
    primaryStage.setScene(myScene);
    primaryStage.setWidth(1000);
    primaryStage.setHeight(700);
    primaryStage.show();
    primaryStage.centerOnScreen();
  }
}