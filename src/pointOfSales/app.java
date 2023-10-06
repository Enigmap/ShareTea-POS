package pointOfSales;

import javafx.application.Application;

import javafx.stage.Stage;

import javafx.scene.image.Image;

public class app extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        
        primaryStage.setTitle("Sharetea Point of Sales System");
        sceneController sceneCtrl = new sceneController(primaryStage);
        loginPage login = new loginPage(sceneCtrl);
        sceneCtrl.changeScene(login.getScene());
        
        //Setting Window Icon will get better if changed to platform specific icons
        Image icon = new Image(getClass().getResourceAsStream("images/sharetea_icon.png"));
        primaryStage.getIcons().add(icon);
        
        //primaryStage.setScene(new Scene(root, 1440, 720));

       
        primaryStage.setFullScreen(true);

        // Set the brick wall image to always be 1/3 of the screen width
        
        
        

        primaryStage.show();

        //New Code for changing Scenes
        

    }

  
    public static void main(String[] args) {
        launch(args);
    }
}
