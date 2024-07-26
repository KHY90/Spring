package com.ohgiraffers.chap02securityjwt.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.JSONParser;


public class ConvertUtil {

    private static Object convertObjectToJsonObject(Object obj) {

        ObjectMapper mapper = new ObjectMapper();
        JSONParser parser = new JSONParser();
        String concertJsonString;
        Object convertObj;

        try
    }
}
