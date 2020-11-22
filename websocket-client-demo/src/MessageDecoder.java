import java.io.StringReader;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class MessageDecoder implements Decoder.Text<Message> {

  @Override
  public void init(final EndpointConfig config) {
  }

  @Override
  public void destroy() {
  }

  @Override
  public Message decode(final String textMessage) {
    Message message = new Message();
    JsonObject jsonObject = Json.createReader(new StringReader(textMessage)).readObject();
    message.setContent(jsonObject.getString("message"));
    message.setSender(jsonObject.getString("sender"));
    message.setReceived(new Date());
    return message;
  }

  @Override
  public boolean willDecode(final String s) {
    return true;
  }

}