package lostcon.nssu.example.com.lostcon.common;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePrefUser {

    private static SharePrefUser mInstance;
    private SharedPreferences mSharePrefs;
    private SharedPreferences.Editor mEdit;
    private static final String SHARED_PREFS_FILE_NAME = "User";

    private SharePrefUser(Context context){
        mSharePrefs = context.getSharedPreferences(
                SHARED_PREFS_FILE_NAME,Context.MODE_PRIVATE
        );
        mEdit = mSharePrefs.edit();

    }
    public static SharePrefUser getInstance(Context context){
        if(mInstance == null){
            mInstance = new SharePrefUser(context);
        }
        return mInstance;
    }

    public void setName() {
        mEdit.putString("name", "박윤성");
        mEdit.commit();
    }
    public String getUser(){
        return mSharePrefs.getString("name","null");
    }
}
