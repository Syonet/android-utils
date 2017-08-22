package br.com.syonet.androidutils;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.inputmethod.InputMethodManager;

/**
 * Classe utilitária para teclado
 * </p>
 * Created by Eduardo Herzer on 22/08/17.
 */

public class KeyboardUtils {
    /**
     * Método responsável por esconder o teclado virtual
     *
     * @param activity {@link Activity}
     */
    public static void hideSoftKeyboard(Activity activity) {
        if (activity != null && activity.getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    /**
     * Método responsável por esconder o teclado virtual de uma view
     */
    public static void hideSoftKeyboard(Context context, IBinder windowToken) {
        if (context != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        }
    }
}
