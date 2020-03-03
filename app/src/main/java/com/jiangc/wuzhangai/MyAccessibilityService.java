package com.jiangc.wuzhangai;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;

public class MyAccessibilityService extends AccessibilityService {
    private static final String TAG = "MyAccessibilityService";

    @Override
    protected boolean onKeyEvent(KeyEvent event) {
        Log.e(TAG, "onKeyEvent:" + event.getKeyCode());
        int key = event.getKeyCode();

        switch(key){
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                Log.e(TAG, "onKeyEvent: " + event.getKeyCode() );
                break;
            case KeyEvent.KEYCODE_VOLUME_UP:
                break;
            default:
                break;
        }
        return super.onKeyEvent(event);
    }

    @Override
    public void onInterrupt() {

    }

    @Override
    public void onCreate() {
        Log.i(TAG, "RobMoney::onCreate");
        super.onCreate();
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        // TODO Auto-generated method stub

    }
}
