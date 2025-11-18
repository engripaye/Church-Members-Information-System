package dev.engripaye.churchmembersinformationsystem.service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.ServiceAccountCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.util.List;

@Service
public class GoogleSheetService {


    @Value("${google.sheet.id}")
    private String sheetId;

    @Value("${google.service.account.key}")
    private String credentialsPath;

    public Sheets GetSheetsService(){

        try {
            var httpTransport = GoogleNetHttpTransport.newTrustedTransport();

            var credentials = ServiceAccountCredentials.fromStream(new FileInputStream(credentialsPath))
                    .createScoped(List.of("https://www.googleapis.com/auth/spreadsheets"));

            return new Sheets.Builder(
                    httpTransport,
                    GsonFactory.getDefaultInstance(),
                    new HttpCredentialsAdapter(credentials)
            )
                    .setApplicationName("MFM CHURCH MEMBER DB")
                    .build();

        }catch (Exception e){
            throw new RuntimeException("Failed to Initialize Google sheets service", e);
        }

    }

}
