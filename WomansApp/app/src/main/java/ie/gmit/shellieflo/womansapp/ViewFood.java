package ie.gmit.shellieflo.womansapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import java.sql.SQLException;
import java.util.List;


public class ViewFood extends ListActivity implements OnClickListener {
    private ArrayAdapter<FoodTracker> listAdapter;
    private FoodDataSource fooddatasource;
    private SQLiteFoodDatabaseHelper databaseHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_view);

        try {
            fooddatasource = new FoodDataSource(this);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            fooddatasource.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<FoodTracker> values = fooddatasource.getFoods();

        // use an array adapter to show the
        // elements in a ListView
        ArrayAdapter<FoodTracker> adapter = new ArrayAdapter<FoodTracker>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);

        values = fooddatasource.getFoods();
    }


    @Override
    public void onClick(View v) {
//delete button here
    }
}





