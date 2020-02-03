package org.emplacamento.integration.client;

import javax.xml.soap.*;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class SOAPClientSAAJ {
	
	
	   public static void main(String args[]) {
	        /*
	            The example below requests from the Web Service at:
	             http://www.webservicex.net/uszip.asmx?op=GetInfoByCity


	            To call other WS, change the parameters below, which are:
	             - the SOAP Endpoint URL (that is, where the service is responding from)
	             - the SOAP Action

	            Also change the contents of the method createSoapEnvelope() in this class. It constructs
	             the inner part of the SOAP envelope that is actually sent.
	         */
	        String soapEndpointUrl = "http://200.151.208.131:9090/DealernetGateway/DealerNetGateway.asmx";
	        String soapAction = "http://tempuri.org/ListarFuncionarios";

	        callSoapWebService(soapEndpointUrl, soapAction);
	    }
	
	
	
	private static void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myNamespace = "tem";
        String myNamespaceURI = "http://tempuri.org/";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);
    

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem0 = soapBody.addChildElement("ListarFuncionarios", myNamespace);
        SOAPElement soapBodyElem = soapBodyElem0.addChildElement("a_XmlAutenticacao", myNamespace);
        SOAPElement soapBodyElem1 = soapBodyElem0.addChildElement("a_XmlDados", myNamespace);
        
        soapBodyElem.appendChild( soapBodyElem.getOwnerDocument().createCDATASection("<Autenticacao>\n" + 
        		"		<Usuario>quality</Usuario>\n" + 
        		"		<Senha>123456</Senha>\n" + 
        		"		<Empresa>01</Empresa>\n" + 
        		"		</Autenticacao>")); 
        
     
          
        soapBodyElem1.appendChild(
	      soapBodyElem1.getOwnerDocument().createCDATASection("<ParametrosListarFuncionarios>\n" + 
			"<NomeFuncionario></NomeFuncionario>\n" + 
			"<StatusUsuario>S</StatusUsuario>\n" + 
			"<DescricaoGrupoUsuario></DescricaoGrupoUsuario>\n" + 
			"<Codigo></Codigo>\n" + 
			"<LoginUsuario>quality</LoginUsuario>\n" + 
			"<CodigoEquipe></CodigoEquipe>\n" + 
			"<CodigoEmpresa></CodigoEmpresa>\n" + 
			"<CodigoGrupoUsuario></CodigoGrupoUsuario>\n" + 
			"<CodigoObjetoSistema></CodigoObjetoSistema>\n" + 
			"<CodigoParametro></CodigoParametro>\n" + 
			"<CodigoRegraSistema></CodigoRegraSistema>\n" + 
			"<CodigoControleObjeto></CodigoControleObjeto>\n" + 
			"<TipoFuncionario></TipoFuncionario>\n" + 
			"<UsaMarketPlace></UsaMarketPlace>\n" + 
			"</ParametrosListarFuncionarios>\n"
			)); 
        
     
    }

	
	
	  private static void callSoapWebService(String soapEndpointUrl, String soapAction) {
	        try {
	            // Create SOAP Connection
	            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
	            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

	            // Send SOAP Message to SOAP Server
	        //    createSOAPRequest(soapAction);
	              SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction), soapEndpointUrl);

	            // Print the SOAP Response
	            System.out.println("Response SOAP Message:");
	            String d;
	       soapResponse.writeTo(System.out);
	       
	       JAXBContext jaxbContext = JAXBContext.newInstance(TabFun.class);
	       Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller(); 
	       
	       TabFun tab_fun = (TabFun) jaxbUnmarshaller.unmarshal(soapResponse.getSOAPBody().getAttribute("tab_fun").ex); 
	       soapResponse.getSOAPBody().extractContentAsDocument();
	            System.out.println();

	            soapConnection.close();
	        } catch (Exception e) {
	            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
	            e.printStackTrace();
	        }
	    }
	  
	  
	  
	  
	  private static SOAPMessage createSOAPRequest(String soapAction) throws Exception {
	        MessageFactory messageFactory = MessageFactory.newInstance();
	        SOAPMessage soapMessage = messageFactory.createMessage();

	        createSoapEnvelope(soapMessage);

	        MimeHeaders headers = soapMessage.getMimeHeaders();
	        headers.addHeader("SOAPAction", soapAction);

	        soapMessage.saveChanges();

	        /* Print the request message, just for debugging purposes */
	        System.out.println("Request SOAP Message:");
	        soapMessage.writeTo(System.out);
	        System.out.println("\n");

	        return soapMessage;
	    }


}
