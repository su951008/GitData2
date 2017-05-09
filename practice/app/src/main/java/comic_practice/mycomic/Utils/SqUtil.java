package comic_practice.mycomic.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import comic_practice.mycomic.Dao.BookList;
import comic_practice.mycomic.Dao.Sqlite;

/**
 * 作者：Administrator Sulei 2017/2/21 15:52
 * <p/>
 * 邮箱：211779494@qq.com
 */
public class SqUtil   {


    private final SQLiteDatabase database;

    public SqUtil(Context con,String name) {

        if("book".equals(name)){
            Sqlite  sq = new Sqlite(con,name);
            database = sq.getWritableDatabase();
        }else {
            BookList book = new BookList(con, name);
            database = book.getWritableDatabase();
        }

    }

    public void update(String name,  ContentValues values,String whereClause, String[] whereArgs) {

        database.update(name,   values,whereClause,whereArgs);
    }

    public Cursor select(String sql, String[] selectionArgs)  {
       return  database.rawQuery(sql, selectionArgs);
    }


    public int  delete(String table, String whereClause, String[] whereArgs) {
        int  delete = database.delete(table, whereClause, whereArgs);
        return delete;
    }

    public void insert(String table,  ContentValues values)
    {
        database.insert(table,null,values);
    }

}
