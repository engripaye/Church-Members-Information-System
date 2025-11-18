package dev.engripaye.churchmembersinformationsystem.service;

import dev.engripaye.churchmembersinformationsystem.dto.MemberRequest;
import dev.engripaye.churchmembersinformationsystem.model.Member;
import dev.engripaye.churchmembersinformationsystem.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final GoogleSheetService googleSheetService;

    public MemberService(MemberRepository memberRepository, GoogleSheetService googleSheetService) {
        this.memberRepository = memberRepository;
        this.googleSheetService = googleSheetService;
    }


    public Member createMember(MemberRequest request){


        // convert DTO -> entity (this performs DOB -> LocalDateTime -> Age calculation)
        Member member = request.toEntity();

        // save to Postgres
        Member saved = memberRepository.save(member);

        // write to Google Sheets
        googleSheetService.appendMember(member);

        return saved;

    }

    public List<Member> getAll(){
        return memberRepository.findAll();
    }

    public Member getById(Long id){
        return memberRepository.findById(id).orElse(null);
    }

    public boolean deleteById(Long id){
        if(!memberRepository.existsById(id)) return false;
        memberRepository.deleteById(id);
        return true;
    }

}
