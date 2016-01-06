package im.actor.crypto.blocks.impl;

public class ByteStrings {

    public static byte[] longToBytes(long v) {
        byte[] data = new byte[8];
        int offset = 0;
        data[offset++] = (byte) (v & 0xFF);
        data[offset++] = (byte) ((v >> 8) & 0xFF);
        data[offset++] = (byte) ((v >> 16) & 0xFF);
        data[offset++] = (byte) ((v >> 24) & 0xFF);
        data[offset++] = (byte) ((v >> 32) & 0xFF);
        data[offset++] = (byte) ((v >> 40) & 0xFF);
        data[offset++] = (byte) ((v >> 48) & 0xFF);
        data[offset++] = (byte) ((v >> 56) & 0xFF);
        return data;
    }

    public static long bytesToLong(byte[] data) {
        return bytesToLong(data, 0);
    }

    public static long bytesToLong(byte[] data, int offset) {
        long a1 = data[offset + 0] & 0xFF;
        long a2 = data[offset + 1] & 0xFF;
        long a3 = data[offset + 2] & 0xFF;
        long a4 = data[offset + 3] & 0xFF;

        long res1 = (a1) + (a2 << 8) + (a3 << 16) + (a4 << 24);
        offset += 4;

        long b1 = data[offset + 0] & 0xFF;
        long b2 = data[offset + 1] & 0xFF;
        long b3 = data[offset + 2] & 0xFF;
        long b4 = data[offset + 3] & 0xFF;

        long res2 = (b1) + (b2 << 8) + (b3 << 16) + (b4 << 24);
        offset += 4;

        return res1 + (res2 << 32);
    }

    public static byte[] substring(byte[] data, int offset, int size) {
        byte[] res = new byte[size];
        for (int i = 0; i < size; i++) {
            res[i] = data[i + offset];
        }
        return res;
    }

    public static byte[] merge(byte[]... data) {
        int size = 0;
        for (byte[] d : data) {
            size += d.length;
        }
        byte[] res = new byte[size];
        int offset = 0;
        for (byte[] d : data) {
            for (int i = 0; i < d.length; i++) {
                res[offset++] = d[i];
            }
        }
        return res;
    }
}