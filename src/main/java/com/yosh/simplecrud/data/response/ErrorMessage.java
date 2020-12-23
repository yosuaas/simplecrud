package com.yosh.simplecrud.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yosh.simplecrud.constant.JsonKeyConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

    @JsonProperty(JsonKeyConstant.ERROR_MSG_ID)
    private String indonesian;

    @JsonProperty(JsonKeyConstant.ERROR_MSG_EN)
    private String english;
}
