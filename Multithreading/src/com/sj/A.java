package com.sj;

class A extends Thread {
private int i;
public void run() {i = 1;}
public static void main(String[] args) {
  A a = new A(); a.start(); System.out.print(a.i);
}}



