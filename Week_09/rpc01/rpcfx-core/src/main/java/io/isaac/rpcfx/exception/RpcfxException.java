package io.isaac.rpcfx.exception;

/**
 * @author think
 * @date 2020/12/15
 */
public class RpcfxException extends RuntimeException {

    public RpcfxException() {
        super();
    }

    public RpcfxException(String message, Throwable cause) {
        super(message, cause);
    }

    public RpcfxException(String message) {
        super("rpcfx:"+message);
    }

    public RpcfxException(Throwable cause) {
        super(cause);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace(System.err.append("->rpcfx Exception"));
    }

}
