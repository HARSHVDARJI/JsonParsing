package com.project.harsh.jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public String strJson = "{\n" +
            "    \"glossary\": {\n" +
            "        \"title\": \"example glossary\",\n" +
            "\t\t\"GlossDiv\": {\n" +
            "            \"title\": \"S\",\n" +
            "\t\t\t\"GlossList\": {\n" +
            "                \"GlossEntry\": {\n" +
            "                    \"ID\": \"SGML\",\n" +
            "\t\t\t\t\t\"SortAs\": \"SGML\",\n" +
            "\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
            "\t\t\t\t\t\"Acronym\": \"SGML\",\n" +
            "\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n" +
            "\t\t\t\t\t\"GlossDef\": {\n" +
            "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
            "\t\t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
            "                    },\n" +
            "\t\t\t\t\t\"GlossSee\": \"markup\"\n" +
            "                }\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "}";
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            JSONObject rootob = new JSONObject(strJson);
            JSONObject glossary = rootob.getJSONObject("glossary");
            String titleGlossary = glossary.getString("title");
            Log.d(TAG,"Title :"+titleGlossary);

            JSONObject GlossDiv = glossary.getJSONObject("GlossDiv");
            String titleGlossDiv = GlossDiv.getString("title");
            Log.d(TAG,"string"+titleGlossDiv);

            JSONObject GlossList = GlossDiv.getJSONObject("GlossList");
            JSONObject GlossEntry = GlossList.getJSONObject("GlossEntry");
            String ID = GlossEntry.getString("ID");
            Log.d(TAG,"string"+ID);
            String SortAs = GlossEntry.getString("SortAs");
            Log.d(TAG,"string"+SortAs);
            String GlossTerm = GlossEntry.getString("GlossTerm");
            Log.d(TAG,"string"+GlossTerm);
            String Acronym = GlossEntry.getString("Acronym");
            Log.d(TAG,"string"+Acronym);
            String Abbrev = GlossEntry.getString("Abbrev");
            Log.d(TAG,"string"+Abbrev);
            String GlossSee = GlossEntry.getString("GlossSee");
            Log.d(TAG,"string"+GlossSee);

            JSONObject GlossDef = GlossEntry.getJSONObject("GlossDef");
//            Log.d(TAG,"string"+GlossDef);
            String para = GlossDef.getString("para");
            Log.d(TAG,"string"+para);

            JSONArray GlossSeeAlso = GlossDef.getJSONArray("GlossSeeAlso");
            for (int i = 0; i <GlossSeeAlso.length() ; i++) {
                Log.d(TAG, "GlossSeeAlso: "+GlossSeeAlso.getString(i));
            }
//
//            glossary.get("glossary");
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
