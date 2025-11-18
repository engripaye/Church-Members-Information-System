package dev.engripaye.churchmembersinformationsystem.controller;


import dev.engripaye.churchmembersinformationsystem.dto.MemberRequest;
import dev.engripaye.churchmembersinformationsystem.model.Member;
import dev.engripaye.churchmembersinformationsystem.repository.MemberRepository;
import dev.engripaye.churchmembersinformationsystem.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;


    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody MemberRequest request){
        return ResponseEntity.ok(memberService.createMember(request));

    }

    @GetMapping
    public ResponseEntity <List<Member>> getAllMembers(){
        return ResponseEntity.ok(memberService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id){
        Member member = memberService.getById(id);
        return (member != null)
                ? ResponseEntity.ok(member)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        boolean deleted = memberService.deleteById(id);
        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

}
