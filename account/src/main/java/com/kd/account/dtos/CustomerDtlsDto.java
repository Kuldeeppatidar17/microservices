package com.kd.account.dtos;

import lombok.Data;

@Data
public class CustomerDtlsDto {
    private AccountResponse accountResponse;
    private CardDto cardResponse;
}
