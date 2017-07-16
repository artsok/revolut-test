package com.revolut.qa.utils.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * Developed by sokovets-av
 *
 *
 */
@Data
@AllArgsConstructor
public class BeneficiaryInfo {
    private String itemTitle;
    private String accountNumber;
    private String sortCode;
}
