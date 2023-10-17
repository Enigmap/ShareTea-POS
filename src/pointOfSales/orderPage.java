package pointOfSales;

import javafx.scene.Scene;
// import javafx.stage.Screen;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;

/**
 * The orderPage class is the UI class for the checkoutPage.
 * This class loads all the UI elements and modifies them a bit.
 * 
 * @author Sam Trythall
 * @version v0.0.3
 * @since v0.0.2
 */

public class orderPage {

    private static sceneController controller;

    public orderPage() {
    }

    public static void setController(sceneController ctrl) {
        controller = ctrl;
    }

    public static Scene getScene() {

        try {
            FXMLLoader loader = new FXMLLoader(orderPage.class.getResource("designFiles/cashier.fxml"));
            Parent root2 = loader.load();
            // double screenWidth = Screen.getPrimary().getBounds().getWidth();
            // double screenHeight = Screen.getPrimary().getBounds().getHeight();
            Scene cashierOrderScene = new Scene(root2, 1280, 720);
            orderPageController orderCtrl = loader.getController();
            orderCtrl.setController(controller);
            return cashierOrderScene;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
