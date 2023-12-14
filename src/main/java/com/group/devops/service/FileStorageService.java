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

/**
 * Service for handling file storage operations.
 * This service is responsible for saving files to a specified directory and ensuring file integrity.
 */
@Service
public class FileStorageService {
    final static Logger LOG = LogManager.getLogger(FileStorageService.class);
    private final Path fileStorageLocation;

    /**
     * Creates a new FileStorageService with the specified environment and default storage location.
     *
     * @param env The Spring Environment to resolve properties.
     * @param defaultStorageLocation The default location for file storage.
     */
    public FileStorageService(Environment env, @Value("${app.file-storage-location}") String defaultStorageLocation) {
        String storageLocation = env.getProperty("app.file-storage-docker-location", defaultStorageLocation);
        LOG.debug("Storage location: " + storageLocation);
        this.fileStorageLocation = Paths.get(storageLocation).toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    /**
     * Stores a file in the predefined storage location.
     *
     * @param file The MultipartFile to be stored.
     * @return The path to the stored file.
     * @throws RuntimeException If the file name is invalid or the file can't be stored.
     */
    public String storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        LOG.debug("File name: " + fileName);
        try {
            if(fileName.contains("..")) {
                throw new RuntimeException("Invalid file path");
            }

            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            LOG.debug("Target location: " + targetLocation);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return targetLocation.toString();
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
}
