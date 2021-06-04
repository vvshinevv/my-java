package com.myjava.nio;

import java.nio.ByteBuffer;

public class DirectByteBufferCheck {

    public static void main(String[] args) {
        DirectByteBufferCheck check = new DirectByteBufferCheck();

        for (int i = 0 ; i < 10244000 ; i++) {
            ByteBuffer directByteBuffer = check.getDirectByteBuffer();
            if (i % 100 == 0) {
                System.out.println(i);
            }
        }
    }

    private ByteBuffer getDirectByteBuffer() {
        ByteBuffer byteBuffer;
        byteBuffer = ByteBuffer.allocateDirect(65536);
        return byteBuffer;
    }
}
