package ie.gmit.shellieflo.womansapp;

import java.io.Serializable;

/**
 * Created by shellieflo on 26/05/2015.
 */
public class FoodTracker implements Serializable {

    private static final long serialVersionUID = 1L;
    //private Integer DateTime;
    private long id;
    private String Breakfast;
    private String Lunch;
    private String Dinner;
    private String Snacks;

    public FoodTracker() {
        super();
    }


    public FoodTracker(long id, String Breakfast, String Lunch, String Dinner, String Snacks) {
        super();
        this.id = id;
        this.Breakfast = Breakfast;
        this.Lunch = Lunch;
        this.Dinner = Dinner;
        this.Snacks = Snacks;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBreakfast(String breakfast) {
        Breakfast = breakfast;
    }

    public String getBreakfast() {
        return Breakfast;
    }
    public String getDinner() {
        return Dinner;
    }

    public void setDinner(String dinner) {
        Dinner = dinner;
    }

    public String getSnacks() {
        return Snacks;
    }

    public void setSnacks(String snacks) {
        Snacks = snacks;
    }

    public String getLunch() {

        return Lunch;
    }

    public void setLunch(String lunch) {
        Lunch = lunch;
    }
}
