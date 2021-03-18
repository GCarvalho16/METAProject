package gabriel.carvalho1.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageResponseDTO {

    private Integer page;
    private Integer pages;
    private Integer per_page;
    private Integer total;
    private String sourceid;
    private String lastupdated;
    private List<ResponseDTO> responses;

    public static PageResponseDTO fromJson(String json) throws IOException {
        return (PageResponseDTO) BaseDTO.fromJson(json, PageResponseDTO.class);
    }
}
