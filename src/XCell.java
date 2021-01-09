import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

import java.io.IOException;
import java.text.ParseException;

public class XCell extends ListCell<String> {
	HBox hbox = new HBox();
	Pane pane = new Pane();
	Button startSelectorButton = new Button();
	Button stopSelectorButton = new Button();
	Button durationButton = new Button();
	Label lbl = new Label();
	String lastItem;

	public XCell(ObservableList listA) throws IOException {
		ListCell thisCell = this;
		lbl.setText(lastItem);
		hbox.getChildren().addAll(pane, startSelectorButton, lbl, stopSelectorButton, durationButton);
		HBox.setHgrow(pane, Priority.ALWAYS);
		hbox.setSpacing(15);
		hbox.setAlignment(Pos.CENTER_LEFT);
		startSelectorButton.setOnAction(event1 -> {
			TextField topicTitleField = new TextField();
			hbox.getChildren().remove(startSelectorButton);
			hbox.getChildren().add(0, topicTitleField);
			topicTitleField.requestFocus();
			topicTitleField.setOnAction(event2 -> {
				hbox.getChildren().remove(topicTitleField);
				hbox.getChildren().add(0,startSelectorButton);
				/*This is an attempt at finding a Day object in the list called "days",
				and changing its "startTime" field to a new value.



				*/
//				Day.days.get(Day.days.stream().anyMatch(o -> o.startTime.equals()))
			});
		});


	}

	@Override
	protected void updateItem (String item,boolean empty){
		super.updateItem(item, empty);
		setText(null);  // No text in label of super class

		if (empty) {
				lastItem = null;
				setGraphic(null);

		} else if (item.contains("Drop here")) {
			lastItem = item;
			lbl.setText(item != null ? item : "<null>");
			setGraphic(hbox);
			hbox.setVisible(false);
		} else {
			lastItem = item;
			lbl.setText(item != null ? item : "<null>");
			setGraphic(hbox);
			hbox.setVisible(true);
		}
	}
}
