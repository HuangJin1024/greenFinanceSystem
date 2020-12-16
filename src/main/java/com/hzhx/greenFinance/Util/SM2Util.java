package com.hzhx.greenFinance.Util;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;

import java.math.BigInteger;
import java.security.PublicKey;

import javax.crypto.SecretKey;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.asn1.gm.GMNamedCurves;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.jce.spec.ECPublicKeySpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

public class SM2Util {
	public void testSm2() {
        //加密过程
        SecretKey secretKey = SecureUtil.generateKey("AES");
        byte[] secretKeyEncoded = secretKey.getEncoded();
        PublicKey publicKey = this.getPublicKeyFromString("BBtUAPVOz7s8rmMfZNQTCHdye/wKzMdzTMzPvDYonsG/+eh6idzCJ48JaTSuZ+5AU6N5/vgk8Th2zMDtrt7uz1U=");
        byte[] secretKeyDecrypt = SmUtil.sm2().setPublicKey(publicKey).encrypt(secretKeyEncoded, KeyType.PublicKey);
        String fileSecretKey = Base64.encodeBase64String(secretKeyDecrypt);
        
        //解密
        //System.out.println(fileSecretKey);
        //PrivateKey privateKey = SM2Utils.getPrivateKeyFromString(this.getFilePrivateKey("B0159B233050001"));
        //使用SM2密钥对中的私钥，使用SM2解密 获得AES秘钥
        //byte[] secretKeyEncoded2 = SmUtil.sm2().setPrivateKey(privateKey).decrypt(Base64.decodeBase64(fileSecretKey), KeyType.PrivateKey);
    }

    /*private String getFilePrivateKey(String appKey) {
        String authPrivateKey = "";
        BankVO bankVO = bankService.getBankByCd(appKey);
        if (bankVO != null) {
            authPrivateKey = bankVO.getFilePrivateKey();
        }
        return authPrivateKey;
    }*/

    /**
     * 字符串和秘钥对象的转换
     *
     * @param publicKeyStr
     * @return
     */
    public static PublicKey getPublicKeyFromString(String publicKeyStr) {
        byte buffer[] = Base64.decodeBase64(publicKeyStr);
        BigInteger p = new BigInteger(
                "FFFFFFFE" + "FFFFFFFF" + "FFFFFFFF" + "FFFFFFFF" + "FFFFFFFF" + "00000000" + "FFFFFFFF" + "FFFFFFFF", 16);
        BigInteger a = new BigInteger(
                "FFFFFFFE" + "FFFFFFFF" + "FFFFFFFF" + "FFFFFFFF" + "FFFFFFFF" + "00000000" + "FFFFFFFF" + "FFFFFFFC", 16);
        BigInteger b = new BigInteger(
                "28E9FA9E" + "9D9F5E34" + "4D5A9E4B" + "CF6509A7" + "F39789F5" + "15AB8F92" + "DDBCBD41" + "4D940E93", 16);
        ECCurve.Fp curve = new ECCurve.Fp(p, a, b);
        ECPoint ecPoint = curve.decodePoint(buffer);
        return getPublickeyFromXY(ecPoint.getXCoord().toBigInteger(), ecPoint.getYCoord().toBigInteger());
    }

    private static BCECPublicKey getPublickeyFromXY(BigInteger x, BigInteger y){
        X9ECParameters x9ECParameters = GMNamedCurves.getByName("sm2p256v1");
        ECParameterSpec ecParameterSpec = new ECParameterSpec(x9ECParameters.getCurve(), x9ECParameters.getG(), x9ECParameters.getN());
        ECPublicKeySpec ecPublicKeySpec = new ECPublicKeySpec(x9ECParameters.getCurve().createPoint(x, y), ecParameterSpec);
        return new BCECPublicKey("EC", ecPublicKeySpec, BouncyCastleProvider.CONFIGURATION);
    }
}
