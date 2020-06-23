package com.example.backendkyc.payload;

import java.util.List;

public class DataTableParser {
    public static DataTableResponse parse(List data){
        DataTableResponse response = new DataTableResponse();
        response.setData(data);
        response.setDraw(1);
        response.setRecordsTotal(1);
        response.setRecordsFiltered(1);
        return response;
    }

    public static DataTableResponse parse(List data, int draw, int total){
        DataTableResponse response = new DataTableResponse();
        response.setData(data);
        response.setDraw(draw);
        response.setRecordsTotal(total);
        response.setRecordsFiltered(total);
        return response;
    }
    public static DataTableResponse parse(List data, int draw, int total, int page){
        DataTableResponse response = new DataTableResponse();
        response.setData(data);
        response.setDraw(draw);
        response.setRecordsTotal(total);
        response.setRecordsFiltered(total);
        response.setPage(page);
        return response;
    }
}
