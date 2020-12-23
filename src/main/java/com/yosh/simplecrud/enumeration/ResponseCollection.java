package com.yosh.simplecrud.enumeration;

import org.springframework.http.HttpStatus;
import lombok.Getter;

public enum ResponseCollection {
    //@formatter:off
    SUCCESS("ECRD-100", "Sukses", "Success", HttpStatus.OK), 
    EMPLOYEE_NOT_FOUND("ECRD-200", "Karyawan tidak ditemukan", "Employee not found", HttpStatus.NOT_FOUND),
    EMPLOYEE_NIK_FOUND("ECRD-201", "NIK Karyawan ditemukan", "NIK found", HttpStatus.NOT_ACCEPTABLE);
    
    //@formatter:on

    @Getter
    private String errorCode;
    @Getter
    private String errorMessageId;
    @Getter
    private String errorMessageEn;
    @Getter
    private HttpStatus httpStatus;

    ResponseCollection(String errorCode, String errorMessageId, String errorMessageEn,
            HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.errorMessageId = errorMessageId;
        this.errorMessageEn = errorMessageEn;
        this.httpStatus = httpStatus;
    }

    @Override
    public String toString() {
        return "ResponseCollection{" + "errorCode='" + errorCode + '\'' + ", errorMsgId='"
                + errorMessageId + '\'' + ", errorMsgEn='" + errorMessageEn + '\'' + ", httpStatus="
                + httpStatus + '}';
    }
}
