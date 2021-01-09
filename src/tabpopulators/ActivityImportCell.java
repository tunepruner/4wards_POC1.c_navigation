package tabpopulators;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

import java.io.IOException;

public class ActivityImportCell extends ListCell<String> {
    private HBox hbox = new HBox();
    private Pane pane = new Pane();
    private Button removeButton = new Button("remove");
    private Button startButton = new Button("start");
    private Button stopButton = new Button("stop");
    private Label lbl = new Label();
    private String lastItem;

    public ActivityImportCell (ObservableList listA) throws IOException {
        ListCell thisCell = this;
        lbl.setText(lastItem);
        hbox.getChildren().addAll(lbl, pane, startButton, stopButton, removeButton);
        HBox.setHgrow(pane, Priority.ALWAYS);
        hbox.setSpacing(15);
        hbox.setAlignment(Pos.CENTER_LEFT);

        setOnDragDetected(event -> {
            if (getItem() == null) {
                return;
            }

            Dragboard dragboard = startDragAndDrop(TransferMode.COPY);
            ClipboardContent content = new ClipboardContent();

            content.putString(getItem());

            dragboard.setDragView((this.snapshot(null, null)));
            dragboard.setDragViewOffsetX(300);

            dragboard.setContent(content);

            event.consume();
        });

        setOnDragDone(DragEvent::consume);

    }


    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        setText(null);  // No text in label of super class

        if(empty) {
            lastItem = null;
            setGraphic(null);

        }else if (item.contains("Drop here")) {
            lastItem = item;
            lbl.setText(item != null ? item : "<null>");
            setGraphic(hbox);
            hbox.setVisible(false);
        }else{
            lastItem = item;
            lbl.setText(item != null ? item : "<null>");
            setGraphic(hbox);
            hbox.setVisible(true);
        }
    }
}

