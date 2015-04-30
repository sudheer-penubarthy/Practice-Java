package com.sudheer.samples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * Created by sudheer on 30/4/15.
 */
public class fileCopy {

    public void fileCopyNioImplementation(File parent, File copy) throws IOException {

        // Create the FileChannel for input and output
        FileChannel input = new FileInputStream(parent).getChannel();
        FileChannel output = new FileOutputStream(copy).getChannel();
        try {
            //input.transferTo(0, input.size(), output);

            int maxCount = (64 * 1024 * 1024) - (32 * 1024);
            long size = input.size();
            long position = 0;
            while (position < size) {
                position += input.transferTo(position, maxCount, output);
            }
        } finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
        }
    }

    public void fileCopyNioImplementationWithTranferTo(File parent, File copy) throws IOException {
        // Create the FileChannel for input and output
        FileChannel input = new FileInputStream(parent).getChannel();
        FileChannel output = new FileOutputStream(copy).getChannel();
        input.transferTo(0, input.size(), output);
    }

    public void fileCopyNioImplementationWithTranferFrom(File parent, File copy) throws IOException {
        // Create the FileChannel for input and output
        FileChannel input = new FileInputStream(parent).getChannel();
        FileChannel output = new FileOutputStream(copy).getChannel();
        //output.transferFrom(input, 0, output);
        input.transferTo(0, input.size(), output);
    }
}
