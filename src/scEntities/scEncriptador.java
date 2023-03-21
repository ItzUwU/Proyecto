package scEntities;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class scEncriptador {

    private static final String SCALGORITMO = "AES";                    //tipo de encryptado
    private static final String SCCLAVE_SECRETA = "clave_encriptado";   //clave de encriptacion y desenccriptacion
/**
 * Metodo que permite encripar palabras y que se utilizara para la creacion del login
 *
 * @param scTexto Texto que se desea encriptar
 * @return retorna el Texto encriptado
 * 
 */
    public String scEncriptar(String scTexto) throws Exception {
        SecretKeySpec clave = new SecretKeySpec(SCCLAVE_SECRETA.getBytes(), SCALGORITMO);
        Cipher cifrador = Cipher.getInstance(SCALGORITMO);
        cifrador.init(Cipher.ENCRYPT_MODE, clave);
        byte[] scTextoEncriptado = cifrador.doFinal(scTexto.getBytes());
        return Base64.getEncoder().encodeToString(scTextoEncriptado);
    }

/**
 * Metodo que permite desencripar las palabras encriptadas
 *
 * @param scTextoEncriptado Texto encriptado
 * @return retorna el Texto desencriptado
 * 
 */
    public String scDesencriptar(String scTextoEncriptado) throws Exception {
        SecretKeySpec clave = new SecretKeySpec(SCCLAVE_SECRETA.getBytes(), SCALGORITMO);
        Cipher cifrador = Cipher.getInstance(SCALGORITMO);
        cifrador.init(Cipher.DECRYPT_MODE, clave);
        byte[] textoDesencriptado = cifrador.doFinal(Base64.getDecoder().decode(scTextoEncriptado));
        return new String(textoDesencriptado);
    }
}
