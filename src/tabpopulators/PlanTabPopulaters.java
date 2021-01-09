package tabpopulators;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class PlanTabPopulaters {
    public static Tab PlanTabPopulater(Tab tab){
        startPopulator(tab);
        return tab;
    }

    public static void startPopulator (Tab tab){
        VBox level1vBox = new VBox();
        HBox level2hBox = new HBox();
        Button newAddBtn = new Button("Add new day");
        Button templateAddBtn = new Button("Add day from template");

        newAddBtn.setOnAction(event -> {
            addDayPopulater(tab);
        });
        templateAddBtn.setOnAction(event -> {
            chooseDayPopulater(tab);
        });

        level1vBox.getChildren().add(level2hBox);
        level2hBox.getChildren().addAll(newAddBtn, templateAddBtn);
        tab.setContent(level1vBox);

    }
    private static void addDayPopulater(Tab tab){
        VBox level1vBox = new VBox();
        HBox level2hBox = new HBox();
        DatePicker datePicker = new DatePicker();
        Button backBtn = new Button("Back");

        datePicker.setOnAction(event -> {
            dayPlanPopulator(tab);
        });
        backBtn.setOnAction(event -> {
            startPopulator(tab);
        });

        level1vBox.getChildren().add(level2hBox);
        level2hBox.getChildren().addAll(backBtn, datePicker);
        tab.setContent(level1vBox);
    }
    private static void chooseDayPopulater(Tab tab){
        VBox level1vBox = new VBox();
        ListView pastDaysListView = new ListView();
        level1vBox.getChildren().add(pastDaysListView);
        tab.setContent(level1vBox);
    }
    private static void dayPlanPopulator(Tab tab){
        Button backBtn = new Button("Back");

        StackPane root = new StackPane();
        VBox level1vBox = new VBox();
        HBox level2hBox = new HBox();
        ListView activityImportLV = new ListView();
        ListView activityPlanLV = new ListView();
        ListView activityTypeLV = new ListView();
        ObservableList<String> activityImportList = FXCollections.observableArrayList();
        ObservableList<String> activityPlanList = FXCollections.observableArrayList();
        ObservableList<String> activityTypeList = FXCollections.observableArrayList();

        activityImportList.addAll("JavaFX", "Core Java");
        activityPlanList.addAll("SQL", "Algebra");
        activityTypeList.addAll("Add Activity", "Add Break", "Add Excluded Block");
        activityImportLV.setItems(activityImportList);
        activityPlanLV.setItems(activityPlanList);
        activityTypeLV.setItems(activityTypeList);
        activityTypeLV.setCellFactory(param -> {
            ActivityTypeCell activityTypeCell = null;
            try {
                activityTypeCell = new ActivityTypeCell(activityTypeList);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return activityTypeCell;
        });
        activityImportLV.setCellFactory(param -> {
            ActivityImportCell activityImportCell = null;
            try {
                activityImportCell = new ActivityImportCell(activityImportList);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return activityImportCell;
        });
        activityImportLV.setFocusTraversable(false);

        activityPlanLV.setCellFactory(param -> {
            ActivityPlanCell activityPlanCell = null;
            try {
                activityPlanCell = new ActivityPlanCell(activityPlanList);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return activityPlanCell;
        });
        backBtn.setOnAction(event -> {
            addDayPopulater(tab);
        });

        root.getChildren().add(level1vBox);
        level1vBox.getChildren().addAll(level2hBox, activityTypeLV);
        level2hBox.getChildren().addAll(backBtn, activityImportLV, activityPlanLV);

        tab.setContent(root);

    }

}
