package capstone.interback.web;

import capstone.interback.service.sttLog.SttLogService;
import capstone.interback.web.dto.RoomSaveRequestDto;
import capstone.interback.web.dto.SttLogSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class SttApiController {

    private final SttLogService sttLogService;

    @Autowired
    ResourceLoader resourceLoader;

    @PostMapping("/stt")
    public String sttApi(@RequestBody Map<String, String> map){
        String clientId = "91kzy8eps2";             // Application Client ID";
        String clientSecret = "I6kLxePix9QW5exWROiQDuQzDU2oy0UgYlCn4vIH";     // Application Client Secret";

        String base64 = map.get("base64data");
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decoded = decoder.decode(base64);
        InputStream b_in = new ByteArrayInputStream(decoded);
        DataOutputStream dos = null;

        Resource resource = resourceLoader.getResource("classpath:stt_result.wav");

        try {
            File deleteFile = new File(String.valueOf(resource));
            if(deleteFile.exists()){
                deleteFile.delete();
            }
            File file = new File(String.valueOf(resource));
            FileOutputStream os = new FileOutputStream(file, true);
            os.write(decoded);
            os.close();
            try {

                String language = "Kor";        // 언어 코드 ( Kor, Jpn, Eng, Chn )
                String apiURL = "https://naveropenapi.apigw.ntruss.com/recog/v1/stt?lang=" + language;
                URL url = new URL(apiURL);

                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setUseCaches(false);
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setRequestProperty("Content-Type", "application/octet-stream");
                conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
                conn.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

                OutputStream outputStream = conn.getOutputStream();
                FileInputStream inputStream = new FileInputStream(file);
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                outputStream.flush();
                inputStream.close();
                BufferedReader br = null;
                int responseCode = conn.getResponseCode();
                if(responseCode == 200) { // 정상 호출
                    br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                } else {  // 오류 발생
                    System.out.println("error!!!!!!! responseCode= " + responseCode);
                    br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    return "error!!!!!!! responseCode= ";
                }
                String inputLine;

                if(br != null) {
                    StringBuffer response = new StringBuffer();
                    while ((inputLine = br.readLine()) != null) {
                        response.append(inputLine);
                    }
                    br.close();
                    System.out.println(response.toString());
                    return response.toString();
                } else {
                    System.out.println("error !!!");
                    return "error !!!";
                }
            } catch (Exception e) {
                System.out.println(e);
                return e.toString();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return e.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    @PostMapping("/stt/save")
    public Long save(@RequestBody SttLogSaveRequestDto requestDto){
        return sttLogService.save(requestDto);
    }
}
