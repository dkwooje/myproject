package com.TeamNull.LostArk.LostArk.controller;

import com.TeamNull.LostArk.LostArk.controller.dto.OuterDataDto;
import com.TeamNull.LostArk.LostArk.service.OuterDataService;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OuterDataController {

    private final OuterDataService outerDataService;

    // 목표 : Get 요청 시 api로부터 데이터를 받아와 저장 후 반환하도록 구현.

    @GetMapping("/statistics/alluser")
    public List<OuterDataDto> alluser() {
        List<OuterDataDto> resData = outerDataService.read();
        return resData;
    }

    // 데이터 저장 테스트용 메서드
    @PutMapping("/statistics/alluser")
        public void createAlluser() throws IOException, ParseException{
        outerDataService.create();
    }


}
