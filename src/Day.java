/*
public class Day {
    String date;
    long startTime;
    long endTime;

    //will be synced:
    static ObservableList<Day> days = FXCollections.observableArrayList();
    List<PlannedItem> plannedEventsInstance = new ArrayList<PlannedItem>();
    List<PlannedItem> clockedEventsInstance = new ArrayList<PlannedItem>();

    //for temporary utility and will never be synced:
    static ObservableList<PlannedItem> plannedItems = FXCollections.observableArrayList();
    static ObservableList<ClockedEvent> clockedEvents = FXCollections.observableArrayList();
    static ObservableList<String> dayPlanStrings = FXCollections.observableArrayList();
    static ObservableList<String> dayPlanStarts = FXCollections.observableArrayList();
    static ObservableList<String> dayPlanDurations = FXCollections.observableArrayList();
    static ListView dayPlanLV = new ListView();

    public static HBox dayPlanPopulate(HBox dayPlanToPopulate) {
        //later this will be behind a button handler
        Day currentDay = new Day();
        days.add(currentDay);


//        days.get(days.indexOf(searchForDay("boom"))).setDate("Boom");

        Button addNewTopicBtn = new Button("Add Topic");
        HBox dayPlanPopulated = new HBox();
        VBox leftColumn = new VBox();
        TextField startTimePicker = new TextField("Start Time");
        TextField endTimePicker = new TextField("End Time");

        leftColumn.setMaxWidth(200);
        leftColumn.setMinWidth(200);

        dayPlanLV.setItems(dayPlanStrings);
        dayPlanLV.setCellFactory(param -> {
            XCell xcell = null;
            try {
                xcell = new XCell(dayPlanStrings);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return xcell;
        });

        dayPlanToPopulate.getChildren().add(leftColumn);
        dayPlanToPopulate.getChildren().add(dayPlanLV);
        leftColumn.getChildren().add(addNewTopicBtn);


        addNewTopicBtn.setOnAction(event -> {
            TextField topicTitleField = new TextField();
            Button okButton = new Button("Ok");
            leftColumn.getChildren().remove(addNewTopicBtn);
            leftColumn.getChildren().add(0, topicTitleField);
            leftColumn.getChildren().add(1, okButton);
            topicTitleField.requestFocus();
            topicTitleField.setOnAction(event1 -> {
                try {
                    addTopicInstance(topicTitleField.getText(), currentDay);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                leftColumn.getChildren().remove(topicTitleField);
                leftColumn.getChildren().remove(okButton);
                leftColumn.getChildren().add(addNewTopicBtn);
                stringListMaker(plannedItems);
            });
            okButton.setOnAction(event1 -> {
                try {
                    addTopicInstance(topicTitleField.getText(), currentDay);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                leftColumn.getChildren().remove(topicTitleField);
                leftColumn.getChildren().remove(okButton);
                leftColumn.getChildren().add(addNewTopicBtn);
                stringListMaker(plannedItems);
            });
        });
        dayPlanPopulated = dayPlanToPopulate;
        return dayPlanPopulated;
    }
    public static void addTopicInstance(String nameOfTopic, Day currentDay) throws ParseException {
        //create topic
        Topic newTopic = new Topic();
        newTopic.name = nameOfTopic;
        Main.topics.add(newTopic);

        //Now create the instance of that topic for the timeline
        PlannedItem newTopicInstance = new PlannedItem();
        newTopicInstance.name = nameOfTopic;
        newTopicInstance.startTime = 0;
        currentDay.plannedItems.add(newTopicInstance);

    }



        public static void stringListMaker (ObservableList <PlannedItem> listToParse) {
            dayPlanStrings.clear();
            dayPlanStarts.clear();
            dayPlanDurations.clear();
            for (int i = 0; i < listToParse.size(); i++) {
                dayPlanStrings.add(listToParse.get(i).name);
                dayPlanStarts.add(Long.toString(listToParse.get(i).startTime));
                dayPlanDurations.add(Long.toString(listToParse.get(i).duration));
            }
        }
    }
*/

