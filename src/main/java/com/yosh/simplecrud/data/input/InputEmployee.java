package com.yosh.simplecrud.data.input;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yosh.simplecrud.constant.JsonKeyConstant;
import lombok.Data;

@Data
public class InputEmployee {

    @JsonProperty(JsonKeyConstant.ID)
    private String id;

    @JsonProperty(JsonKeyConstant.NIK)
    private String nik;

    @JsonProperty(JsonKeyConstant.NAME)
    private String name;

    @JsonProperty(JsonKeyConstant.ADDRESS)
    private String address;

    @JsonProperty(JsonKeyConstant.DOB)
    private Date dob;

}
