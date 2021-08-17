package com.example.businessapp2;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseHelper2 extends SQLiteOpenHelper {

    public DatabaseHelper2( Context context) {
        super(context, "ProjectDatabase.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("CREATE TABLE Projectdetails(name TEXT primary key, priority TEXT, status TEXT, deadline TEXT, cost TEXT, deliverable TEXT, description TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS Projectdetails");
    }
    public Boolean insertProjectDetails(String name, String status, String priority, String deadline, String deliverable, String cost, String description){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("status", status);
        contentValues.put("priority", priority);
        contentValues.put("deadline", deadline);
        contentValues.put("deliverable", deliverable);
        contentValues.put("cost", cost);
        contentValues.put("description", description);
        long result = database.insert("Projectdetails", null, contentValues);
        if (result == -1){
            return false;
        }
        else return true;
    }
    public Boolean updateProjectDetails(String name, String status, String priority, String deadline, String deliverable, String cost, String description){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", status);
        contentValues.put("priority", priority);
        contentValues.put("deadline", deadline);
        contentValues.put("deliverable", deliverable);
        contentValues.put("cost", cost);
        contentValues.put("description", description);
        Cursor cursor = database.rawQuery("SELECT * FROM Projectdetails WHERE name =?", new String[]{name});
        if (cursor.getCount()>0){


            long result = database.update("Projectdetails", contentValues, "name=?", new String[]{name});
            if (result == -1){
                return false;
            }
            else{
                return true;
            }
        }else {
            return false;
        }
    }
    public  Boolean checkProjectName(String name){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM Projectdetails WHERE name=?", new String[]{name});
        if (cursor.getCount()>0)
            return false;
        else return true;
    }
    public Boolean deleteProject(String name){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM Projectdetails WHERE name =?", new String[]{name});
        if (cursor.getCount()>0){


            long result = database.delete("Projectdetails", "name=?", new String[]{name});
            if (result == -1){
                return false;
            }
            else{
                return true;
            }
        }else {
            return false;
        }
    }
    public Cursor getdata(){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM Projectdetails", null);
        return cursor;
    }
}
