package com.example.quran_app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{

    public static final String AYA_ID = "AyaID";
//    public static final String ARABIC_TEXT = "ArabicText";
//    public static final String FATEH_TRANS = "FatehMuhammadJalandhri";
//    public static final String MOHSIN_TRANS = "DrMohsinKhan";

    // database Path
    private static String DB_PATH = "src/main/assets/databases/";

    // database Name
    private static final String DATABASE_NAME = "quran.sqlite";

    // database Version
    private static final int DATABASE_VERSION = 1;

    // Table Name of Database
    static final String TABLE_NAME = "tayah";

    public Context context;
    static SQLiteDatabase sqliteDataBase;



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // No need to write the create table query.
        // As we are using Pre built data base.
        // Which is ReadOnly.
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // No need to write the update table query.
        // As we are using Pre built data base.
        // Which is ReadOnly.
        // We should not update it as requirements of application.
    }



//    Constructor ---> takes reference of context to access application assets and resources

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null ,DATABASE_VERSION);
        this.context = context;
    }

    /**  Creating an empty database on the system so that I can rewrite it with my own database.
      By calling this method and empty database will be created into the default system path
      of my application so we are gonna be able to overwrite that database with our database.
      */
    public void createDataBase() throws IOException{
        //check if the database exists
        boolean databaseExist = checkDataBase();

        if(databaseExist){
            // Do Nothing.
        }else{
            this.getWritableDatabase();
            copyDataBase();
        }// end if else dbExist
    } // end createDataBase().

    /** Checking whether the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    public boolean checkDataBase(){
        File databaseFile = new File(DB_PATH + DATABASE_NAME);
        return databaseFile.exists();
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transferring byte stream.
     * */
    private void copyDataBase() throws IOException {
        //Open your local db as the input stream
        InputStream myInput = context.getAssets().open(DATABASE_NAME);
        // Path to the just created empty db
        String outFileName = DB_PATH + DATABASE_NAME;
        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);
        //transfer bytes from the input file to the output file
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
    //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }


    /**
     * This method opens the data base connection.
     * First it create the path up till data base of the device.
     * Then create connection with data base.
     */
    public void openDataBase() throws SQLException{
        //Open the database
        String myPath = DB_PATH + DATABASE_NAME;
        sqliteDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    /**
     * This Method is used to close the data base connection.
     */
    @Override
    public synchronized void close() {
        if(sqliteDataBase != null)
            sqliteDataBase.close();
        super.close();
    }
    /**
     * Apply your methods and class to fetch data using raw or queries on data base using
     * following demo example code as:
     */

    public String getQuranData(String searchID) {
        String result = "";
        String query = "SELECT TABLE_NAME.ArabicText,TABLE_NAME.FatehMuhammadJalandhri,TABLE_NAME.DrMohsinKhan FROM "+TABLE_NAME+"WHERE "+AYA_ID+" ='"+searchID;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            String result_0 = cursor.getString(0);
            String result_1 = cursor.getString(1);
            String result_2 = cursor.getString(2);
            result += String.valueOf(result_0) + " " + result_1 + System.getProperty("line.separator") + result_2;
        }
        cursor.close();
        db.close();
        if(result.equals(""))
            result="No Record Found";
        return result;
    }

}

