package com.eletronica.JJProject.data.dto.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"id", "name", "type"})
public class SearchDTO extends RepresentationModel<SearchDTO> implements Serializable {

    @JsonProperty("id")
    private Integer key;
    private String name;
    private String type;

    public SearchDTO(){
    }

    public SearchDTO(Integer key, String name, String type) {
        this.key = key;
        this.name = name;
        this.type = type;
    }


    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SearchDTO searchDTO = (SearchDTO) o;
        return Objects.equals(key, searchDTO.key) && Objects.equals(name, searchDTO.name) && Objects.equals(type, searchDTO.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, name, type);
    }
}
