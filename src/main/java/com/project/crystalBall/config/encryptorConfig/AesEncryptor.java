package com.project.crystalBall.config.encryptorConfig;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SerializationUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Base64;

@Converter
public class AesEncryptor implements AttributeConverter<Object, String> {

    @Value("${encryptor.initialization-vector}")
    private String initializationVector;

    private final String cipherTechnique = "AES";

    private Key key;
    private Cipher cipher;

    private Key getKey() {
        if (key == null)
            key = new SecretKeySpec(initializationVector.getBytes(), cipherTechnique);
        return key;
    }

    private Cipher getCipher() throws GeneralSecurityException {
        if (cipher == null)
            cipher = Cipher.getInstance(cipherTechnique);
        return cipher;
    }

    private void initCipher(int encryptMode) throws GeneralSecurityException {
        getCipher().init(encryptMode, getKey());
    }

    @Override
    public String convertToDatabaseColumn(Object value) {
        if(value == null){
            return null;
        }
        try {
            initCipher(Cipher.ENCRYPT_MODE);
            byte[] bytes = serialize(value);
            return Base64.getEncoder().encodeToString(getCipher().doFinal(bytes));
        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException("Error while encoding");
        }
    }

    @Override
    public Object convertToEntityAttribute(String encryptedEntity) {
        if(encryptedEntity == null){
            return null;
        }
        try {
            initCipher(Cipher.DECRYPT_MODE);
            byte[] bytes = getCipher().doFinal(Base64.getDecoder().decode(encryptedEntity));
            return deserialize(bytes);
        } catch (GeneralSecurityException | IOException | ClassNotFoundException e) {
            throw new RuntimeException("Error while decoding");
        }
    }

    private Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteStream = new ByteArrayInputStream(data);
        ObjectInputStream objectStream = new ObjectInputStream(byteStream);
        return objectStream.readObject();
    }

    public static byte[] serialize(Object object) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(object);
        return out.toByteArray();
    }
}
