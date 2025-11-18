package dev.engripaye.churchmembersinformationsystem.service;

import dev.engripaye.churchmembersinformationsystem.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final GoogleSheetService googleSheetService;

    public MemberService(MemberRepository memberRepository, GoogleSheetService googleSheetService) {
        this.memberRepository = memberRepository;
        this.googleSheetService = googleSheetService;
    }
}
