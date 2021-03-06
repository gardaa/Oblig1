//Gard Åckerström Aasness - s339557

package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {
    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    /*
    - Det blir flest ombyttinger naar det hoeyeste tallet ligger på første plass i listen (indeks 0).
    - Det blir faerrest ombyttinger naar listen allerede er sortert i stigende rekkefoelge.
    - En tilnaermet riktig formel vil vaere O(n), ettersom antall ombytter er tilnaermet lik antall tall i listen
     */
    public static int maks(int[] a) {
        if (a.length == 0) {
            throw new NoSuchElementException("Listen er tom");
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                bytt(a, i, i - 1);
            }
        }
        return a[a.length - 1];
        //throw new UnsupportedOperationException();
    }

    public static int ombyttinger(int[] a) {
        int teller = 0;

        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                bytt(a, i, i - 1);
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
            if (a[i] > a[i - 1]) {
                teller++;
            } else if (a[i] < a[i - 1]) {
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

        int teller = 1;
        int alleredeBrukt = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] == a[i]) {
                    alleredeBrukt++;
                }
            }
            if (alleredeBrukt == 0) {
                teller++;
            }
            alleredeBrukt = 0;
        }
        return teller;
        //throw new UnsupportedOperationException();
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        /*
        Bruke quicksort til å sortere. Først gjøre en sjekk med modulus som sjekker om tallet er et oddetall eller
        partall(oddetall til venstre, partall til høyre). Deretter gjøre en sjekk som sjekker hvor den skal ligge
        ettersom det skal være i stigende rekkefølge.
         */

        int venstre = 0;
        int hoyre = a.length - 1;
        if (kunPartall(a)) {
            Arrays.sort(a);
        }
        if (kunOddetall(a)) {
            Arrays.sort(a);
        }
        int antallOdde = 0;
        while (venstre < hoyre) {
            while (a[venstre] % 2 != 0 && venstre < hoyre) {
                venstre++;
                antallOdde++;
            }
            while (a[hoyre] % 2 == 0 && venstre < hoyre)
                hoyre--;
            if (venstre < hoyre) {
                bytt(a, venstre, hoyre);
            }
        }
        Arrays.sort(a, 0, antallOdde);
        Arrays.sort(a, antallOdde, a.length);
    }

    public static boolean kunPartall(int [] a) {
        boolean kunPartall = true;
        for (int j : a) {
            if (j % 2 == 1) {
                kunPartall = false;
                break;
            }
        }
        return kunPartall;
    }

    public static boolean kunOddetall(int [] a) {
        boolean kunOddetall = true;
        for (int j : a) {
            if (j % 2 == 0) {
                kunOddetall = false;
                break;
            }
        }
        return kunOddetall;
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
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            nyString += s.charAt(i++);
            nyString += t.charAt(j++);
        }
        while (i < s.length()) {
            nyString += s.charAt(i++);
        }
        while (j < t.length()) {
            nyString += t.charAt(j++);
        }
        return nyString;
        /*int indeks_teller = 0;
        while (indeks_teller < s.length() && indeks_teller < t.length()) {
            nyString += s.charAt(indeks_teller);
            nyString += t.charAt(indeks_teller);
            indeks_teller++;
        }

        if (indeks_teller == s.length() && indeks_teller != t.length()) {
            for (int i = indeks_teller; i < t.length(); i++) {
                nyString += t.charAt(i);
            }
        }
        else if (indeks_teller == t.length() && indeks_teller != s.length()) {
            for (int i = indeks_teller; i < s.length(); i++) {
                nyString += s.charAt(i);
            }
        }
        return nyString;
        //throw new UnsupportedOperationException();*/
    }

    /// 7b)
    public static String flett(String... s) {
        String nyString = "";
        int teller = 0;
        while (getLongestString(s) >= teller) {
            for (String element : s) {
                if (element.length() > teller) {
                    nyString += element.charAt(teller);
                }
            }
            teller++;
        }
        return nyString;
    }

    public static int getLongestString(String... s) {
        int maxLength = 0;
        for (String st : s) {
            if (st.length() > maxLength) {
                maxLength = st.length();
            }
        }
        return maxLength;
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
