package com.rafa.cryptography.service;

import org.jasypt.util.text.StrongTextEncryptor;

/**
 * We use the JASYPT(Java Simplified Encryption) library for encryption operations
 */
public class CryptoService {
    private static final StrongTextEncryptor encryptor;

    static {
        encryptor = new StrongTextEncryptor();
        encryptor.setPassword(System.getenv("APP_KEY"));
    }

    public static String encrypt(String rawText) {
        return encryptor.encrypt(rawText);
    }

    public static String decrypt(String encryptedText) {
        return encryptor.decrypt(encryptedText);
    }
}
