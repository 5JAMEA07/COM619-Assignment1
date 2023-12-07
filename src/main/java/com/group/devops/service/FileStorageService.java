package com.group.devops.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class FileStorageService {
    final static Logger LOG = LogManager.getLogger(FileStorageService.class);
    private final Path fileStorageLocation;


    public FileStorageService(Environment env, @Value("${app.file-storage-location}") String defaultStorageLocation) {
        String storageLocation = env.getProperty("app.file-storage-docker-location", defaultStorageLocation);
        LOG.debug(storageLocation);
        this.fileStorageLocation = Paths.get(storageLocation).toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public String storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        LOG.debug(fileName);
        try {
            if(fileName.contains("..")) {
                throw new RuntimeException("Invalid file path");
            }

            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            LOG.debug(targetLocation);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return targetLocation.toString();
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
}

