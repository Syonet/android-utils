package br.com.syonet.androidutils;

import java.util.List;

import android.text.TextUtils;

public class StringsUtils {
    /**
     * Verifica se um objeto é vazio.
     *
     * @param obj                 {@link Object} a ser testado
     * @param considerZeroAsEmpty true se é para considerar o valor 0 de Integer, Floar e Long como vazio
     * @return true caso o {@link Object} {@code obj} está vazio ou nulo
     */
    public static Boolean isEmpty ( Object obj, boolean considerZeroAsEmpty ) {
        if ( obj == null ) {
            return true;
        }

        if ( obj instanceof String ) {
            if ( TextUtils.isEmpty( ( ( String ) obj ).trim() ) ) {
                return true;
            }
        }

        if ( obj instanceof List ) {
            return ( ( List ) obj ).isEmpty();
        }

        if ( considerZeroAsEmpty ) {
            if ( obj instanceof Integer ) {
                if ( ( Integer ) obj == 0 ) {
                    return true;
                }
            } else if ( obj instanceof Long ) {
                if ( ( Long ) obj == 0 ) {
                    return true;
                }
            } else if ( obj instanceof Float ) {
                if ( ( Float ) obj == 0 ) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Verifica se um objeto é vazio.
     * <br>
     * Mesmo que chamar {@link #isEmpty(Object, boolean) isEmpty(obj, false)}
     *
     * @param obj {@link Object} a ser testado
     * @return true caso o {@link Object} {@code obj} está vazio ou nulo
     */
    public static Boolean isEmpty ( Object obj ) {
        return isEmpty( obj, false );
    }
}
