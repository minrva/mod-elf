
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
    "email",
    "itemname",
    "returnday",
    "returntime",
    "pdf",
    "piece_list"
})
public class Item_ {

    @JsonProperty("id")
    private String id;
    @JsonProperty("itemid")
    private String itemid;
    @JsonProperty("email")
    private String email;
    @JsonProperty("itemname")
    private String itemname;
    @JsonProperty("returnday")
    private String returnday;
    @JsonProperty("returntime")
    private String returntime;
    @JsonProperty("pdf")
    private String pdf;
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

    public Item_ withId(String id) {
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

    public Item_ withItemid(String itemid) {
        this.itemid = itemid;
        return this;
    }

    /**
     * 
     * @return
     *     The email
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    public Item_ withEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * 
     * @return
     *     The itemname
     */
    @JsonProperty("itemname")
    public String getItemname() {
        return itemname;
    }

    /**
     * 
     * @param itemname
     *     The itemname
     */
    @JsonProperty("itemname")
    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public Item_ withItemname(String itemname) {
        this.itemname = itemname;
        return this;
    }

    /**
     * 
     * @return
     *     The returnday
     */
    @JsonProperty("returnday")
    public String getReturnday() {
        return returnday;
    }

    /**
     * 
     * @param returnday
     *     The returnday
     */
    @JsonProperty("returnday")
    public void setReturnday(String returnday) {
        this.returnday = returnday;
    }

    public Item_ withReturnday(String returnday) {
        this.returnday = returnday;
        return this;
    }

    /**
     * 
     * @return
     *     The returntime
     */
    @JsonProperty("returntime")
    public String getReturntime() {
        return returntime;
    }

    /**
     * 
     * @param returntime
     *     The returntime
     */
    @JsonProperty("returntime")
    public void setReturntime(String returntime) {
        this.returntime = returntime;
    }

    public Item_ withReturntime(String returntime) {
        this.returntime = returntime;
        return this;
    }

    /**
     * 
     * @return
     *     The pdf
     */
    @JsonProperty("pdf")
    public String getPdf() {
        return pdf;
    }

    /**
     * 
     * @param pdf
     *     The pdf
     */
    @JsonProperty("pdf")
    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public Item_ withPdf(String pdf) {
        this.pdf = pdf;
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

    public Item_ withPieceList(List<String> pieceList) {
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

    public Item_ withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
