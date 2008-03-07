package org.brylex.sandbox.routing;

import org.mule.api.MuleMessage;
import org.mule.api.endpoint.ImmutableEndpoint;
import org.mule.routing.outbound.FilteringListMessageSplitter;
import org.mule.DefaultMuleMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author <a href="mailto:rune.peter.bjornstad@bouvet.no">Rune Peter Bjørnstad</a>
 */
public class StringSplitterOutboundRouter extends FilteringListMessageSplitter
{
    protected void initialise(MuleMessage message)
    {

        if (message.getPayload() instanceof String == false)
        {
            throw new IllegalArgumentException("Only java.lang.String payloads are accepted.");
        }

        List<String> list = new ArrayList<String>();

        try
        {
            String payload = message.getPayloadAsString();

            StringTokenizer tokens = new StringTokenizer(payload, " ");

            while (tokens.hasMoreTokens())
            {
                list.add(tokens.nextToken());
            }
        }
        catch (Exception e)
        {
            throw new IllegalStateException("Unable to split the payload into chunks.", e);
        }

        MuleMessage newMessage = new DefaultMuleMessage(list);

        super.initialise(newMessage);        
    }

}
