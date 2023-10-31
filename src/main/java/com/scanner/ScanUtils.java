package com.scanner;


import java.io.File;
import java.io.IOException;

import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import com.model.ScanResultStruct;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.json.JSONObject;

import java.util.List;
import java.util.ArrayList;


public class ScanUtils {
	public static final String fileURL = "https://www.virustotal.com/api/v3/files";
    public static String hashURL = "https://www.virustotal.com/api/v3/files/%s";
    public static String fileReportURL = "https://www.virustotal.com/api/v3/analyses/%s";
    public static String fileReScanURL = "https://www.virustotal.com/api/v3/files/%s/analyse";
    public static final String apiKey = "c62de0c237f96b7bdbb9b49b8e631e15b9afcd1c0bd49ab9d007457f3710afde";
    static OkHttpClient client = new OkHttpClient();
    
    
    @SuppressWarnings("deprecation")
   	public  void  uploadFile(File file) throws IOException, InterruptedException {
   		
           RequestBody requestBody = new MultipartBody.Builder()
                   .setType(MultipartBody.FORM)
                   .addFormDataPart("file", file.getName(),
                   RequestBody.create(MediaType.parse("application/octet-stream"), file))
                   .build();

           Request request = new Request.Builder()
                   .url(fileURL)
                   .header("x-apikey", apiKey)
                   .header("accept", "application/json")
                   .post(requestBody)
                   .build();
           
   		 client.newCall(request).execute();     
  }
 	
   	public  Response  getReport(String hash) throws IOException, InterruptedException {
   		
           hashURL =  String.format(hashURL, hash);
   		
   			Request request = new Request.Builder()
   						.url(hashURL)
   		            	.get()
   		            	.header("x-apikey", apiKey)
   		            	.header("accept", "application/json")
   		            	.build();
   				
   		 Response  hashResponse = client.newCall(request).execute();
   		 
   		 return hashResponse;  		 
   	}
   	
   	public String buildHash(File file) throws IOException {
   		byte[] fileBytes = Files.toByteArray(file);
           return Hashing.sha256()
                   .hashBytes(fileBytes)
                   .toString();
   	}
   	 
   	public String fileReScan(String hash) throws IOException {
		
   		fileReScanURL = String.format(fileReScanURL, hash);
   		Request request = new Request.Builder()
   			  .url(fileReScanURL)
   			  .post(null)
   			  .header("accept", "application/json")
   			  .build();
   		
   		Response reScanResponse = client.newCall(request).execute();
   		return reScanResponse.body().string();
   		
   	}

   	public List<ScanResultStruct> scanResultParser(String json) {                         
   	
   		JSONObject jsonObject = new JSONObject(json);
   		List<ScanResultStruct> structs = new ArrayList<>();
   		ScanResultStruct structResult = new ScanResultStruct();

       	    
   		JSONObject lastAnalysisResults  = 	jsonObject.getJSONObject("data").getJSONObject("attributes").getJSONObject("last_analysis_results");
       	 
//   		JSONObject fileType = jsonObject.getJSONObject("data").getJSONObject("attributes").getJSONObject("f");
   		
   		// TODO Implement iterator to iterate over the last analyis results Object
   		
   		for(String key : lastAnalysisResults.keySet()){
   			structResult.setCategory(lastAnalysisResults.getJSONObject(key).getString("category"));
   			structResult.setEngineName(lastAnalysisResults.getJSONObject(key).getString("engine_name"));
   			structs.add(structResult);
   	}
   		return structs;

   }
}

