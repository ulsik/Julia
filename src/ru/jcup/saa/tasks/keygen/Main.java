package ru.jcup.saa.tasks.keygen;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


class BF {

    //алгоритм SHA-256
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash) {
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }


    public static void main(String args[]) throws NoSuchAlgorithmException {
        bruteForce(5);
    }


    public static String bruteForce(int size) throws NoSuchAlgorithmException {
        int[] password = new int[size];
        String[] finalPassword = new String[size];
        for (int i = 0; i < size; i++) {
            password[i] = 0;
            finalPassword[i] = "";
        }

        //Здесь вводится искомый пароль
        String isk = "1115dd800feaacefdf481f1f9070374a2a81e27880f187396db67958b207cbad";
        return computePermutations(size, password, 0, isk);
    }

    private static String computePermutations(int size, int[] password, int position, String isk) throws NoSuchAlgorithmException {
        String testString = "";
        String par = "";
        //алгоритм перебора паролей
        for (int i = 0; i < 26; i++) {
            password[position] = i;

            if (position != size - 1) {
                testString = computePermutations(size, password, position + 1, isk);
                if (testString != "") {
                    return testString;
                }
            } else if (position == size - 1) {
                for (int j = 0; j < size; j++) {

                    switch (password[j] + 1) {
                        case 1:
                            par = par + "a";
                            break;
                        case 2:
                            par = par + "b";
                            break;
                        case 3:
                            par = par + "c";
                            break;
                        case 4:
                            par = par + "d";
                            break;
                        case 5:
                            par = par + "e";
                            break;
                        case 6:
                            par = par + "f";
                            break;
                        case 7:
                            par = par + "g";
                            break;
                        case 8:
                            par = par + "h";
                            break;
                        case 9:
                            par = par + "i";
                            break;
                        case 10:
                            par = par + "j";
                            break;
                        case 11:
                            par = par + "k";
                            break;
                        case 12:
                            par = par + "l";
                            break;
                        case 13:
                            par = par + "m";
                            break;
                        case 14:
                            par = par + "n";
                            break;
                        case 15:
                            par = par + "o";
                            break;
                        case 16:
                            par = par + "p";
                            break;
                        case 17:
                            par = par + "q";
                            break;
                        case 18:
                            par = par + "r";
                            break;
                        case 19:
                            par = par + "s";
                            break;
                        case 20:
                            par = par + "t";
                            break;
                        case 21:
                            par = par + "u";
                            break;
                        case 22:
                            par = par + "v";
                            break;
                        case 23:
                            par = par + "w";
                            break;
                        case 24:
                            par = par + "x";
                            break;
                        case 25:
                            par = par + "y";
                            break;
                        case 26:
                            par = par + "z";
                            break;
                    }

                }
                //зздесь все пароли записываются в файл
/*
               try(FileWriter writer = new FileWriter("pas.txt", true))
                {
                    String text = par;
                    writer.write(text);
                    writer.write(" " + toHexString(getSHA(text)));
                    writer.append('\n');
                    writer.flush();
                }
                catch(IOException ex)
                {

                    System.out.println(ex.getMessage());
                }

 */
                //System.out.println(par); //+ " " + toHexString(getSHA(par)));
                if (toHexString(getSHA(par)).equalsIgnoreCase(isk)) {
                    //вывод результата
                    System.out.println("Password is: " + par);
                    break;
                } else {
                    par = "";
                }
            }
        }
        return "";
    }
}
 //Полякова Юлия Сергеевна