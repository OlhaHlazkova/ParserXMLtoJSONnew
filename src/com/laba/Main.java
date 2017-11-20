package com.laba;

import org.json.JSONException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, JSONException {

        String xmlFileName = "D:\\projects\\ParserXMLtoJSON\\src\\com\\laba\\MyXML.xml";
        String jsonFileName = "D:\\projects\\ParserXMLtoJSON\\src\\com\\laba\\MyJson.json";

        Parser parser = new Parser(xmlFileName);

        parser.convertToJsonFile(jsonFileName);
        System.out.println(parser.getStringJson());

    }
}
