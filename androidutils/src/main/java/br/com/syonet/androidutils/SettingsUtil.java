package br.com.syonet.androidutils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

/**
 * Classe utilitária para configirações
 * <p></p>
 * Created by Eduardo Herzer on 22/08/17.
 */

public class SettingsUtil {
    /**
     * Abre tela do SO de permissões do aplicativo
     *
     * @param activity {@link Activity}
     */
    public static void openAppSettings(Activity activity) {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
        intent.setData(uri);
        activity.startActivity(intent);
    }
}
