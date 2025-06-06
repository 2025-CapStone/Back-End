package com.springboot.club_house_api_server.openai.analyze.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomRequestDto {
    private String model;
    private List<MessageDto> messages;

}
