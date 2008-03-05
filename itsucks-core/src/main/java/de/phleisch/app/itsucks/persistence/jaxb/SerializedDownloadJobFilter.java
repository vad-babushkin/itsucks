//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.03.05 at 10:13:48 PM GMT 
//


package de.phleisch.app.itsucks.persistence.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://itsucks.sourceforge.net/ItSucksJobSchema}serializedJobFilter">
 *       &lt;sequence>
 *         &lt;element name="maxRecursionDepth" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="urlPrefix" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="allowedHostName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="saveToDisk" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="alreadyAddedUri" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "maxRecursionDepth",
    "urlPrefix",
    "allowedHostName",
    "saveToDisk",
    "alreadyAddedUri"
})
@XmlRootElement(name = "serializedDownloadJobFilter")
public class SerializedDownloadJobFilter
    extends SerializedJobFilter
{

    protected int maxRecursionDepth;
    @XmlElement(required = true, nillable = true)
    protected String urlPrefix;
    protected List<String> allowedHostName;
    protected List<String> saveToDisk;
    protected List<String> alreadyAddedUri;

    /**
     * Gets the value of the maxRecursionDepth property.
     * 
     */
    public int getMaxRecursionDepth() {
        return maxRecursionDepth;
    }

    /**
     * Sets the value of the maxRecursionDepth property.
     * 
     */
    public void setMaxRecursionDepth(int value) {
        this.maxRecursionDepth = value;
    }

    /**
     * Gets the value of the urlPrefix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlPrefix() {
        return urlPrefix;
    }

    /**
     * Sets the value of the urlPrefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlPrefix(String value) {
        this.urlPrefix = value;
    }

    /**
     * Gets the value of the allowedHostName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedHostName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedHostName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAllowedHostName() {
        if (allowedHostName == null) {
            allowedHostName = new ArrayList<String>();
        }
        return this.allowedHostName;
    }

    /**
     * Gets the value of the saveToDisk property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the saveToDisk property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSaveToDisk().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSaveToDisk() {
        if (saveToDisk == null) {
            saveToDisk = new ArrayList<String>();
        }
        return this.saveToDisk;
    }

    /**
     * Gets the value of the alreadyAddedUri property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alreadyAddedUri property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlreadyAddedUri().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAlreadyAddedUri() {
        if (alreadyAddedUri == null) {
            alreadyAddedUri = new ArrayList<String>();
        }
        return this.alreadyAddedUri;
    }

}
