package samuel.example.com.yelpchallengeappp;

import android.app.Application;
import android.content.Context;

/**
 * Created by samuel on 6/15/2017.
 */


public class BaseApplication extends Application {
    private static Context context = null;
    private static BaseApplication application = null;


    @Override
    public void onCreate(){
        super.onCreate();
        context = getApplicationContext();

        application = this;


    }


    public static Context getContext(){
        return context;
    }



    static public BaseApplication getApplication(){
        return application;
    }
}
