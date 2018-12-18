package com.example.monu.khattoproject.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class KhattoDB extends SQLiteOpenHelper {
    public  static  int DB_VERSION=1;
    public  static  String DATBASE_NAME="khatto";
    public  static  String TABLE_NAME="khattoTable";
    public  static  String KEY_ID="id";
    public  static  String ITEM_NAME="itemName";
    public  static  String ITEM_PRICE="itemPrice";
    public  static  String FAVOURITE_STATUS="fStatus";
    private static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + KEY_ID + " integer primary key autoincrement," +ITEM_NAME+ " TEXT,"
            + ITEM_PRICE +" TEXT,"+ FAVOURITE_STATUS+" TEXT)";
    public KhattoDB(Context context) {
        super(context, DATBASE_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public  String  insertIntoTheDatabase(String item_name,String item_price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(ITEM_NAME,item_name);
        cv.put(ITEM_PRICE,item_price);
        cv.put(FAVOURITE_STATUS,"0");
        Long  l =db.insert(TABLE_NAME,null,cv);
        if (l>-1){
            return "INSERTED INTO THE DATABASE";
        }else {
            return "SORRY";
        }
    }

    public  Cursor  read_all_data(){
        SQLiteDatabase db=this.getReadableDatabase();
        String sql="SELECT * FROM "+TABLE_NAME+"";
        Cursor cursor= db.rawQuery(sql,null,null);
        return cursor;
    }

    public  void  set_fav(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        String sql="UPDATE "+TABLE_NAME+" SET  "+FAVOURITE_STATUS+" ='1' WHERE "+KEY_ID+"="+id+"";
        db.execSQL(sql);
    }
    public  void  remove_fav(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        String sql="UPDATE "+TABLE_NAME+" SET  "+FAVOURITE_STATUS+" ='0' WHERE "+KEY_ID+"="+id+"";
        db.execSQL(sql);
    }

    public  Cursor  select_all_favorite_list(){
        SQLiteDatabase db=this.getReadableDatabase();
        String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+FAVOURITE_STATUS+" ='1'";
        Cursor cursor= db.rawQuery(sql,null,null);
        return cursor;
    }


}
