package Model;

import Model.FamiliaFXML.FXML1280x1024;
import Model.FamiliaFXML.FXML1360x765;
import Model.FamiliaFXML.FXML1920x1080;
import Model.FamiliaFXML.FamilyFXML;
import UI.InputNormal.InputNormalView;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.util.prefs.Preferences;

public class GestorScenas
{
    private static FamilyFXML familyFXML;

    private static Stage stageApp;

    private static Preferences preferenciasDeUsuario = Preferences.userNodeForPackage(GestorScenas.class);



    public static FamilyFXML getFamily()
    {
        if(familyFXML == null)
        {
            buscarFamily();
        }

        return familyFXML;
    }

    public static Stage getStageApp() {
        return stageApp;
    }

    public static void setStageApp(Stage newStageApp) {
        stageApp = newStageApp;
    }




    private static void buscarFamily()
    {
        Dimension screenSeize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSeize.getWidth();
        double height = screenSeize.getHeight();

        if (width > 1440.0 && height > 900.0)
        {
            familyFXML = new FXML1920x1080(840, 1545, 840, 1545, 840, 1545);
        }
        else if (width > 1360.0 && height > 765.0)
        {
            //familyFXML = new FXML1440x900() Decidir Numeros de Pantalla
        }
        else if (width > 1280.0 && height > 1024.0)
        {
            familyFXML = new FXML1360x765(600,1250,600,1250,600,1250);
        }
        else if (width > 1024.0 && height > 798.0)
        {
            familyFXML = new FXML1280x1024(750, 1125, 750, 1125, 750, 1125);
        }
        else
        {
            //familyFXML = FXML1024x798() Decidir Numeros de Pantalla
        }
    }



    public static void show(Parent parent)
    {
        setSceneAppStage(parent);
        stageApp.show();
    }

    private static void setSceneAppStage(Parent parent) { stageApp.setScene(new Scene(parent)); }



    public static Stage createStage(int maxHeight, int maxWidth, int minHeight, int minWidth, int height, int width)
    {
        Stage stage = new Stage();

        stage.setMaxHeight(maxHeight);
        stage.setMaxWidth(maxWidth);
        stage.setMinHeight(minHeight);
        stage.setMinWidth(minWidth);
        stage.setHeight(height);
        stage.setWidth(width);

        return stage;
    }



    public static void configStageApp(int maxHeight, int maxWidth, int minHeight, int minWidth, int height, int width)
    {
        stageApp.setMaxHeight(maxHeight);
        stageApp.setMaxWidth(maxWidth);
        stageApp.setMinHeight(minHeight);
        stageApp.setMinWidth(minWidth);
        stageApp.setHeight(height);
        stageApp.setWidth(width);
    }

    public static Preferences getPreferenciasDeUsuario(){

        return preferenciasDeUsuario;

    }
}
