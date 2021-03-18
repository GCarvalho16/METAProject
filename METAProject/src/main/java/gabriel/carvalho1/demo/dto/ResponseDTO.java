package gabriel.carvalho1.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private IndicatorDTO indicatorDTO;
    private CountryDTO countryDTO;
    private String countryiso3code;
    private String date;

    public static ResponseDTO fromJson(String json) throws IOException {
        return (ResponseDTO) BaseDTO.fromJson(json, ResponseDTO.class);
    }
}
