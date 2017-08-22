package br.com.syonet.androidutils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Classe utilitária para dialogs
 * </p>
 * Created by Eduardo Herzer on 22/08/17.
 */
public class DialogUtils {
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
}
