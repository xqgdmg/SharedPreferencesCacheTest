package com.example.thinkpad.sharedpreferencescachetest;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author: star
 * @time: 2016/7/11 13:10
 * @description: 多用户sharePreferences工具类
 */
public class SharedPreferencesUtil<T> {
    final String shared_pre_data = "shared_pre_data";
    private SharedPreferences sp = null;

    public SharedPreferencesUtil(Context context) {
        sp = context.getSharedPreferences(shared_pre_data, Context.MODE_PRIVATE);
    }

    public void setSharedString(String key, String value) {
        sp.edit().putString(MD5Util.string2MD5(key), value).commit();
    }

    public String getSharedString(String key) {
        return sp.getString(MD5Util.string2MD5(key), "");
    }

    public String getSharedString(String key, String value) {
        return sp.getString(MD5Util.string2MD5(key), value);
    }

    public void setSharedList(String key, List<T> list){
        if (list!=null && !list.isEmpty()){
            sp.edit().putString(key,new Gson().toJson(list));
        }

    }

    public List<T> getSharedList(String key) {
        String str=sp.getString(MD5Util.string2MD5(key), "");
        if (!TextUtils.isEmpty(str)){
            Type type = new TypeToken<List<T>>(){}.getType();
            List<T> list= new Gson().fromJson(str, type);
            return list;
        }
        return null;
    }

    public void setSharedInt(String key, int value) {
        sp.edit().putInt(MD5Util.string2MD5(key), value).commit();
    }

    public int getSharedInt(String key) {
        return sp.getInt(MD5Util.string2MD5(key), 0);
    }

    public int getSharedInt(String key, int value) {
        return sp.getInt(MD5Util.string2MD5(key), value);
    }

    public void setSharedBoolean(String key, boolean value) {
        sp.edit().putBoolean(MD5Util.string2MD5(key), value).commit();
    }

    public boolean getSharedBoolean(String key) {
        return sp.getBoolean(MD5Util.string2MD5(key), false);
    }

    public boolean getSharedBoolean(String key, boolean value) {
        return sp.getBoolean(MD5Util.string2MD5(key), value);
    }

    public void setSharedLong(String key, long value) {
        sp.edit().putLong(MD5Util.string2MD5(key), value).commit();
    }

    public long getSharedLong(String key) {
        return sp.getLong(MD5Util.string2MD5(key), 0);
    }

    public long getSharedLong(String key, long value) {
        return sp.getLong(MD5Util.string2MD5(key), value);
    }

    public void setSharedFloat(String key, float value) {
        sp.edit().putFloat(MD5Util.string2MD5(key), value).commit();
    }

    public float getSharedFloat(String key) {
        return sp.getFloat(MD5Util.string2MD5(key), 0);
    }

    public float getSharedFloat(String key, float value) {
        return sp.getFloat(MD5Util.string2MD5(key), value);
    }

    public void removeSharedKey(String key) {
        sp.edit().remove(MD5Util.string2MD5(key)).commit();
    }

}
