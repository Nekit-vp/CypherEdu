package com.example.cypheredu.encryption;

public interface Encryption {

    String encrypt (String text, int key);
    String decrypt (String text, int key);

}
