package com.mjc.stage2.reader.impl;

import com.mjc.stage2.exception.HandlingException;
import com.mjc.stage2.reader.DataReader;
import com.mjc.stage2.validator.impl.FileValidatorImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReaderImpl implements DataReader {
    @Override
    public String readFile(String path) throws HandlingException {
        FileValidatorImpl fileValidator = new FileValidatorImpl();
        if (!fileValidator.validateFilePath(path)) {
            throw new HandlingException("File does not exist or is empty or has an incorrect path.");
        }
        List<String> lines;
        Path filePath = Paths.get(path);
        try (Stream<String> lineStream = Files.lines(filePath)) {
            lines = lineStream.collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            throw new HandlingException("Failed to read the file", e);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String line : lines) {
            stringBuilder.append(line).append("\n");
        }
        return stringBuilder.toString();
    }
}