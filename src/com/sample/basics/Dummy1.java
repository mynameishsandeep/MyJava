package com.sample.basics;

import java.util.Arrays;
import java.util.Scanner;

import java.io.*;
import java.util.*;

public class Dummy1 {

    public static void main(String[] args) {
    try(Scanner scan = new Scanner(System.in))  {
        int n = scan.nextInt();
        int r = scan.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = scan.nextInt();
        }
        int start = r%n;
        
        for(int i=start,j=0; j<n; j++) {
            System.out.println(arr[i]);
            i++;
            if (i==n) {
                i=0;
            }
        }
    }
    }
    
}