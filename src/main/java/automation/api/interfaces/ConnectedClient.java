package automation.api.interfaces;

public interface ConnectedClient {
	Object invokeMethod(String methodName) throws NoSuchMethodException;
	Object invokeMethod(String methodName, Object[] parametersArray) throws NoSuchMethodException;
}