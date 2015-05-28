package ie.gmit.shellieflo.womansapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.sql.SQLException;

public class SQLiteFoodDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "FoodTracker";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_FOODS = "foods";
    public static final String COLUMN_ID = "_id";
    //public static final String COLUMN_DATETIME = "_DateTime";
    public static final String COLUMN_BREAKFAST = "_breakfast";
    public static final String COLUMN_LUNCH = "_lunch";
    public static final String COLUMN_DINNER = "_dinner";
    public static final String COLUMN_SNACKS = "_snacks";

    private String[] allColumns = {COLUMN_ID,COLUMN_BREAKFAST,COLUMN_LUNCH,COLUMN_DINNER,COLUMN_SNACKS};


    private SQLiteDatabase database;

    public SQLiteFoodDatabaseHelper(Context context) throws SQLException {//constructor for the helper class
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase database) {//create the foods table
        database.execSQL( "CREATE TABLE_FOODS (" + COLUMN_ID + "_id integer primary key autoincrement, " +
                COLUMN_BREAKFAST + "text not null" + COLUMN_LUNCH + "text not null" +
                COLUMN_DINNER + "text not null" +
                COLUMN_SNACKS + "text not null");
    }

    public void open() throws SQLException {
        database = getWritableDatabase();
    }
    public void read() throws SQLException {
        database = getReadableDatabase();
    }
    public void close() {
        database.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        Log.w(SQLiteFoodDatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_FOODS);//delete the table
        onCreate(database);
    }

    public void insertFood(FoodTracker food) {
        ContentValues values = new ContentValues();
        values.put("breakfast", food.getBreakfast());
        values.put("lunch", food.getLunch());
        values.put("dinner", food.getDinner());
        values.put("extras", food.getSnacks());
        database.insert("food", null, values);
    }
}
//    public void delete(FoodTracker food) {
//        database.execSQL("delete from FoodTracker where='" + food.getBreakfast() + food.getLunch() + food.getDinner() +food.getSnacks());
//    }




