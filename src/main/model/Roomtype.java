package main.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Gize on 4/19/2017.
 */
public class Roomtype {
    private  StringProperty code;
    private  StringProperty description;
    private  IntegerProperty maxQuest;

    public Roomtype(String code, String description, Integer maxQuest) {
        this.code = new SimpleStringProperty(code);
        this.description = new SimpleStringProperty(description);
        this.maxQuest = new SimpleIntegerProperty(maxQuest);
    }

    public String getCode() {
        return code.get();
    }

    public StringProperty codeProperty() {
        return code;
    }

    public void setCode(String code) {
        this.code.set(code);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public int getMaxQuest() {
        return maxQuest.get();
    }

    public IntegerProperty maxQuestProperty() {
        return maxQuest;
    }

    public void setMaxQuest(int maxQuest) {
        this.maxQuest.set(maxQuest);
    }
}
