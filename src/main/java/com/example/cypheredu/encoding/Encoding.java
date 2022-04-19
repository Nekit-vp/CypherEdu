package com.example.cypheredu.encoding;

public interface Encoding {

    String encode(byte[] data);
    byte[] decode(String data);
}
