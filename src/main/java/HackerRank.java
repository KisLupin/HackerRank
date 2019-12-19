import java.security.MessageDigest;
import java.util.*;

public class HackerRank {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input=sc.next();
            //Complete the code
        }




    }
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] result = new int[alice.length];
        List<Integer> newScore = new ArrayList<Integer>();
        for (int i = 0; i < scores.length; i++) {
            if (i>0){
                if (scores[i] == scores[i-1]) continue;
            }
            newScore.add(scores[i]);
        }

        Hashtable<Integer,Integer> rank = new Hashtable<Integer, Integer>();
        for (int i = newScore.size() -1; i >= 0 ; i--) {
            rank.put(i+1,newScore.get(newScore.size()-i-1));
        }
        int temp = 0;
        for (int i = 0; i < alice.length; i++) {
            for (int j = 1; j <= rank.size(); j++) {
                if (alice[i] >= rank.get(j)) temp ++;
            }
            result[i] = rank.size() - temp + 1;
            temp = 0;
        }
        return result;
    }

    static String biggerIsGreater(String w) {
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) - 0 < 65 || w.charAt(i) - 0 > 122){
                return "";
            }
        }

        return "abcd";
    }

    static void matrixRotation(List<List<Integer>> matrix, int r) {
        List<List<Integer>> result;
        int row = matrix.size();
        int col = matrix.get(0).size();
        List<Integer> row1 = new ArrayList<Integer>();
//        int maxStepRow = row - 2;
//        int maxStepCol = col - 2;
//        int temp = 0;
        for (int i = 0; i < row; i++) {    // row
            for (int j = 0; j < col; j++) {   // column
                while (r == 0) {
                    if (i == row -1){
                        j++;i--;
                    }
                    i++;r--;

                }
            }
        }
    }

    static String morganAndString(String a, String b) {
        String result = "";

        int i = 0, j = 0;
        while (i < a.length() && j < b.length()){
            if (a.charAt(i) > b.charAt(j)){
                result  += b.charAt(j);
                j++;
            }else if (a.charAt(i) < b.charAt(j)){
                result += a.charAt(i);
                i++;
            }
            else {
                int startingI = i;
                int startingJ = j;
                while (a.charAt(i) == a.charAt(j)){
                    i++;
                    j++;
                    if (i >= a.length() && j >= b.length()) //They are the same string
                    {
                        i = startingI;
                        j = startingJ;
                        break;
                    } else if (i >= a.length()) //String 1 is shorter than string 2
                    {
                        char prev = b.charAt(startingJ);
                        while (b.charAt(startingJ) <= prev) {
                            result += b.charAt(startingJ);
                            prev = b.charAt(startingJ);
                            startingI++;
                        }
                        i = startingI;
                        j = startingJ;
                    } else if (j >= b.length()) //String 2 is shorter than string 1
                    {
                        char prev = a.charAt(startingI);
                        while (a.charAt(startingI) <= prev) {
                            result += (a.charAt(startingI));
                            prev = a.charAt(startingI);
                            startingI++;
                        }
                        i = startingI;
                        j = startingJ;
                    }
                }
                if (a.charAt(i) <= b.charAt(j)) {
                    char prev = a.charAt(startingI);
                    while (a.charAt(startingI) <= prev) {
                        result += (a.charAt(startingI));
                        prev = a.charAt(startingI);
                        startingI++;
                    }
                    i = startingI;
                    j = startingJ;
                }
                if (a.charAt(i) > b.charAt(j)) {
                    char prev = b.charAt(startingJ);
                    while (b.charAt(startingJ) < prev) {
                        result += (b.charAt(startingJ));
                        prev = b.charAt(startingJ);
                        startingJ++;
                    }
                    i = startingI;
                    j = startingJ;
                }
            }
        }

        while (i < a.length()) {
            result += (a.charAt(i));
            i++;
        }

        while (j < b.length()) {
            result += (b.charAt(j));
            j++;
        }
        return result;
    }

    public static String sha256(String base) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    static void solve(double meal_cost, int tip_percent, int tax_percent) {
        double tip = meal_cost * tip_percent/100;
        double tax = meal_cost * tax_percent/100;
        double total =  (meal_cost + tip + tax);
        if (total - (int) total > 0.5){
            System.out.println((int)total + 1);
        }else System.out.println((int)total);
    }

    public static String findDay(int month, int day, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        String a;
        switch (calendar.get(Calendar.DAY_OF_WEEK)){
            case 2:
                a =  "MONDAY";
                break;
            case 3:
                a =  "TUESDAY";
                break;
            case 4:
                a =  "WEDNESDAY";
                break;
            case 5:
                a =  "THURSDAY";
                break;
            case 6:
                a =  "FRIDAY";
                break;
            case 7:
                a =  "SATURDAY";
                break;
            default:
                a =  "SUNDAY";
                break;
        }
        return a;
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest =  s.substring(0,k);
        String largest  = s.substring(0,k);

        for (int i = 1; i <= s.length() - k; i++) {
            String temp = s.substring(i,i+k);
            if (smallest.charAt(0) > temp.charAt(0)){
                smallest = temp;
            }
            if (smallest.charAt(0) == temp.charAt(0)){
                if (smallest.equals(temp)){

                }else {
                    int a = 1;
                    while (smallest.charAt(a) == temp.charAt(a)  && a <= smallest.length() -1){
                        a++;
                    }
                    if (smallest.charAt(a) > temp.charAt(a)){
                        smallest = temp;
                    }
                }
            }
            if (largest.charAt(0) < temp.charAt(0)){
                largest = temp;
            }
            if (largest.charAt(0) == temp.charAt(0)){
                if (largest.equals(temp)){

                }else {
                    int a = 1;
                    while (largest.charAt(a) == temp.charAt(a)  && a <= largest.length() -1){
                        a++;
                    }
                    if (largest.charAt(a) < temp.charAt(a)){
                        largest = temp;
                    }
                }
            }
        }
        return smallest + "\n" + largest;
    }

    static boolean isAnagram(String a, String b) {
        Hashtable<Character,Integer> lista = new Hashtable<>();
        Hashtable<Character,Integer> listb = new Hashtable<>();
        char[] convert_a = a.toCharArray();
        char[] convert_b = b.toCharArray();
        Arrays.sort(convert_a);
        Arrays.sort(convert_b);
        for (int i = 0; i < convert_a.length; i++) {
            int counta = 0;
            int countb = 0;
            for (int j = 0; j < convert_a.length; j++) {
                if (convert_a[i] == convert_a[j]){
                    counta++;
                }
                if (convert_b[i] == convert_b[j]){
                    countb++;
                }
            }
            lista.put(convert_a[i],counta);
            listb.put(convert_a[i],countb);
        }
        Iterator<Integer> iot = lista.values().iterator();
        Iterator<Integer> iot2 = listb.values().iterator();
        while (iot.hasNext() && iot2.hasNext()){
            if (iot.next() != iot2.next()){
                return false;
            }
        }
        return true;
    }
}
