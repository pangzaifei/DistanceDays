package com.adups.distancedays.base;

import android.app.Application;
import android.content.Context;

import com.adups.distancedays.BuildConfig;
import com.adups.distancedays.manager.AppShareManager;
import com.adups.distancedays.utils.AppRunningStatusCallbacks;
import com.adups.distancedays.utils.CommonUtil;
import com.common.adlib.base.HandlerManager;
import com.squareup.leakcanary.LeakCanary;

/**
 * Custom application.
 * <p>
 * Created by Chang.Xiao on 2019/10/11.
 *
 * @version 1.0
 */
public class DaysApplication extends Application {

    private static final String TAG = "QuickFrame";

    public static Context mAppInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppInstance = getApplicationContext();
        CommonUtil.init(this, BuildConfig.DEBUG);
        HandlerManager.init(this);
        registerActivityLifecycleCallbacks(new AppRunningStatusCallbacks());
        AppShareManager.init();
        LeakCanary.install(this);
    }

    public static final Context getMyApplicationContext() {
        return mAppInstance;
    }
}
