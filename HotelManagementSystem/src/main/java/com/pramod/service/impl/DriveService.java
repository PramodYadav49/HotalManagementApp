package com.pramod.service.impl;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

import org.springframework.web.multipart.MultipartFile;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;

@org.springframework.stereotype.Service
public class DriveService {
    private static final com.google.api.client.json.JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String SERVICE_ACCOUNT_KEY_PATH = getPathToGoogleCredentials();

    private static String getPathToGoogleCredentials() {
        String currentDirectory = System.getProperty("user.dir");
        Path filePath = Paths.get(currentDirectory, "cred.json");
        return filePath.toString();
    }

    public String uploadImageToDrive(java.io.File photo) {
       String url="";
        try {
            // Replace with your actual folder ID
            String folderId = "1PeDuIUWgWPN4RiJh0oieUoNd7BUpI_P_";
            Drive drive = createDriveService();

            File fileMetadata = new File();
            fileMetadata.setName(photo.getName());
            fileMetadata.setParents(Collections.singletonList(folderId));

            FileContent mediaContent = new FileContent("image/jpeg", (java.io.File) photo);
            File uploadedFile = drive.files()
                                      .create(fileMetadata, mediaContent)
                                      .setFields("id")
                                      .execute();

            String imageUrl = "https://drive.google.com/uc?export=view&id=" + uploadedFile.getId();
            System.out.println("IMAGE URL: " + imageUrl);
            url=url+imageUrl;

            photo.delete();

            
        } catch (Exception e) {
            e.printStackTrace();
           
        }
        return url;
    }

    private Drive createDriveService() throws Exception {
        GoogleCredential credential = GoogleCredential.fromStream(new FileInputStream(SERVICE_ACCOUNT_KEY_PATH))
                                                       .createScoped(Collections.singleton(DriveScopes.DRIVE));
        return new Drive.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JSON_FACTORY,
                credential
        ).build();
    }
}
