package com.example.demoapplication.permission;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

/**
 * Created by Administrator on 2017/11/8 0008.
 */

public class AskForPermissionUtil {
    /**
     * 被拒绝并且不再提醒,提示用户去设置界面重新打开权限
     */
    public static void AskForPermission(final Context context, String notice) {
        new QMUIDialog.MessageDialogBuilder(context)
                .setTitle("提示")
                .setMessage(notice)
                .addAction("取消", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                    }
                })
                .addAction("设置", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        intent.setData(Uri.parse("package:" + context.getPackageName())); // 根据包名打开对应的设置界面
                        context.startActivity(intent);
                    }
                })
                .show();
    }
}
