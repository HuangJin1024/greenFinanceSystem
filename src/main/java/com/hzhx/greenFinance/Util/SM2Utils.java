package com.hzhx.greenFinance.Util;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.asn1.gm.GMNamedCurves;
import org.bouncycastle.asn1.gm.GMObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.jce.spec.ECPrivateKeySpec;
import org.bouncycastle.jce.spec.ECPublicKeySpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class SM2Utils {

	private static X9ECParameters x9ECParameters = GMNamedCurves.getByName("sm2p256v1");
	private static ECDomainParameters ecDomainParameters = new ECDomainParameters(x9ECParameters.getCurve(),
			x9ECParameters.getG(), x9ECParameters.getN());
	private static ECParameterSpec ecParameterSpec = new ECParameterSpec(x9ECParameters.getCurve(),
			x9ECParameters.getG(), x9ECParameters.getN());

	protected static BigInteger n = new BigInteger(
			"FFFFFFFE" + "FFFFFFFF" + "FFFFFFFF" + "FFFFFFFF" + "7203DF6B" + "21C6052B" + "53BBF409" + "39D54123", 16);
	protected static BigInteger p = new BigInteger(
			"FFFFFFFE" + "FFFFFFFF" + "FFFFFFFF" + "FFFFFFFF" + "FFFFFFFF" + "00000000" + "FFFFFFFF" + "FFFFFFFF", 16);
	protected static BigInteger a = new BigInteger(
			"FFFFFFFE" + "FFFFFFFF" + "FFFFFFFF" + "FFFFFFFF" + "FFFFFFFF" + "00000000" + "FFFFFFFF" + "FFFFFFFC", 16);
	protected static BigInteger b = new BigInteger(
			"28E9FA9E" + "9D9F5E34" + "4D5A9E4B" + "CF6509A7" + "F39789F5" + "15AB8F92" + "DDBCBD41" + "4D940E93", 16);
	protected static BigInteger gx = new BigInteger(
			"32C4AE2C" + "1F198119" + "5F990446" + "6A39C994" + "8FE30BBF" + "F2660BE1" + "715A4589" + "334C74C7", 16);
	protected static BigInteger gy = new BigInteger(
			"BC3736A2" + "F4F6779C" + "59BDCEE3" + "6B692153" + "D0A9877C" + "C62A4740" + "02DF32E5" + "2139F0A0", 16);
	protected static ECDomainParameters ecc_bc_spec;
	protected static int w = (int) Math.ceil(n.bitLength() * 1.0 / 2) - 1;
	protected static BigInteger _2w = new BigInteger("2").pow(w);
	protected static final int DIGEST_LENGTH = 32;

	private static SecureRandom random = new SecureRandom();
	protected static ECCurve.Fp curve;
	protected static ECPoint G;
	protected static boolean debug = false;

	static {
		curve = new ECCurve.Fp(p, // q
				a, // a
				b); // b
		G = curve.createPoint(gx, gy);
		ecc_bc_spec = new ECDomainParameters(curve, G, n);
	}

	/**
	 * 生成公私钥对
	 * 
	 * @param compressedPubKey
	 *            是否压缩公钥
	 * @return
	 */
	public static String[] genKeyPair(boolean compressedPubKey)
			throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
		// 获取SM2 椭圆曲线推荐参数
		X9ECParameters ecParameters = GMNamedCurves.getByName("sm2p256v1");
		// 构造EC 算法参数
		ECNamedCurveParameterSpec sm2Spec = new ECNamedCurveParameterSpec(
				// 设置SM2 算法的 OID
				GMObjectIdentifiers.sm2p256v1.toString()
				// 设置曲线方程
				, ecParameters.getCurve()
				// 椭圆曲线G点
				, ecParameters.getG()
				// 大整数N
				, ecParameters.getN());
		// 创建 密钥对生成器
		KeyPairGenerator gen = KeyPairGenerator.getInstance("EC", new BouncyCastleProvider());
		// 使用SM2的算法区域初始化密钥生成器
		gen.initialize(sm2Spec, new SecureRandom());
		// 获取密钥对
		KeyPair keyPair = gen.generateKeyPair();
		byte buffer[] = ((BCECPublicKey) keyPair.getPublic()).getQ().getEncoded(false);
		String publicKeyStr = Base64.encodeBase64String(buffer);
		String privateKeyStr = ((BCECPrivateKey) keyPair.getPrivate()).getD().toString(16);
		return new String[] { publicKeyStr, privateKeyStr };
	}

	/**
	 * 私钥签名
	 * 
	 * @param privateKeyStr
	 *            私钥
	 * @param plainText
	 *            待签名内容
	 * @return
	 */
	public static String sign(String privateKeyStr, String plainText)
			throws SignatureException, NoSuchAlgorithmException, InvalidKeyException {
		// 生成SM2sign with sm3 签名验签算法实例
		Signature signature = Signature.getInstance(GMObjectIdentifiers.sm2sign_with_sm3.toString(),
				new BouncyCastleProvider());
		// 签名需要使用私钥，使用私钥 初始化签名实例
		signature.initSign(getPrivateKeyFromString(privateKeyStr));
		// 签名原文
		// 写入签名原文到算法中
		signature.update(plainText.getBytes(StandardCharsets.UTF_8));
		// 计算签名值
		byte[] signatureValue = signature.sign();
		return Base64.encodeBase64String(signatureValue);
	}

	/**
	 * 验证签名
	 * 
	 * @param publicKeyStr
	 *            公钥
	 * @param plainText
	 *            待签名内容
	 * @param sign
	 *            签名值
	 * @return
	 */
	public static boolean verify(String publicKeyStr, String plainText, String sign)
			throws SignatureException, NoSuchAlgorithmException, InvalidKeyException {
		Signature signature = Signature.getInstance(GMObjectIdentifiers.sm2sign_with_sm3.toString(),
				new BouncyCastleProvider());
		// 签名需要使用公钥，使用公钥 初始化签名实例
		signature.initVerify(getPublicKeyFromString(publicKeyStr));
		// 写入待验签的签名原文到算法中
		signature.update(plainText.getBytes(StandardCharsets.UTF_8));
		// 验签
		return signature.verify(Base64.decodeBase64(sign));
	}

	/**
	 * 字符串和秘钥对象的转换
	 * 
	 * @param privateKeyStr
	 * @return
	 */
	public static PrivateKey getPrivateKeyFromString(String privateKeyStr) {
		return getPrivatekeyFromD(new BigInteger(privateKeyStr, 16));
	}

	/**
	 * 字符串和秘钥对象的转换
	 * 
	 * @param publicKeyStr
	 * @return
	 */
	public static PublicKey getPublicKeyFromString(String publicKeyStr) {
		byte buffer[] = Base64.decodeBase64(publicKeyStr);
		ECPoint ecPoint = curve.decodePoint(buffer);
		return getPublickeyFromXY(ecPoint.getXCoord().toBigInteger(), ecPoint.getYCoord().toBigInteger());
	}

	@Deprecated
	public static BCECPrivateKey getPrivatekeyFromD(BigInteger d) {
		ECPrivateKeySpec ecPrivateKeySpec = new ECPrivateKeySpec(d, ecParameterSpec);
		return new BCECPrivateKey("EC", ecPrivateKeySpec, BouncyCastleProvider.CONFIGURATION);
	}

	@Deprecated
	public static BCECPublicKey getPublickeyFromXY(BigInteger x, BigInteger y) {
		ECPublicKeySpec ecPublicKeySpec = new ECPublicKeySpec(x9ECParameters.getCurve().createPoint(x, y),
				ecParameterSpec);
		return new BCECPublicKey("EC", ecPublicKeySpec, BouncyCastleProvider.CONFIGURATION);
	}
}
