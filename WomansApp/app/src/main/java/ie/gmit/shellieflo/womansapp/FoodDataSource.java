package ie.gmit.shellieflo.womansapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FoodDataSource {

    private SQLiteDatabase database;
    private SQLiteFoodDatabaseHelper databaseHelper;
    private String[] allColumns = { SQLiteFoodDatabaseHelper.COLUMN_ID,SQLiteFoodDatabaseHelper.COLUMN_BREAKFAST,
            SQLiteFoodDatabaseHelper.COLUMN_LUNCH,SQLiteFoodDatabaseHelper.COLUMN_DINNER,
            SQLiteFoodDatabaseHelper.COLUMN_SNACKS };

    public FoodDataSource(Context context) throws SQLException {
        databaseHelper = new SQLiteFoodDatabaseHelper(context);
    }


    public void open() throws SQLException {
        database = databaseHelper.getWritableDatabase();
    }



    public FoodTracker createFoodTracker(FoodTracker food)
    {
        ContentValues values = new ContentValues();
        values.put("breakfast", food.getBreakfast());
        values.put("lunch", food.getLunch());
        values.put("dinner", food.getDinner());
        values.put("extras", food.getSnacks());
        long insertId = database.insert(SQLiteFoodDatabaseHelper.TABLE_FOODS, null,
                values);
        Cursor cursor = database.query(SQLiteFoodDatabaseHelper.TABLE_FOODS,
                allColumns, SQLiteFoodDatabaseHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        FoodTracker newFoodTracker = cursorToFoodTracker(cursor);
        cursor.close();
        return newFoodTracker;
    }



    private FoodTracker cursorToFoodTracker(Cursor cursor) {
        FoodTracker food = new FoodTracker();
        food.setId(cursor.getLong(0));
        food.setBreakfast(cursor.getString(1));
        food.setLunch(cursor.getString(2));
        food.setDinner(cursor.getString(3));
        food.setSnacks(cursor.getString(4));
        cursor.close();
        return food;
    }


    public void deleteFoodTracker(FoodTracker food) {
        long id = food.getId();
        System.out.println("food deleted with id: " + id);
        database.delete(SQLiteFoodDatabaseHelper.TABLE_FOODS, SQLiteFoodDatabaseHelper.COLUMN_ID
                + " = " + id, null);
    }
    public void deleteAll() {
        database.delete("FoodTracker", null, null);
    }


    public List<FoodTracker> getFoods(){
        List<FoodTracker> foods = new ArrayList<>();
        Cursor cursor = database.query(SQLiteFoodDatabaseHelper.TABLE_FOODS,
                allColumns, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                FoodTracker food = new FoodTracker();
                food.setBreakfast(cursor.getString(1));
                food.setDinner(cursor.getString(2));
                food.setLunch(cursor.getString(3));
                food.setSnacks(cursor.getString(4));
                foods.add(food);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return foods;
    }

}
