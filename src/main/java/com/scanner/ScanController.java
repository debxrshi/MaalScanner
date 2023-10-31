package com.scanner;

import com.dao.ScanDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.JSONObject;

import okhttp3.Response;

import java.io.File;
import java.io.IOException;


@WebServlet("/UploadHandler")

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 34
)


public class ScanController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	final String  uploadDir = "C:\\Users\\debxrshi\\eclipse-workspace\\MalwareScanner\\src\\main\\webapp\\uploads";
	String fileName = null;
	ScanUtils scan = new ScanUtils();
	ScanDAO dbHandle = new ScanDAO();


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = processFileUpload(request);
		File file = new File(uploadDir + File.separator + fileName);		
		String hash = scan.buildHash(file);
		
		try {
			// verify if hash exists in DB
			if(!dbHandle.DbFetch(hash)) {
				generateReport(file, hash);
			}
			//redirect to result.jsp with hash param to parse in scriptlet
			response.sendRedirect("result.jsp?val=" + hash);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
// method to process servlet fileupload
	private String processFileUpload(HttpServletRequest request) throws IOException, ServletException {
		String fileName = null;
		for (Part filePart : request.getParts()) {
			fileName = filePart.getSubmittedFileName();
			filePart.write(uploadDir + File.separator + fileName);
		}
		return fileName;
	}
// method to generate report
	private void generateReport(File file, String hash) throws IOException {
		while(true) {
			try {
				Response reportResponse = scan.getReport(hash);			
				if (!reportResponse.isSuccessful()) {			
					scan.uploadFile(file); 
					throw new IOException("Unexpected code " + reportResponse);		        	
				}
				String responseString = reportResponse.body().string();
				JSONObject json = new JSONObject(responseString);
				if (!json.getJSONObject("data").getJSONObject("attributes").getJSONObject("last_analysis_results").isEmpty()) {
					dbHandle.DbPost(fileName, hash, responseString);
					break;
				}
				Thread.sleep(30000);   
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}