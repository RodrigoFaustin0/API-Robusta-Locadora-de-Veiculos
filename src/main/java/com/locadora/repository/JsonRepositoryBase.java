package com.locadora.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// Classe abstrata genérica, que serve como base para repositórios que salvam dados em arquivos JSON
public abstract class JsonRepositoryBase<T> {
    
    //Faz toda a conversão entre JSON e objetos Java
    protected final ObjectMapper mapper = new ObjectMapper();
    private final Class<T> clazz;
    private final String filePath;

    // Construtor 
    protected JsonRepositoryBase(Class<T> clazz, String fileName) {
        this.clazz = clazz;
        String resourcesPath = "src/main/resources/data/" + fileName;
        File f = Paths.get(resourcesPath).toFile();
        this.filePath = f.exists() ? resourcesPath : "./data/" + fileName;
    }

    /*
        - Lê uma lista do JSON
        - Impede que dois threads acessem o arquivo ao mesmo tempo.
    */ 
    protected synchronized List<T> readAll() {
        try {
            File file = new File(filePath);
            if (!file.exists()) return new ArrayList<>();
            CollectionType listType = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
            return mapper.readValue(file, listType);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler " + filePath + ": " + e.getMessage(), e);
        }
    }
    
    /*
        - Grava a lista no JSON
    */
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
