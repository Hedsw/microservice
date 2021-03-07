package com.javatest.ps.api.controller;

import com.javatest.ps.api.common.FileUploadResponse;
import com.javatest.ps.api.service.FileStorageService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class UploadDownloadWithFileSystemController {
    private FileStorageService fileStorageService;

    public UploadDownloadWithFileSystemController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("single/upload")
    FileUploadResponse singleFileUpload(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        // Http://localhost:9193/download/abc.jpg
        String url = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download")
                .path(fileName)
                .toUriString();

        String contentType = file.getContentType();
        FileUploadResponse response = new FileUploadResponse(fileName, contentType, url);

        return response;
    }

    @GetMapping("/download/{fileName}")
    ResponseEntity<Resource>downLoadSingleFile(@PathVariable String fileName) {
        Resource resource = fileStorageService.downloadFile(fileName);

        MediaType contentType = MediaType.IMAGE_JPEG;

        return  ResponseEntity.ok()
                .contentType(contentType)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;fileName=" +resource.getFilename())
                .body(resource);

    }
}
