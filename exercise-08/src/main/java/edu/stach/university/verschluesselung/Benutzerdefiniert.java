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

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/29/16
 */
public class Benutzerdefiniert implements Chiffrierung {
    private char[] geheimTextAlphabet;

    public Benutzerdefiniert(char[] geheimTextAlphabet) {
        if (geheimTextAlphabet.length != 26) {
            throw new IllegalArgumentException("Das GeheimtextAplhabet benötigt eine Länge von 26 da nur kleine Buchstaben verschlüsselt werden");
        }
        this.geheimTextAlphabet = geheimTextAlphabet;
    }

    @Override
    public char chiffrieren(char zeichen) {
        if (zeichen >= 97 && zeichen <= 122) {
            return this.geheimTextAlphabet[zeichen - 97];
        } else {
            return zeichen;
        }
    }

    @Override
    public char dechiffrieren(char zeichen) {
        int index = Arrays.binarySearch(this.geheimTextAlphabet, zeichen);

        if (index != -1) {
            return (char) (index + 97);
        } else {
            return zeichen;
        }
    }
}
