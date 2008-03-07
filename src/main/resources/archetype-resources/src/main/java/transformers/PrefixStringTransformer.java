package org.brylex.sandbox.transformers;

import org.mule.transformer.AbstractTransformer;
import org.mule.api.transformer.TransformerException;

/**
 * @author <a href="mailto:rune.peter.bjornstad@bouvet.no">Rune Peter Bjørnstad</a>
 */
public class PrefixStringTransformer extends AbstractTransformer
{
    private String prefix = "MESSAGE";

    public PrefixStringTransformer()
    {
        registerSourceType(String.class);
        setReturnClass(String.class);
    }

    protected Object doTransform(Object src, String encoding) throws TransformerException
    {
        return String.format("%s: [%s]", prefix, src);
    }

    public String getPrefix()
    {
        return prefix;
    }

    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }
}
