package dev.engripaye.churchmembersinformationsystem.controller;


import dev.engripaye.churchmembersinformationsystem.repository.MemberRepository;
import dev.engripaye.churchmembersinformationsystem.service.MemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;


    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }



}
