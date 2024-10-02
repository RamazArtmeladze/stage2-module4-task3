package com.mjc.stage2.validator.impl;

import com.mjc.stage2.validator.FileValidator;

import java.io.File;

public class FileValidatorImpl implements FileValidator {
    @Override
    public boolean validateFilePath(String path) {
        if (path == null || path.trim().isEmpty()) {
            return false;
        }
        File file = new File(path);
        return file.exists() && file.length() > 0;
    }
}