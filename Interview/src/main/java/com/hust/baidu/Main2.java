package com.hust.baidu;


import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Map<Character, Set<Character>> map = new HashMap<>();
        map.put('u', new HashSet<>());
        map.put('g', new HashSet<>());
        map.put('o', new HashSet<>());

        for (int i = 0; i < 3; i++) {
            char ch = s.charAt(i);
            if (ch != '-'){
                map.get('u').add(ch);
            }
        }

        for (int i = 3; i < 6; i++) {
            char ch = s.charAt(i);
            if (ch != '-'){
                map.get('g').add(ch);
            }
        }

        for (int i = 6; i < 9; i++) {
            char ch = s.charAt(i);
            if (ch != '-'){
                map.get('o').add(ch);
            }
        }

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String shell = scanner.nextLine();
            String chmod = shell.split(" ")[1];
            String[] parts = chmod.split("[+=-]");
            char[] c1 = parts[0].toCharArray();
            char[] c2 = parts[1].toCharArray();

            if (parts[0].contains("a")){
                if (chmod.contains("-")){
                    for (char c : c2) {
                        map.get('u').remove(c);
                        map.get('g').remove(c);
                        map.get('o').remove(c);
                    }
                }else{
                    for (char c : c2) {
                        map.get('u').add(c);
                        map.get('g').add(c);
                        map.get('o').add(c);
                    }
                }
                continue;
            }

            for (char t : c1) {
                if (chmod.contains("-")){
                    for (char c : c2) {
                        map.get(t).remove(c);
                    }
                }else{
                    for (char c : c2) {
                        map.get(t).add(c);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (map.get('u').contains('r')){
            sb.append('r');
        }else{
            sb.append('-');
        }

        if (map.get('u').contains('w')){
            sb.append('w');
        }else{
            sb.append('-');
        }

        if (map.get('u').contains('x')){
            sb.append('x');
        }else{
            sb.append('-');
        }

        if (map.get('g').contains('r')){
            sb.append('r');
        }else{
            sb.append('-');
        }

        if (map.get('g').contains('w')){
            sb.append('w');
        }else{
            sb.append('-');
        }

        if (map.get('g').contains('x')){
            sb.append('x');
        }else{
            sb.append('-');
        }

        if (map.get('o').contains('r')){
            sb.append('r');
        }else{
            sb.append('-');
        }

        if (map.get('o').contains('w')){
            sb.append('w');
        }else{
            sb.append('-');
        }

        if (map.get('o').contains('x')){
            sb.append('x');
        }else{
            sb.append('-');
        }
        System.out.println(sb);
    }
}