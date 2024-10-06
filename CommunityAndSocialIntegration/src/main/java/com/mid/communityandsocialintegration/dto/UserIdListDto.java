package com.mid.communityandsocialintegration.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserIdListDto {
    private List<String> userIds;
}
