package gabriel.carvalho1.demo.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class RestUtil {

    private RestUtil() {
    }

    public static ResponseEntity<String> exchange(String url, HttpMethod method, HttpEntity<?> entity){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(url, method, entity, String.class);
    }

    public static ResponseEntity<String> post(String url, HttpEntity<?> entity){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(url, entity, String.class);
    }

    public static ResponseEntity<String> get(String url, HttpEntity<?> entity){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(url, String.class, entity);
    }

    public static ResponseEntity<String> get(String url){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(url, String.class);
    }

    public static URI getCurrentUrl(HttpServletRequest request) throws MalformedURLException, URISyntaxException {
        URL url = new URL(request.getRequestURL().toString());
        String host = url.getHost();
        String userInfo = url.getUserInfo();
        String scheme = url.getProtocol();
        int port = url.getPort();
        String path = (String) request.getAttribute("javax.servlet.forward.request_uri");
        String query = (String) request.getAttribute("javax.servlet.forward.query_string");
        return new URI(scheme,userInfo,host,port,path,query,null);
    }

}
