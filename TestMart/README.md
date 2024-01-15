### Setup:
To build the project, download <a href="https://github.com/javaee/metro-jax-ws?tab=readme-ov-file">jaxws-ri-2.3.0.zip</a> and add all jars under `lib` to `webapp/WEB-INF/lib` of the project 


### Testing:
##### The jsp page can be accessed via http://localhost:8080/TestMart/NewFile.jsp
  ![image](https://github.com/anushkadeshpande/soap-webservices-scratchpad/assets/53345232/df0d21a3-4b65-46be-8bdf-7428d8d7b334)


#### Webservice home:
  http://localhost:8080/TestMart/home
  ![image](https://github.com/anushkadeshpande/soap-webservices-scratchpad/assets/53345232/496f1cd4-02a2-4881-83e7-928afbc7fa7c)

#### WSDL:
  http://localhost:8080/TestMart/home?wsdl

```xml
<definitions xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" xmlns:wsp="http://www.w3.org/ns/ws-policy" xmlns:wsp1_2="http://schemas.xmlsoap.org/ws/2004/09/policy" xmlns:wsam="http://www.w3.org/2007/05/addressing/metadata" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tns="http://example.com/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns="http://schemas.xmlsoap.org/wsdl/" targetNamespace="http://example.com/" name="ProductCatalogService">
  <types>
    <xsd:schema>
      <xsd:import namespace="http://example.com/" schemaLocation="http://localhost:8080/TestMart/home?xsd=1"/>
    </xsd:schema>
  </types>
  <message name="getProductCategories">
    <part name="parameters" element="tns:getProductCategories"/>
  </message>
  <message name="getProductCategoriesResponse">
    <part name="parameters" element="tns:getProductCategoriesResponse"/>
  </message>
  <portType name="ProductCatalog">
    <operation name="getProductCategories">
      <input wsam:Action="http://example.com/ProductCatalog/getProductCategoriesRequest" message="tns:getProductCategories"/>
      <output wsam:Action="http://example.com/ProductCatalog/getProductCategoriesResponse" message="tns:getProductCategoriesResponse"/>
    </operation>
  </portType>
  <binding name="ProductCatalogPortBinding" type="tns:ProductCatalog">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" style="document"/>
    <operation name="getProductCategories">
      <soap:operation soapAction=""/>
      <input>
        <soap:body use="literal"/>
      </input>
      <output>
        <soap:body use="literal"/>
      </output>
    </operation>
  </binding>
  <service name="ProductCatalogService">
    <port name="ProductCatalogPort" binding="tns:ProductCatalogPortBinding">
      <soap:address location="http://localhost:8080/TestMart/home"/>
    </port>
  </service>
</definitions>
```

### Testing using SOAPUI
![image](https://github.com/anushkadeshpande/soap-webservices-scratchpad/assets/53345232/0b866b87-c8f3-4651-b1d2-6bec569694c8)
