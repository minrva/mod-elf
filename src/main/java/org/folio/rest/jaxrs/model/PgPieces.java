
package org.folio.rest.jaxrs.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "id",
    "itemid",
    "piece_list"
})
public class PgPieces {

    @JsonProperty("id")
    private String id;
    @JsonProperty("itemid")
    private String itemid;
    @JsonProperty("piece_list")
    @Valid
    private List<String> pieceList = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public PgPieces withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The itemid
     */
    @JsonProperty("itemid")
    public String getItemid() {
        return itemid;
    }

    /**
     * 
     * @param itemid
     *     The itemid
     */
    @JsonProperty("itemid")
    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public PgPieces withItemid(String itemid) {
        this.itemid = itemid;
        return this;
    }

    /**
     * 
     * @return
     *     The pieceList
     */
    @JsonProperty("piece_list")
    public List<String> getPieceList() {
        return pieceList;
    }

    /**
     * 
     * @param pieceList
     *     The piece_list
     */
    @JsonProperty("piece_list")
    public void setPieceList(List<String> pieceList) {
        this.pieceList = pieceList;
    }

    public PgPieces withPieceList(List<String> pieceList) {
        this.pieceList = pieceList;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public PgPieces withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
