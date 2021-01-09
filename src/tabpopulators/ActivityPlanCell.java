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
import java.util.Date;

public class ActivityPlanCell extends ListCell<String> {
    HBox hbox = new HBox();
    Pane pane = new Pane();
    Button removeButton = new Button("remove");
    Button startButton = new Button("start");
    Button stopButton = new Button("stop");
    Label lbl = new Label();
    String lastItem;

    public ActivityPlanCell (ObservableList listA) throws IOException {
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

            Dragboard dragboard = startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();

            content.putString(getItem());

            dragboard.setDragView((this.snapshot(null, null)));
            dragboard.setDragViewOffsetX(300);

            dragboard.setContent(content);

            event.consume();
        });

        setOnDragOver(event -> {
            getListView().getSelectionModel().clearSelection();

            if (event.getGestureSource() != thisCell &&
                    event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);

                event.consume();
            }});



        setOnDragEntered(event -> {

            Dragboard db = event.getDragboard();


            listA.remove(db.getString());
            if (listA.contains("Drop here")){
                listA.remove(listA.indexOf("Drop here"));
            }

            if (db.hasString()) {
                ObservableList<String> items = getListView().getItems();
                int thisIdx = items.indexOf(getItem());

                if (!listA.contains(db.getString()) && !db.getString().contains("Drop here")) {
                    if (thisIdx == -1 && listA.size() == 0) {
                        listA.add(0, db.getString());
                    } else if (listA.size() == 0) {
                        listA.add(0, db.getString());
                    } else if (thisIdx == -1) {
                        listA.add(listA.size(), db.getString());
                    } else
                        listA.add(thisIdx, db.getString());
                    hbox.setVisible(false);
                }}});

        setOnDragExited(event -> {
                    if (listA.isEmpty()) {
                        listA.add("Drop here");
                    }

            hbox.setVisible(true);
        });

        setOnDragDropped(event -> {

            boolean success = false;
            hbox.setVisible(true);
//                if (!list.contains(db.getString())&& event.getDragboard().hasString()) {
//                    list.add(list.indexOf(getItem()), db.getString());
//                }

            success = true;
            event.setDropCompleted(success);

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

