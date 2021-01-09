package tabpopulators;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

import java.io.IOException;

public class ActivityTypeCell extends ListCell<String> {
    private HBox hbox = new HBox();
    private Label lbl = new Label();
    private String lastItem;

    public ActivityTypeCell (ObservableList listA) throws IOException {
        ListCell thisCell = this;
        lbl.setText(lastItem);
        hbox.getChildren().add(lbl);

    }

    @Override
    protected void updateItem (String item,boolean empty){
        super.updateItem(item, empty);
        setText(null);  // No text in label of super class

        if (empty) {
            lastItem = null;
            setGraphic(null);
        } else {
            lastItem = item;
            setGraphic(hbox);
            lbl.setText(item != null ? item : "<null>");
        }
    }
}

