/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package org.example;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.NumberUtil;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * TODO 描述
 *
 * @date 2024/9/9 20:19
 */
public class Core {
    public static void main(String[] args) throws IOException {
//        encrypt("C:\\Users\\Administrator\\Downloads");
        decrypt("C:\\Users\\Administrator\\Downloads");
    }

    public static void encrypt(String zipPath) throws IOException {
        // 读取文件，文件分片，在第索引个字节上插入字符 7
        // 修改文件后缀.seven 输出到 文件名_encrypt/文件名_索引.seven
        int chunkSize = 1024 * 10; // 1MB
        byte[] buffer = new byte[chunkSize];
        BufferedInputStream inputStream = FileUtil.getInputStream(zipPath);
        String chunkFilePath = FileUtil.getParent(zipPath, 1) + "/" + FileUtil.getName(zipPath) + "_encrypt/";
        File file = new File(chunkFilePath);
        if (!file.exists()) {
            file.canExecute();
        }
        int index = 0;
        while (true) {
            int bytesRead = inputStream.read(buffer);
            if (bytesRead == -1) {
                break;
            }
            FileUtil.writeBytes(add2Array(buffer, index, (byte) 7),
                chunkFilePath + FileUtil.getName(zipPath) + "_" + index + ".seven");
            index++;
        }
        inputStream.close();
    }

    public static byte[] add2Array(byte[] arr, int index, byte data) {
        if (index >= arr.length) {
            return arr;
        }
        // 创建一个新的数组，长度比原数组多1
        byte[] newArr = new byte[arr.length + 1];
        // 将原数组的前index个元素复制到新数组中
        if (index >= 0) {
            System.arraycopy(arr, 0, newArr, 0, index);
        }
        // 将要插入的数字插入到新数组的index位置
        newArr[index] = data;
        // 将原数组的index及其后面的元素复制到新数组中
        if (arr.length - index >= 0) {
            System.arraycopy(arr, index, newArr, index + 1, arr.length - index);
        }
        return newArr;
    }

    public static byte[] remove2Array(byte[] arr, int index) {
        if (index >= arr.length) {
            return arr;
        }
        // 创建一个新的数组，长度比原数组少1
        byte[] newArr = new byte[arr.length - 1];
        // 将原数组的前index个元素复制到新数组中
        if (index >= 0) {
            System.arraycopy(arr, 0, newArr, 0, index);
        }
        if (arr.length - (index + 1) >= 0) {
            System.arraycopy(arr, index + 1, newArr, index + 1 - 1, arr.length - (index + 1));
        }
        return newArr;
    }

    public static void decrypt(String encryptDir) throws IOException {
        // 读取所有文件，解析索引 删除第索引个字节流
        // 合并
        List<File> files = FileUtil.loopFiles(encryptDir, pathname -> pathname.getName().endsWith(".seven"));
        files.sort((o1, o2) -> getFileIndex(o1) - getFileIndex(o2));

        FileOutputStream fileOutputStream = new FileOutputStream(encryptDir + "/decrypt.zip");
        for (File file : files) {
            int fileIndex = getFileIndex(file);
            byte[] bytes = FileUtil.readBytes(file);
            fileOutputStream.write(remove2Array(bytes, fileIndex));
        }
        fileOutputStream.close();
    }

    private static int getFileIndex(File file) {
        String name = file.getName();
        String[] s = name.split("_");
        String[] split = s[1].split("\\.");
        return NumberUtil.parseInt(split[0]);
    }
}
