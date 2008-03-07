package org.brylex.sandbox.routing;

import org.mule.DefaultMuleMessage;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.routing.AggregationException;
import org.mule.routing.inbound.CorrelationAggregator;
import org.mule.routing.inbound.EventGroup;

/**
 * @author <a href="mailto:rune.peter.bjornstad@bouvet.no">Rune Peter Bjørnstad</a>
 */
public class StringTokenAggregatorRouter extends CorrelationAggregator
{
    protected MuleMessage aggregateEvents(EventGroup events) throws AggregationException
    {
        MuleEvent[] array = events.toArray();

        StringBuffer buf = new StringBuffer();
        try
        {
            for (MuleEvent event : array)
            {
                buf.append(event.getMessage().getPayloadAsString());
                buf.append(' ');
            }
        }
        catch (Exception e)
        {
            throw new AggregationException(events, null);
        }

        MuleMessage message = new DefaultMuleMessage(buf.toString().trim());

        return message;
    }
}
