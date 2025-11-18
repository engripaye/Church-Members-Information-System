package dev.engripaye.churchmembersinformationsystem.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GoogleSheetService {


    @Value("${google.sheet.id}")
    private String sheetId;

    @Value("${google.service.account.key}")
    private String credentialsPath;

    public Sheets GetSheetsService(){

    }

}
