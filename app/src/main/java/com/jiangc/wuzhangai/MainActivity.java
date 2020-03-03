package com.jiangc.wuzhangai;

import androidx.appcompat.app.AppCompatActivity;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.accessibility.AccessibilityManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private AccessibilityManager mAccessibilityManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAccessibilityManager = (AccessibilityManager) getSystemService(Context.ACCESSIBILITY_SERVICE);
        if (!checkAccessibilityEnabled("wuzhangai"))
        {
            Log.e(TAG, "onCreate: 没有开启");
            Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }else
        {
            Log.e(TAG, "onCreate: 已开启");
        }

    }

    /**
     * Check当前辅助服务是否启用
     *
     * @param serviceName serviceName
     * @return 是否启用
     */
    private boolean checkAccessibilityEnabled(String serviceName) {
        List<AccessibilityServiceInfo> accessibilityServices =
                mAccessibilityManager.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_GENERIC);
        for (AccessibilityServiceInfo info : accessibilityServices) {
            if (info.getId().equals(serviceName)) {
                return true;
            }
        }
        return false;
    }
}
