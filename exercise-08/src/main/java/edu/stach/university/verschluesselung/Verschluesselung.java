/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.stach.university.verschluesselung;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/29/16
 */
public class Verschluesselung {
    /**
     * Entschlüsselt einen Text
     *
     * @param klartext   Der Chieffrierungs-Algorythmus
     * @param schluessel Der Chieffrierungs-Algorythmus
     * @return Der Geheimtext
     */
    public static String verschluesseln(String klartext, Chiffrierung schluessel) {
        char[] geheimtext = klartext.toCharArray();

        for (int i = 0; i < geheimtext.length; i++) {
            geheimtext[i] = schluessel.chiffrieren(geheimtext[i]);
        }


        return String.valueOf(geheimtext);
    }

    /**
     * Verschlüsselt einen Text
     *
     * @param geheimtext Der Text
     * @param schluessel Der Chieffrierungs-Algorythmus
     * @return Der Klartext
     */
    public static String entschluesseln(String geheimtext, Chiffrierung schluessel) {
        char[] klartext = geheimtext.toCharArray();

        for (int i = 0; i < klartext.length; i++) {
            klartext[i] = schluessel.dechiffrieren(klartext[i]);
        }

        return String.valueOf(klartext);
    }
}
