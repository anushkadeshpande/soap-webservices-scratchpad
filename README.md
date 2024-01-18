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
