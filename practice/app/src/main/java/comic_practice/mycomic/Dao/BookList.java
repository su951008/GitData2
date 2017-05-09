package comic_practice.mycomic.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 作者：Administrator Sulei 2017/2/21 15:37
 * <p/>
 * 邮箱：211779494@qq.com
 */
public class BookList extends SQLiteOpenHelper {
    public BookList(Context context, String name) {
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {//这个是
        db.execSQL("create table booklist(_id Integer primary key   autoincrement ,name varchar(20) ,url varchar(20) ,position Integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
