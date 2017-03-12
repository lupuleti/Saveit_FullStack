package com.studenthackv.controller;

public class Mainasda {
//  public static void main(String[] args) {
//    JSONObject response = null;
//    BulkRequest bulk = new BulkRequest();
//    JSONObject bulkStatus = bulk.request("00885909666966\n08718108041581",
//        "google-shopping", "de", "gtin");
//    String jobId = "";
//    try {
//      jobId = (String) bulkStatus.get("job_id");
//    } catch (JSONException e1) {
//      e1.printStackTrace();
//      return;
//    }
//
//    Boolean done = false;
//    while (!done) {
//      try {
//        Thread.sleep(refreshInterval);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//      bulkStatus = bulk.getStatus(jobId);
//
//      Boolean isComplete = false;
//      try {
//        String status = (String) bulkStatus.get("status");
//        isComplete = status.equals("finished");
//      } catch (JSONException e) {
//        e.printStackTrace();
//      }
//      if (isComplete) {
//        response = bulk.getResults(jobId, "json");
//        done = true;
//      }
//    }
//    System.out.println(response.toString());
//  }
//
//  public JSONObject request(
//      String values, String source, String country,
//      String key) {
//    String st = "token=%s&source=%s&country=%s&key=%s&values=%s";
//    String query = String.format(st, token, source, country, key, values);
//
//    String response = postRequest("/jobs", query);
//
//    System.out.println(response);
//    JSONObject json = null;
//    try {
//      json = new JSONObject(response);
//    } catch (JSONException e) {
//      e.printStackTrace();
//    }
//    return json;
//  }
//
//  public JSONObject getStatus(String jobId) {
//    String response = getRequest("/jobs/" + jobId, "token=" + token);
//
//    System.out.println(response);
//    JSONObject json = null;
//    try {
//      json = new JSONObject(response);
//    } catch (JSONException e) {
//      e.printStackTrace();
//    }
//    return json;
//  }
//
//  public JSONObject getResults(String jobId, String format) {
//    String response = getRequest("/products/bulk/" + jobId + '.' + format,
//        "token=" + token);
//
//    System.out.println(response);
//    JSONObject json = null;
//    try {
//      json = new JSONObject(response);
//    } catch (JSONException e) {
//      e.printStackTrace();
//    }
//    return json;
//  }
//
//  private String getRequest(String path, String query) {
//    String response = "";
//
//    try {
//      URI uri = new URI("https", "api.priceapi.com", path, query, null);
//      URL url = uri.toURL();
//      URLConnection conn = url.openConnection();
//      BufferedReader br = new BufferedReader(new InputStreamReader(
//          conn.getInputStream()));
//
//      String inputLine;
//      while ((inputLine = br.readLine()) != null) {
//        response += inputLine;
//      }
//      br.close();
//    } catch (IOException | URISyntaxException e) {
//      e.printStackTrace();
//    }
//    return response;
//  }
//
//  private String postRequest(String path, String query) {
//    String response = "";
//
//    try {
//      URI uri = new URI("https", "api.priceapi.com", path, null);
//      URL url = uri.toURL();
//      URLConnection conn = url.openConnection();
//      conn.setDoOutput(true);
//
//      OutputStreamWriter writer = new OutputStreamWriter(
//          conn.getOutputStream());
//      writer.write(query);
//      writer.flush();
//
//      BufferedReader reader = new BufferedReader(new InputStreamReader(
//          conn.getInputStream()));
//
//      String inputLine;
//      while ((inputLine = reader.readLine()) != null) {
//        response += inputLine;
//      }
//      reader.close();
//    } catch (IOException | URISyntaxException e) {
//      e.printStackTrace();
//    }
//    return response;
//  }
//}
}
