package com.locadora.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public abstract class JsonRepositoryBase<T> {

    // ObjectMapper configurado corretamente para LocalDate e LocalDateTime
    protected final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    private final Class<T> clazz;
    private final String filePath;

    protected JsonRepositoryBase(Class<T> clazz, String fileName) {
        this.clazz = clazz;
        String resourcesPath = "src/main/resources/data/" + fileName;
        File f = Paths.get(resourcesPath).toFile();
        this.filePath = f.exists() ? resourcesPath : "./data/" + fileName;
    }

    protected synchronized List<T> readAll() {
        try {
            File file = new File(filePath);
            if (!file.exists()) return new ArrayList<>();

            CollectionType listType =
                    mapper.getTypeFactory().constructCollectionType(List.class, clazz);

            return mapper.readValue(file, listType);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler " + filePath + ": " + e.getMessage(), e);
        }
    }

    protected synchronized void writeAll(List<T> list) {
        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs();
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, list);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao escrever " + filePath + ": " + e.getMessage(), e);
        }
    }
}
