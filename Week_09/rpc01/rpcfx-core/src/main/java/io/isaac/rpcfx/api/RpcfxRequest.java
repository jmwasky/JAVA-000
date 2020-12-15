package io.isaac.rpcfx.api;

public class RpcfxRequest {

  private String serviceClass;

  private Class<?> clazz;

  private String method;

  private Object[] params;

  public Class<?> getClazz() {
      return clazz;
  }
  public void setClazz( Class<?> clazz ) {
      this.clazz = clazz;
  }
  public String getServiceClass() {
      return serviceClass;
  }

  public void setServiceClass(String serviceClass) {
      this.serviceClass = serviceClass;
  }

  public String getMethod() {
      return method;
  }

  public void setMethod(String method) {
      this.method = method;
  }

  public Object[] getParams() {
      return params;
  }

  public void setParams(Object[] params) {
        this.params = params;
    }
}
