package comic_practice.mycomic.Dao;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * 作者：Administrator Sulei 2017/2/21 15:37
 * <p/>
 * 邮箱：211779494@qq.com
 */
public class Sqlite extends SQLiteOpenHelper {
    public Sqlite(Context context,String name) {
        super(context, name, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table book(_id Integer primary key   autoincrement ,name varchar(20) ,url varchar(20),type varchar(20) )");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
