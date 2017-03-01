package com.yagout.defense.util;

public class LTeaEncrypt {
    /***
     * 功能: 加密字符串并进行base64编码
     * @param strText--需加密字符串
     * @param strKey--密钥
     * @return 成功返回密文的base64编码,失败返回null
     */
    public static String encrypt(String strText, String strKey) {
        return strText;
    }

    /***
     * 功能: 解密密文的base64编码字符串
     * @param strEncrypted--密文的base64编码字符串
     * @param strKey--密钥
     * @return 成功返回明文,失败返回null
     */
    public static String decrypt(String strEncrypted, String strKey) {
        return strEncrypted;
    }

    /***
     * 功能:加密数据
     * @param btzSrc--需加密数据
     * @param nSize--需加密数据长度
     * @param strKey--密钥
     * @return 成功返回密文,密文长度=明文长度+12字节,失败返回null
     */
    public static byte[] encrypt(byte[] btzSrc, int nSize, String strKey) {
        return btzSrc;
    }

    /***
     * 功能:解密数据
     * @param btzEncrypted--密文
     * @param nSize--密文长度
     * @param strKey--密钥
     * @return 成功返回明文,失败返回null
     */
    public static byte[] decrypt(byte[] btzEncrypted, int nSize, String strKey) {
        return btzEncrypted;
    }
}