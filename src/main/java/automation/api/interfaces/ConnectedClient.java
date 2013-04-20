package automation.api.interfaces;

import javax.xml.namespace.QName;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface ConnectedClient {
	void uploadFile(String fileName, CommonsMultipartFile fileData) throws Exception;
	void connectToRemoteDevice(String WS_URL, QName qname);
	boolean isDeviceAvailable();
	Object invokeMethod(String methodName) throws Exception;
	Object invokeMethod(String methodName, Object[] parametersArray) throws Exception;
}