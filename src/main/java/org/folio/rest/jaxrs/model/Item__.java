
package org.folio.rest.jaxrs.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
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
    "pdf"
})
public class Item__ {

    @JsonProperty("id")
    private String id;
    @JsonProperty("itemid")
    private String itemid;
    @JsonProperty("email")
    private String email;
    @JsonProperty("itemname")
    private String itemname;
    @JsonProperty("pdf")
    private String pdf;
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

    public Item__ withId(String id) {
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

    public Item__ withItemid(String itemid) {
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

    public Item__ withEmail(String email) {
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

    public Item__ withItemname(String itemname) {
        this.itemname = itemname;
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

    public Item__ withPdf(String pdf) {
        this.pdf = pdf;
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

    public Item__ withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
