package ca.homedepot.homedepot;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/* DATABASE IS CREATED WHEN THE PROGRAM IS FIRST RUN */
public class Database extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "HDDatabase.db";
    private static final int DATABASE_VERSION = 2;

    public Database(Context context) {
        super(context, DATABASE_NAME, context.getExternalFilesDir(null).getAbsolutePath(), null, DATABASE_VERSION);
//
//          super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Cursor getEmployees() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"0 _id", "email", "points"};
        String sqlTables = "leaderboard";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, null);

        c.moveToFirst();
        return c;

    }
    // SQL Queries
}
