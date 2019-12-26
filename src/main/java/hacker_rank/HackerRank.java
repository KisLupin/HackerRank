package hacker_rank;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.function.BiConsumer;

public class HackerRank {

    public int[] climbingLeaderboard(int[] scores, int[] alice) {
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

    public void matrixRotation(List<List<Integer>> matrix, int r) {
        List<List<Integer>> result;
        int row = matrix.size();
        int col = matrix.get(0).size();
        List<Integer> row1 = new ArrayList<Integer>();
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

    public String morganAndString(String a, String b) {
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

    public String sha256(String base) {
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

    public void solve(double meal_cost, int tip_percent, int tax_percent) {
        double tip = meal_cost * tip_percent/100;
        double tax = meal_cost * tax_percent/100;
        double total =  (meal_cost + tip + tax);
        if (total - (int) total > 0.5){
            System.out.println((int)total + 1);
        }else System.out.println((int)total);
    }

    public String findDay(int month, int day, int year) {
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

    public String getSmallestAndLargest(String s, int k) {
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

    public boolean isAnagram(String a, String b) {
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

    public void stack(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            Stack<Character> stack = new Stack();
            for (int i = 0; i < input.length(); i++) {
                if (stack.isEmpty()){
                    stack.push(input.charAt(i));
                }else if (stack.peek() == '{'){
                    if (input.charAt(i) == '}'){
                        stack.pop();
                    }else stack.push(input.charAt(i));
                }else if (stack.peek() == '('){
                    if (input.charAt(i) == ')'){
                        stack.pop();
                    }else stack.push(input.charAt(i));
                }else if (stack.peek() == '['){
                    if (input.charAt(i) == ']'){
                        stack.pop();
                    }else stack.push(input.charAt(i));
                }
            }
            if (stack.empty()){
                System.out.println("true");
            }else System.out.println("false");
        }
    }

    public void biggerIsGreater(){
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            StringBuilder s1 = new StringBuilder(input.next());
            s1.append("z");//Denote end
            StringBuilder s2 = new StringBuilder(input.next());
            s2.append("z");//Denote end
            StringBuilder output = new StringBuilder("");
            int i = 0, j = 0;//Index into each string
            while (i < s1.length() && j < s2.length()) {
                if (s1.charAt(i) < s2.charAt(j)) {
                    output.append(s1.charAt(i));
                    i++;
                } else if (s1.charAt(i) > s2.charAt(j)) {
                    output.append(s2.charAt(j));
                    j++;
                }
                else {
//                    if (s1.charAt(i) == 'z') {
//                        i++;
//                        j++;
//                        continue;
//                    }
                    int startingI = i;
                    int startingJ = j;
                    while (s1.charAt(i) == s2.charAt(j)) {
                        i++;
                        j++;
                        if (i >= s1.length() && j >= s2.length()) //They are the same string
                        {
                            i = startingI;
                            j = startingJ;
                            break;
                        } else if (i >= s1.length()) //String 1 is shorter than string 2
                        {
                            char prev = s2.charAt(startingJ);
                            while (s2.charAt(startingJ) <= prev) {
                                output.append(s2.charAt(startingJ));
                                prev = s2.charAt(startingJ);
                                startingI++;
                            }
                            i = startingI;
                            j = startingJ;
                        } else if (j >= s2.length()) //String 2 is shorter than string 1
                        {
                            char prev = s1.charAt(startingI);
                            while (s1.charAt(startingI) <= prev) {
                                output.append(s1.charAt(startingI));
                                prev = s1.charAt(startingI);
                                startingI++;
                            }
                            i = startingI;
                            j = startingJ;
                        }
                    }
                    if (s1.charAt(i) <= s2.charAt(j)) {
                        char prev = s1.charAt(startingI);
                        while (s1.charAt(startingI) < prev) {
                            output.append(s1.charAt(startingI));
                            prev = s1.charAt(startingI);
                            startingI++;
                        }
                        i = startingI;
                        j = startingJ;
                    }
                    if (s1.charAt(i) > s2.charAt(j)) {
                        char prev = s2.charAt(startingJ);
                        while (s2.charAt(startingJ) <= prev) {
                            output.append(s2.charAt(startingJ));
                            prev = s2.charAt(startingJ);
                            startingJ++;
                        }
                        i = startingI;
                        j = startingJ;
                    }
                }
            }
            while (i < s1.length()) {
                output.append(s1.charAt(i));
                i++;
            }
            while (j < s2.length()) {
                output.append(s2.charAt(j));
                j++;
            }
            System.out.println(output);
        }
    }

    public void stringLoop(){
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();
        for (int k = 0; k < in; k++) {
            String input = sc.next();
            char[] a = input.toCharArray();
            for (int i = 0; i < a.length; i++) {
                if (i % 2 == 0) System.out.print(a[i]);
            }
            System.out.print(" ");
            for (int i = 0; i < a.length; i++) {
                if (i % 2 != 0) System.out.print(a[i]);
            }
        }
    }

    public void map(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String,Integer> listPhone = new HashMap<>();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            listPhone.put(name, phone);
        }
        while(in.hasNext()){
            String s = in.next();
           if (listPhone.get(s)!=null){
               System.out.println(s + "=" + listPhone.get(s));
           }else System.out.println("Not found");
        }
        in.close();
    }

    public int factorial(int n){
        if (n == 0 || n == 1){
            return 1;
        }
        return factorial(n-1)*n;
    }

    public void array_2D(int[][] arr){
        int max = arr[0][0] + arr[0][1] + arr[0][2]
                + arr[1][1]
                + arr[2][0] + arr[2][1] + arr[2][2];;
        int sum;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if ( i == 0 && j == 0){
                    continue;
                }
                sum = arr[i][j] + arr[i][j+1] + arr[i][j+2]
                        + arr[i+1][j+1]
                        + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                if (sum < 0 && max < 0){
                    if (Math.abs(max) > Math.abs(sum)){
                        max = sum;
                    }
                }else {
                    if (max < sum) max = sum;
                }
            }
        }
        System.out.println(max);
    }

    public void MD5(){
        String input = new Scanner(System.in).nextLine();
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // digest() method is called to calculate message digest
        //  of an input digest() return array of byte
        byte[] messageDigest = md.digest(input.getBytes());

        // Convert byte array into signum representation
        BigInteger no = new BigInteger(1, messageDigest);

        // Convert message digest into hex value
        String hashtext = no.toString(16);
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        System.out.println(hashtext);
    }

    public void bitSet(){
        Scanner sc = new Scanner(System.in);
        int setSize = sc.nextInt();
        int noOps = sc.nextInt();
        BitSet[] bitSets = new BitSet[]{new BitSet(setSize), new BitSet(setSize)};
        Map<String, BiConsumer<Integer,Integer>> ops = new HashMap<>();
        ops.put("AND", (index1, index2) -> bitSets[index1-1].and(bitSets[index2-1]));
        ops.put("OR", (index1, index2) -> bitSets[index1-1].or(bitSets[index2-1]));
        ops.put("XOR", (index1, index2) -> bitSets[index1-1].xor(bitSets[index2-1]));
        ops.put("SET", (index1, index2) -> bitSets[index1-1].set(index2));
        ops.put("FLIP", (index1, index2) -> bitSets[index1-1].flip(index2));
        for (int i = 0; i < noOps; i++){
            ops.get(sc.next()).accept(sc.nextInt(), sc.nextInt());
            System.out.println(bitSets[0].cardinality() + " " + bitSets[1].cardinality());
        }
    }
}
