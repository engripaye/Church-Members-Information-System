package dev.engripaye.churchmembersinformationsystem.service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.ServiceAccountCredentials;
import dev.engripaye.churchmembersinformationsystem.model.Member;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Service
public class GoogleSheetService {


    @Value("${google.sheet.id}")
    private String sheetId;

    @Value("${google.service.account.key}")
    private String credentialsPath;

    public Sheets getSheetsService(){

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

    public void appendMember(Member member){

        Sheets sheets = getSheetsService();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<Object> rows = List.of(
                member.getName(),
                member.getSex(),
                member.getContact(),
                member.getDateOfBirth().format(dateFormatter),
                member.getAge(), // backend only
                member.getAddress(),
                member.getSuggestion(),
                member.getPrayerPoint()
        );


    }

}
