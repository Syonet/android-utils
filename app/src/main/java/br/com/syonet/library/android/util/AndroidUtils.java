package br.com.syonet.library.android.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.provider.Settings;
import android.view.inputmethod.InputMethodManager;

import br.com.syonet.library.android.R;


/**
 * Classe utilitária para o Android
 * </p>
 * Created by Eduardo Herzer on 21/08/17.
 */
public class AndroidUtils {
    /**
     * Exibe uma janela de diálogo na tela
     *
     * @param ctx     {@link Context}
     * @param titleId título da mensagem utilizando o id do resource de string
     * @param msgId   mensagem a ser exibida utilizando o id do resource de string
     */
    public static void showOkDialog(Context ctx, int titleId, int msgId) {
        showOkDialog(ctx, titleId, msgId, null);
    }

    /**
     * Exibe uma janela de diálogo na tela
     *
     * @param ctx {@link Context}
     * @param msgId mensagem a ser exibida
     * @param onClickListener listener para o botão
     */
    public static void showOkDialog(Context ctx, int titleId, int msgId, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle(titleId)
                .setMessage(msgId)
                .setCancelable(false)
                .setPositiveButton(R.string.ok, onClickListener)
                .show();
    }

    /**
     * Exibe uma janela de diálogo na tela
     *
     * @param ctx     {@link Context}
     * @param titleId título da mensagem utilizando o id do resource de string
     * @param msg     mensagem a ser exibida
     */
    public static void showOkDialog(Context ctx, int titleId, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle(titleId)
                .setMessage(msg)
                .setCancelable(false)
                .setPositiveButton(R.string.ok, null)
                .show();
    }

    /**
     * Exibe uma janela de diálogo com botões 'Sim' e 'Não'
     *
     * @param ctx {@link Context}
     * @param msgId mensagem a ser exibida
     * @param onClickListener listener para os botões
     */
    public static void showYesNoDialog(Context ctx, int titleId, int msgId, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle(titleId)
                .setMessage(msgId)
                .setPositiveButton(R.string.yes, onClickListener)
                .setNegativeButton(R.string.no, onClickListener)
                .show();
    }

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
