package com.laba;

import org.json.*;

import java.io.*;
import java.lang.String;

/**
 * Created by Olya on 11/19/2017.
 */
public class Parser {

    private String xmlContent;
    private static int PRETTY_PRINT_INDENT_FACTOR = 3;

    public Parser() throws IOException {
    }

    public Parser(String filename) throws IOException {
        xmlContent = getStringFromXMLFile(filename);
    }

    private JSONObject toJson () throws JSONException {
           return XML.toJSONObject(xmlContent);
    }

    public void convertToJsonFile(String jsonFileName) throws IOException, JSONException {
        File file=new File(jsonFileName);
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write(getStringJson());
        fileWriter.flush();
        fileWriter.close();
    }

    private String getStringFromXMLFile (String fileName) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
        String line = "";

        StringBuilder sb = new StringBuilder();

        while((line = br.readLine())!= null){
            char q [] = line.toCharArray();
            for (int i = 0; i<q.length; i++){
                if(q[i]=='<'){
                    sb.append(line.substring(i));
                    break;
                }
            }
        }
        return sb.toString();
    }

    public String getStringJson() throws JSONException {

        String jsonPrettyPrintString = toJson().toString(PRETTY_PRINT_INDENT_FACTOR);
        return jsonPrettyPrintString;
    }

}
