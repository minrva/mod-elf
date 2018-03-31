
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
    "total_pieces",
    "price",
    "piece_list"
})
public class Item {

    @JsonProperty("id")
    private String id;
    @JsonProperty("itemid")
    private String itemid;
    @JsonProperty("total_pieces")
    private String totalPieces;
    @JsonProperty("price")
    private String price;
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

    public Item withId(String id) {
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

    public Item withItemid(String itemid) {
        this.itemid = itemid;
        return this;
    }

    /**
     * 
     * @return
     *     The totalPieces
     */
    @JsonProperty("total_pieces")
    public String getTotalPieces() {
        return totalPieces;
    }

    /**
     * 
     * @param totalPieces
     *     The total_pieces
     */
    @JsonProperty("total_pieces")
    public void setTotalPieces(String totalPieces) {
        this.totalPieces = totalPieces;
    }

    public Item withTotalPieces(String totalPieces) {
        this.totalPieces = totalPieces;
        return this;
    }

    /**
     * 
     * @return
     *     The price
     */
    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    /**
     * 
     * @param price
     *     The price
     */
    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    public Item withPrice(String price) {
        this.price = price;
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

    public Item withPieceList(List<String> pieceList) {
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

    public Item withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
