package adapter;

import com.google.inject.AbstractModule;

/**
 *
 */
public class XpayModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Xpay.class).to(XpayImpl.class);
    }
}
