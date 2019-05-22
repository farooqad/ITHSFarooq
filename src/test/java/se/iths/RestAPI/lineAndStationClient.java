package se.iths.RestAPI;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class lineAndStationClient {


    String apiKey = "d87898db7524460796aeab149387fdd6";
    @Test
    public void confirm_Trip() throws UnirestException {

        //HttpResponse<JsonNode> responseDestination = Unirest.get("https://api.sl.se/api2/LineData.json")
        HttpResponse<JsonNode> response = Unirest.get("https://api.sl.se/api2/LineData.json")
                .queryString("model", "site")
                .queryString("key", apiKey)
                .asJson();
        assertEquals(200, response.getStatus());


        JSONArray sites = response.getBody().getObject().getJSONObject("ResponseData").getJSONArray("Result");
        int siteId =0;
        for (int i = 0; i<sites.length(); i++){
            if ("Liljeholmen".equals(sites.getJSONObject(i).getString("SiteName"))){
                siteId = sites.getJSONObject(i).getInt("SiteId");
            }
        }
        assertEquals(9294, siteId);
        //        .asJson();
        //Assert.assertEquals(200, responseDestination.getStatus());
        //Assert.assertEquals("12:02:00", responseDestination.getBody());

        //responseDestination.getBody().getObject().getJSONArray("Trip").optJSONObject(0).getJSONObject("LegList");
    }
}
