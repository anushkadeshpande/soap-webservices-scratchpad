### SOAP Webservices 💻

#### WSDL used: http://wsgeoip.lavasoft.com/ipservice.asmx?WSDL

#### WSDL
Stands for ***Web service description language***
Contains methods exposed, their arguments and return types

#### SEI
Stands for ***Service Endpoint Interface***

##### wsimport
It is tool used to generate stubs
```
wsimport -keep -s <stubs-generation-location> <wsdl-url>
```


> ***-keep*** is used to retain the source files of the stubs



Service and portname from the wsdl is used to figure out which stub is to be used

<br>

### Binding
It is a way to configure what goes in the webservice and what comes out
Used to specify the data formats used.
There are two styles of binding:
#### Document Style:
  - An xsd schema is defined and and that is referred
  - This is the default binding style
  - Provides more validation (due to separate xsd)
  - Example:
      
  <a href="https://github.com/anushkadeshpande/soap-webservices-scratchpad/blob/53c3062f93045b9a73c9e6c2066c526f36c62bd7/TestMart/wsdl/Document_Style_wsdl.xml">🔗 WSDL</a>
      
  The following part in wsdl links xsd to the wsdl
  ```xml
    <types>
      <xsd:schema>
        <xsd:import namespace="http://example.com/" schemaLocation="http://localhost:8080/TestMart/ShopInfoService?xsd=1"/>
      </xsd:schema>
    </types>
  ```
    

  This is the xsd where the elements `getShopInfo` and `getShopInfoResponse` are defined. It specifies the input and output types for each of them.

  <a href="https://github.com/anushkadeshpande/soap-webservices-scratchpad/blob/53c3062f93045b9a73c9e6c2066c526f36c62bd7/TestMart/xsd/ShopInfoService_xsd.xml">🔗 XSD</a>

  ```xml
    <xs:schema xmlns:tns="http://example.com/" xmlns:xs="http://www.w3.org/2001/XMLSchema" version="1.0" targetNamespace="http://example.com/">
      <xs:element name="getShopInfo" type="tns:getShopInfo"/>
      <xs:element name="getShopInfoResponse" type="tns:getShopInfoResponse"/>
      <xs:complexType name="getShopInfo">
        <xs:sequence>
          <xs:element name="arg0" type="xs:string" minOccurs="0"/>
        </xs:sequence>
      </xs:complexType>
      <xs:complexType name="getShopInfoResponse">
        <xs:sequence>
          <xs:element name="return" type="xs:string" minOccurs="0"/>
        </xs:sequence>
      </xs:complexType>
    </xs:schema>
  ```
  > Note: The `minOccurs` here means the number of times the element can appear. Here, it is 0 to accomodate null values as well

  The following part links the types defined in xsd with the wsdl

  ```xml
    <message name="getShopInfo">
      <part name="parameters" element="tns:getShopInfo"/>
    </message>
    <message name="getShopInfoResponse">
      <part name="parameters" element="tns:getShopInfoResponse"/>
    </message>
  ```
  
  This part declares the actual binding:
  ```xml
  <binding name="ShopInfoPortBinding" type="tns:ShopInfo">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" style="document"/>
    <operation name="getShopInfo">
      <soap:operation soapAction=""/>
      <input>
        <soap:body use="literal"/>
      </input>
      <output>
        <soap:body use="literal"/>
      </output>
    </operation>
  </binding>
  ``` 
#### RPC Style:
  - The message is specified as simple name value pair
  - No schema is generated, instead it is defined inline
  - Example
     
  <a href="https://github.com/anushkadeshpande/soap-webservices-scratchpad/blob/53c3062f93045b9a73c9e6c2066c526f36c62bd7/TestMart/wsdl/RPC_Style_wsdl.xml">🔗 WSDL</a>
  
  There is no type section in this type of binding.
  ```xml
  <types/>
  ```
  Instead, the types are declared in message section itself
  ```xml
  <message name="getShopInfo">
    <part name="arg0" type="xsd:string"/>
  </message>
  <message name="getShopInfoResponse">
    <part name="return" type="xsd:string"/>
  </message>
  ```

  And lastly, the style is mentioned in the binding section and an additional namespace attribute is added
  ```xml
    <binding name="ShopInfoPortBinding" type="tns:ShopInfo">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" style="rpc"/>
    <operation name="getShopInfo">
      <soap:operation soapAction=""/>
      <input>
        <soap:body use="literal" namespace="http://example.com/"/>
      </input>
      <output>
        <soap:body use="literal" namespace="http://example.com/"/>
      </output>
    </operation>
  </binding>
  ```
