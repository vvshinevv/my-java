package com.myjava.servicelocator;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ServiceLocator {
    private InitialContext ic;
    private Map<String, Object> cache;
    private static ServiceLocator me;

    static {
        me = new ServiceLocator();
    }

    private ServiceLocator() {
        cache = Collections.synchronizedMap(new HashMap<>());
    }

    public InitialContext getInitialContext() throws NamingException {
        try {
            if (ic == null) {
                ic = new InitialContext();
            }
        } catch (NamingException e) {
            throw e;
        }

        return ic;
    }

    public static ServiceLocator getInstance() {
        return me;
    }

    public EJBLocalHome getLocalHome(String jndiHomeName) throws Exception {
        EJBLocalHome home;
        try {
            if (cache.containsKey(jndiHomeName)) {
                home = (EJBLocalHome) cache.get(jndiHomeName);
            } else {
                home = (EJBLocalHome) getInitialContext().lookup(jndiHomeName);
                cache.put(jndiHomeName, home);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return home;
    }
}
