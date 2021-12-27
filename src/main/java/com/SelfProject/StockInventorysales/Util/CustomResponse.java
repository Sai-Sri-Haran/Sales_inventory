package com.SelfProject.StockInventorysales.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomResponse {
    private boolean status ;
    private int status_code;
    private String message ;
    private Object data;
}
