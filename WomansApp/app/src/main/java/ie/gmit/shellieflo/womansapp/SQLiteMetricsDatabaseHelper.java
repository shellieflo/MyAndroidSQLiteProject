package ie.gmit.shellieflo.womansapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SQLiteMetricsDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "myMetrics";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_METRICS = "metrics";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "_name";
    public static final String COLUMN_WEIGHT = "_weight";
    public static final String COLUMN_HEIGHT = "_height";
    public static final String COLUMN_AGE = "_age";
    public static final String COLUMN_WAIST = "_waist";
    public static final String COLUMN_HIPS = "_hips";
    public static final String COLUMN_BMI = "_bmi";
    public static final String COLUMN_LEAN = "_lean";
    public static final String COLUMN_FAT = "_fat";
    public static final String COLUMN_RATIO = "_ratio";

    private SQLiteDatabase database;

    public SQLiteMetricsDatabaseHelper(Context context)//constructor
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String DATABASE_CREATE =
            "CREATE TABLE metrics " + "(" + COLUMN_ID + "_id integer primary key autoincrement, " +
                    COLUMN_NAME + "text not null" + COLUMN_WEIGHT + "real" + COLUMN_HEIGHT + "real" + COLUMN_AGE + "Integer" +
                    COLUMN_WAIST + "real" + COLUMN_HIPS + "real" + COLUMN_BMI+ "real" +COLUMN_LEAN + "real" +
             COLUMN_FAT + "real" + COLUMN_RATIO + "real" + ")";

    private String[] allColumns = {SQLiteMetricsDatabaseHelper.COLUMN_ID,
            COLUMN_NAME, COLUMN_WEIGHT, COLUMN_HEIGHT, COLUMN_AGE, COLUMN_WAIST,COLUMN_HIPS,COLUMN_BMI,COLUMN_FAT,COLUMN_LEAN,COLUMN_RATIO};



    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);//sql query to create the metrics table
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        Log.w(SQLiteMetricsDatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_METRICS);
        onCreate(database);
    }

    public void addBodyMetric(BodyMetrics bodyMetric) {
        database = getWritableDatabase();
        ContentValues values = new ContentValues();
//        long insertId = database.insert(TABLE_METRICS, null,
//                values);
        values.put(COLUMN_NAME, bodyMetric.getName());
        values.put(COLUMN_WEIGHT, bodyMetric.getWeight());
        values.put(COLUMN_HEIGHT, bodyMetric.getHeight());
        values.put(COLUMN_AGE, bodyMetric.getAge());
        values.put(COLUMN_WAIST, bodyMetric.getWaist());
        values.put(COLUMN_HIPS, bodyMetric.getHips());
        values.put(COLUMN_BMI, bodyMetric.getBmi());
        values.put(COLUMN_FAT, bodyMetric.getBodyfat());
        values.put(COLUMN_LEAN, bodyMetric.getLeanMass());
        values.put(COLUMN_RATIO, bodyMetric.getRatio());
        database.insert(TABLE_METRICS, null, values);
        database.close();
    }


    private static BodyMetrics cursorToBodyMetrics(Cursor cursor) {
        BodyMetrics bodyMetric = new BodyMetrics(cursor.getLong(0), cursor.getString(1), cursor.getDouble(2), cursor.getDouble(3), Integer.parseInt(cursor.getString(4)), cursor.getDouble(5), cursor.getDouble(6), cursor.getDouble(7), cursor.getDouble(8), cursor.getDouble(9), cursor.getDouble(10));
        bodyMetric.setId(cursor.getLong(0));
        bodyMetric.setName(cursor.getString(1));
        bodyMetric.setWeight(Double.parseDouble(cursor.getString(2)));
        bodyMetric.setHeight(Double.parseDouble(cursor.getString(3)));
        bodyMetric.setAge(Integer.parseInt(cursor.getString(4)));
        bodyMetric.setWaist(Double.parseDouble(cursor.getString(5)));
        bodyMetric.setHips(Double.parseDouble(cursor.getString(6)));
        bodyMetric.setBmi(Double.parseDouble(cursor.getString(7)));
        bodyMetric.setBodyfat(cursor.getString(8));
        bodyMetric.setLeanMass(Double.parseDouble(cursor.getString(9)));
        bodyMetric.setRatio(Double.parseDouble(cursor.getString(10)));
        return bodyMetric;
    }

    public BodyMetrics getBodyMetric(long id) {
        Cursor cursor = database.query(TABLE_METRICS, new String[]{COLUMN_ID, COLUMN_NAME, COLUMN_WEIGHT,
                COLUMN_HEIGHT, COLUMN_AGE, COLUMN_WAIST, COLUMN_HIPS, COLUMN_BMI,COLUMN_FAT,COLUMN_LEAN,COLUMN_RATIO}, COLUMN_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        BodyMetrics bodyMetric = new BodyMetrics(cursor.getLong(0), cursor.getString(1),
                cursor.getDouble(2), cursor.getDouble(3), Integer.parseInt(cursor.getString(4)), cursor.getDouble(5), cursor.getDouble(6),cursor.getDouble(7),cursor.getDouble(8),cursor.getDouble(9),cursor.getDouble(10));
        database.close();
        cursor.close();
        return bodyMetric;
    }

   public void deleteBodyMetric(BodyMetrics bodyMetric) {
       long id = bodyMetric.getId();
       System.out.println("BodyMetrics deleted with id: " + id);
       database.delete(TABLE_METRICS, SQLiteMetricsDatabaseHelper.COLUMN_ID
               + " = " + id, null);
   }

    public List<BodyMetrics> getAllBodyMetrics() throws SQLException //list of all bodymetrics
    {
        List<BodyMetrics> bodyMetricsList = new ArrayList<>();
       // Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_METRICS, null);
        Cursor cursor = database.query(TABLE_METRICS,
               new String[]{ COLUMN_ID, COLUMN_NAME,COLUMN_WEIGHT, COLUMN_HEIGHT, COLUMN_AGE, COLUMN_WAIST, COLUMN_HIPS}, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            BodyMetrics bodyMetric = cursorToBodyMetrics(cursor);
            bodyMetricsList.add(bodyMetric);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return bodyMetricsList;
    }

    public int updateBodyMetric(BodyMetrics bodyMetric) throws SQLException {
        database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, bodyMetric.getName());
        values.put(COLUMN_WEIGHT, bodyMetric.getWeight());
        values.put(COLUMN_HEIGHT, bodyMetric.getHeight());
        values.put(COLUMN_AGE, bodyMetric.getAge());
        values.put(COLUMN_WAIST, bodyMetric.getWaist());
        values.put(COLUMN_HIPS, bodyMetric.getHips());
        values.put(COLUMN_BMI,bodyMetric.getbmi());
        values.put(COLUMN_FAT,bodyMetric.getBodyfat());
        values.put(COLUMN_LEAN,bodyMetric.getLeanMass());
        values.put(COLUMN_RATIO,bodyMetric.getRatio());
        int numOfrows =  database.update("TABLE_METRICS", values, COLUMN_ID + " =? ", new String[]{String.valueOf(bodyMetric.getId())});
        database.close();
        return numOfrows;//number of rows affected by update
    }


    public int getBodyMetricCount() throws SQLException//get the number of entries in your BodyMetrics table
    {
        Cursor cursor = database.rawQuery("Select * from" + TABLE_METRICS, null);
        int count = cursor.getCount();
        database.close();
        cursor.close();
        return count;
    }
}







