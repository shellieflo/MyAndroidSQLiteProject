package ie.gmit.shellieflo.womansapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.sql.SQLException;

public class FoodTrackerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_tracker);
        init();
    }

    private void init() {

        View saveButton = findViewById(R.id.SaveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText breakfastTxt = (EditText) findViewById(R.id.txtBreakfast);
                EditText lunchTxt = (EditText) findViewById(R.id.txtLunch);
                EditText dinnerTxt = (EditText) findViewById(R.id.txtDinner);
                EditText snacksTxt = (EditText) findViewById(R.id.txtSnacks);

                FoodTracker food = new FoodTracker();
                food.setBreakfast(breakfastTxt.getText().toString());
                food.setLunch(lunchTxt.getText().toString());
                food.setDinner(dinnerTxt.getText().toString());
                food.setSnacks(snacksTxt.getText().toString());

                SQLiteFoodDatabaseHelper databaseHelper = null;
                try {
                    databaseHelper = new SQLiteFoodDatabaseHelper(FoodTrackerActivity.this.getApplicationContext());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                databaseHelper.insertFood(food);
               Intent a = new Intent(FoodTrackerActivity.this.getApplicationContext(), ViewFood.class);
                startActivity(a);

            }
        });
    }
}





//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.food_tracker, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                // This is called when the Home (Up) button is pressed
//                // in the Action Bar.
//                Intent parentActivityIntent = new Intent(this, MainActivity.class);
//                parentActivityIntent.addFlags(
//                        Intent.FLAG_ACTIVITY_CLEAR_TOP |
//                                Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(parentActivityIntent);
//                finish();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//
//
//}
