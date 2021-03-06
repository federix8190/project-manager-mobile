package py.fpuna.is2.proyectos.alpha.service.exceptionmappers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class ErrorEntity {

    private Integer status;
    private String header;

    private List<String> messages;

    /**
     *
     * @return
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public String getHeader() {
        return header;
    }

    /**
     *
     * @param header
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     *
     * @return
     */
    public List<String> getMessages() {
        return messages;
    }

    /**
     *
     * @param messages
     */
    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    /**
     *
     */
    public ErrorEntity() {
    }

    /**
     *
     * @param header
     * @param messages
     */
    public ErrorEntity(Integer status, String header, List<String> messages) {
        this.status = status;
        this.header = header;
        this.messages = messages;
    }

    /**
     *
     * @param header
     * @param messages
     * @return
     */
    public static Response build(Integer status, String header, List<String> messages) {
        return Response.status(Status.fromStatusCode(status))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .entity(new ErrorEntity(status, header, messages)).build();
    }

    /**
     *
     * @param header
     * @param message
     * @return
     */
    public static Response build(Integer status, String header, String message) {
        List<String> mensajes = new ArrayList<String>();
        mensajes.add(message);
        return Response.status(Status.fromStatusCode(status))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .entity(new ErrorEntity(status, header, mensajes)).build();
    }
}
