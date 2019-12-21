package hacker_rank;//import java.io.*;
//import java.util.*;
//
//public class Solution {
//
//    public static void main (String[]args){
//        Scanner input = new Scanner(System.in);
//        int t = input.nextInt();
//        for (int a0 = 0; a0 < t; a0++) {
//            StringBuilder s1 = new StringBuilder(input.next());
//            s1.append("z");//Denote end
//            StringBuilder s2 = new StringBuilder(input.next());
//            s2.append("z");//Denote end
//            StringBuilder output = new StringBuilder("");
//            int i = 0, j = 0;//Index into each string
//            while (i < s1.length() && j < s2.length()) {
//                if (s1.charAt(i) < s2.charAt(j)) {
//                    output.append(s1.charAt(i));
//                    i++;
//                } else if (s1.charAt(i) > s2.charAt(j)) {
//                    output.append(s2.charAt(j));
//                    j++;
//                }
//                else {
////                    if (s1.charAt(i) == 'z') {
////                        i++;
////                        j++;
////                        continue;
////                    }
//                    int startingI = i;
//                    int startingJ = j;
//                    while (s1.charAt(i) == s2.charAt(j)) {
//                        i++;
//                        j++;
//                        if (i >= s1.length() && j >= s2.length()) //They are the same string
//                        {
//                            i = startingI;
//                            j = startingJ;
//                            break;
//                        } else if (i >= s1.length()) //String 1 is shorter than string 2
//                        {
//                            char prev = s2.charAt(startingJ);
//                            while (s2.charAt(startingJ) <= prev) {
//                                output.append(s2.charAt(startingJ));
//                                prev = s2.charAt(startingJ);
//                                startingI++;
//                            }
//                            i = startingI;
//                            j = startingJ;
//                        } else if (j >= s2.length()) //String 2 is shorter than string 1
//                        {
//                            char prev = s1.charAt(startingI);
//                            while (s1.charAt(startingI) <= prev) {
//                                output.append(s1.charAt(startingI));
//                                prev = s1.charAt(startingI);
//                                startingI++;
//                            }
//                            i = startingI;
//                            j = startingJ;
//                        }
//                    }
//                    if (s1.charAt(i) <= s2.charAt(j)) {
//                        char prev = s1.charAt(startingI);
//                        while (s1.charAt(startingI) < prev) {
//                            output.append(s1.charAt(startingI));
//                            prev = s1.charAt(startingI);
//                            startingI++;
//                        }
//                        i = startingI;
//                        j = startingJ;
//                    }
//                    if (s1.charAt(i) > s2.charAt(j)) {
//                        char prev = s2.charAt(startingJ);
//                        while (s2.charAt(startingJ) <= prev) {
//                            output.append(s2.charAt(startingJ));
//                            prev = s2.charAt(startingJ);
//                            startingJ++;
//                        }
//                        i = startingI;
//                        j = startingJ;
//                    }
//                }
//            }
//            while (i < s1.length()) {
//                output.append(s1.charAt(i));
//                i++;
//            }
//            while (j < s2.length()) {
//                output.append(s2.charAt(j));
//                j++;
//            }
//            System.out.println(output);
//        }
//    }
//}

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Checker implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        if (o1.score == o2.score){
            return o1.name.compareTo(o2.name);
        }
        return o2.score - o1.score;
    }
}

class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}