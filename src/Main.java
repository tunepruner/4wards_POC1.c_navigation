import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tabpopulators.DashboardTabPopulaters;
import tabpopulators.PlanTabPopulaters;

import java.io.IOException;


public class Main extends Application {

    static ObservableList<Topic> topics = FXCollections.observableArrayList();
    TabPane tabPane = new TabPane();
    Tab dashboardTab = new Tab("Dashboard");
    Tab planTab = new Tab("Plan");

    @Override
    public void start(Stage primaryStage)throws IOException{

        StackPane root = new StackPane();

        tabPane.getTabs().add(DashboardTabPopulaters.dashboardTabPopulater(dashboardTab));
        tabPane.getTabs().add(PlanTabPopulaters.PlanTabPopulater(planTab));
        dashboardTab.setClosable(false);
        planTab.setClosable(false);

        root.getChildren().add(tabPane);

        primaryStage.show();


        root.setMinSize(800, 400);
        primaryStage.setX(200);
        primaryStage.setY(150);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }
    public static void main(String[]args){
        launch(args);
    }


}