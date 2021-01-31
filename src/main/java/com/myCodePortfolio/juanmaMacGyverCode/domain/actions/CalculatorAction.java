package com.myCodePortfolio.juanmaMacGyverCode.domain.actions;

import com.myCodePortfolio.juanmaMacGyverCode.application.dto.DtoTwoNumbers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculatorAction {

    public String add(DtoTwoNumbers dtoTwoNumbers){
        return String.valueOf(Integer.parseInt(dtoTwoNumbers.getNumber1()) + Integer.parseInt(dtoTwoNumbers.getNumber2()));
    }
}
