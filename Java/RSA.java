//RSA(Rivest, Shamir, Adleman) Encryption and Decryption Algorithm.

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

class RSA {
    static BigInteger p ,q ,n ,phi , e,d;
    static byte [] encrypt (byte [] msg){
        return (new BigInteger(msg)).modPow(e, n).toByteArray(); 
    }
    
    static byte [] decrypt (byte [] msg){
        return (new BigInteger(msg)).modPow(d, n).toByteArray(); 
    }
    
    public static void main(String[] args) {
        Random rd = new Random();
        p = BigInteger.probablePrime(1024, rd);
        q = BigInteger.probablePrime(1024, rd);
        
        n = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        e = BigInteger.probablePrime(512, rd);
        d = e.modInverse(phi);
        System.out.println("Enter The Data Word");
        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();
        sc.close();
        byte [] enc = encrypt(msg.getBytes());
        System.out.println("Encrypted Message is "+new String(enc));

        byte [] dec = decrypt(enc);
        System.out.println("Decrypted Message is "+new String(dec));
        
    }        
}
