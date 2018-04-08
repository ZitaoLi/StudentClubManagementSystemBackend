package util;

import java.io.*;

public class ImageBase64Utils {

	public static String bytesToBase64(byte[] bytes) {
        return org.apache.commons.codec.binary.Base64.encodeBase64String(bytes);// ����Base64��������ֽ������ַ���
    }

    /**
     * ��ͼƬ�ļ�ת��Ϊ�ֽ������ַ��������������Base64���봦��
     *
     * @param path ͼƬ·��
     * @return base64�ַ���
     */
    public static String imageToBase64(String path) throws IOException {// ��ͼƬ�ļ�ת��Ϊ�ֽ������ַ��������������Base64���봦��
        byte[] data = null;
        // ��ȡͼƬ�ֽ�����
        InputStream in = null;
        try {
            in = new FileInputStream(path);
            data = new byte[in.available()];
            in.read(data);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return org.apache.commons.codec.binary.Base64.encodeBase64String(data);// ����Base64��������ֽ������ַ���
    }

    /**
     * ����Base64���벢дͼƬ��ָ��λ��
     *
     * @param base64 ͼƬBase64����
     * @param path   ͼƬ����·��
     * @return
     */
    public static boolean base64ToImageFile(String base64, String path) throws IOException {// ���ֽ������ַ�������Base64���벢����ͼƬ
        // ����jpegͼƬ
        try {
            OutputStream out = new FileOutputStream(path);
            return base64ToImageOutput(base64, out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * ����Base64���벢�����
     *
     * @param base64
     * @param out
     * @return
     */
    public static boolean base64ToImageOutput(String base64, OutputStream out) throws IOException {
        if (base64 == null) { // ͼ������Ϊ��
            return false;
        }
        try {
            // Base64����
            byte[] bytes = org.apache.commons.codec.binary.Base64.decodeBase64(base64);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// �����쳣����
                    bytes[i] += 256;
                }
            }
            // ����jpegͼƬ
            out.write(bytes);
            out.flush();
            return true;
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
