package gabriel.carvalho1.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import gabriel.carvalho1.demo.dto.PageResponseDTO;
import gabriel.carvalho1.demo.util.RestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.Objects;

@Service
@Slf4j
public class WorldBankService {
    private String errorUrl = "http://api.worldbank.org/v2/country/%s/indicator/SI.POV.DDAY?format=json";

    public String getErrorUrl() {
        return errorUrl;

    }
    public PageResponseDTO execute(String codigoDoPais) throws IOException {
        StringBuilder body = new StringBuilder(Objects.requireNonNull(callApi(codigoDoPais).getBody()));
        body.deleteCharAt(body.length()-1);
        body.deleteCharAt(0);

        return PageResponseDTO.fromJson(body.toString());

    }

    public ResponseEntity<String> callApi(String codigoDoPais) {
        return RestUtil.get(String.format(errorUrl, codigoDoPais), new HttpEntity<>(headersApiCall()));
    }

    protected static HttpHeaders headersApiCall() {
        HttpHeaders headers = new HttpHeaders();
        MediaType mediaType = MediaType.APPLICATION_JSON;
        headers.setAccept(Collections.singletonList(mediaType));

        return headers;
    }

}
