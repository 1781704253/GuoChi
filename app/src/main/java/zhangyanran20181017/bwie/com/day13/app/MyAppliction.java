package zhangyanran20181017.bwie.com.day13.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by 匹诺曹 on 2018/10/17.
 */

public class MyAppliction extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
