package com.yosh.simplecrud.data.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yosh.simplecrud.constant.JsonKeyConstant;
import com.yosh.simplecrud.enumeration.ResponseCollection;
import org.springframework.http.HttpStatus;
import lombok.Data;

@Data
public class Response {

    @JsonIgnore
    private HttpStatus httpStatus;

    @JsonProperty(JsonKeyConstant.ERROR_CODE)
    private String errorCode;

    @JsonProperty(JsonKeyConstant.ERROR_MSG)
    private ErrorMessage errorMessage;

    public void setResponse(ResponseCollection responseCollection) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setIndonesian(responseCollection.getErrorMessageId());
        errorMessage.setEnglish(responseCollection.getErrorMessageEn());

        this.errorCode = responseCollection.getErrorCode();
        this.errorMessage = errorMessage;
        this.httpStatus = responseCollection.getHttpStatus();
    }
}
