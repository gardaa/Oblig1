package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;

public class Oblig1 {
    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////
    /*
    - Det blir flest ombyttinger når det høyeste tallet ligger på første plass i listen (indeks 0).
    - Det blir færrest ombyttinger når listen allerede er sortert i stigende rekkefølge.
    - En tilnærmet riktig formel vil være O(n), ettersom antall ombytter er tilnærmet lik antall tall i listen
     */
    public static int maks(int[] a) {
        if (a.length == 0) {
            throw new NoSuchElementException("Listen er tom");
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i-1] > a[i]) {
                bytt(a, i, i-1);
            }
        }
        return a[a.length-1];
        //throw new UnsupportedOperationException();
    }

    public static int ombyttinger(int[] a) {
        int teller = 0;

        for (int i = 1; i < a.length; i++) {
            if (a[i-1] > a[i]) {
                bytt(a, i, i-1);
                teller++;
            }
        }
        return teller;
        //throw new UnsupportedOperationException();
    }

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        if (a.length == 0) {
            return 0;
        }
        if (a.length == 1) {
            return 1;
        }

        int teller = 1;

        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i-1]) {
                teller++;
            }
            else if (a[i] < a[i-1]) {
                throw new IllegalStateException("Listen er ikke sortert i stigende rekkefølge");
            }
        }
        return teller;
        //throw new UnsupportedOperationException();
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        if (a.length == 0) {
            return 0;
        }
        if (a.length == 1) {
            return 1;
        }

        int teller = 0;
        for (int i = 0; i < a.length; i++) {

        }
        return 0;
        //throw new UnsupportedOperationException();
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {

        //throw new UnsupportedOperationException();
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        if (a.length > 3) {
            char tempBak = a[0];
            char tempValgt = a[1];
            for (int i = 1; i < a.length; i++) {
                a[i] = tempBak;
                tempBak = tempValgt;
                if (i != a.length-1) {
                    tempValgt = a[i+1];
                }
            }
            a[0] = tempBak;
        }
        else if (a.length == 2) {
            bytt(a, 0, 1);
        }
        //throw new UnsupportedOperationException();
    }

    public static void bytt(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        String nyString = "";
        int indeks_teller = 0;
        while (indeks_teller < s.length() && indeks_teller < t.length()) {
            nyString += s.charAt(indeks_teller);
            nyString += t.charAt(indeks_teller);
            indeks_teller++;
        }
        if (indeks_teller == s.length()) {
            for (int i = indeks_teller; i < t.length(); indeks_teller++) {
                nyString += t.charAt(i);
            }
        }
        return nyString;
        //throw new UnsupportedOperationException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new UnsupportedOperationException();
    }

}  // Oblig1
