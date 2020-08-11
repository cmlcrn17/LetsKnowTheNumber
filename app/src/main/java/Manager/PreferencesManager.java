package Manager;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesManager {

    private static final String PREF_NAME = "com.letsknowthenumber.PREFMANAGER";
    private static final String KEY_USERNAME = "username";

    private static PreferencesManager sInstance;
    private final SharedPreferences mPref;

    public PreferencesManager(Context context) {
        mPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized void initializeInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PreferencesManager(context);
        }
    }

    public static synchronized PreferencesManager getInstance() {
        if (sInstance == null) {
            throw new IllegalStateException(PreferencesManager.class.getSimpleName() +
                    " is not initialized, call initializeInstance(..) method first.");
        }
        return sInstance;
    }

    public void setUserName(String value) {
        mPref.edit().putString(KEY_USERNAME, value).commit();
    }

    public String getUserName() {
        return mPref.getString(KEY_USERNAME, "");
    }

    public void remove(String key) {
        mPref.edit().remove(key).commit();
    }

    public boolean clear() {
        return mPref.edit().clear().commit();
    }
}
