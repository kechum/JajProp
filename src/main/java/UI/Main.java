package UI;

import Model.GestorScenas;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application
{

    public static void main(String...args){
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {

       primaryStage.setTitle("Test MMPI 2");

        try {
            new Bootstrap().iniciarObjetos();
        } catch (IOException e) {
            e.printStackTrace();
        }

        GestorScenas.setStageApp(primaryStage);


        GestorScenas.getFamily().showListaAspirantes();

    }


}
