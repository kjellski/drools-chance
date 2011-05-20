package org.drools.chance.constraints.core.connectives.factories.probability.discrete;

import org.drools.chance.constraints.core.IConstraintCore;
import org.drools.chance.constraints.core.connectives.IConnectiveFactory;
import org.drools.chance.constraints.core.connectives.impl.MVLFAMILIES;
/**
 * Created by IntelliJ IDEA.
 * User: doncat
 * Date: 27/01/11
 * Time: 16.42
 * To change this template use File | Settings | File Templates.
 */
public class DiscreteProbabilityConnectiveFactory implements IConnectiveFactory {

    public IConstraintCore getAnd() {
        return org.drools.chance.constraints.core.connectives.impl.product.And.getInstance();
    }

    public IConstraintCore getAnd(String type) {
        if (MVLFAMILIES.LUKAS.value().equals(type))
            return org.drools.chance.constraints.core.connectives.impl.lukas.And.getInstance();
        else if (MVLFAMILIES.GODEL.value().equals(type))
            return org.drools.chance.constraints.core.connectives.impl.godel.And.getInstance();
        else if (MVLFAMILIES.GODEL.value().equals(type))
            return org.drools.chance.constraints.core.connectives.impl.product.And.getInstance();
        else
            return org.drools.chance.constraints.core.connectives.impl.product.And.getInstance();
    }

    public IConstraintCore getAnd(String type, Object... params) {
        return getAnd(type);
    }

    public IConstraintCore getOr() {
        return org.drools.chance.constraints.core.connectives.impl.product.Or.getInstance();
    }

    public IConstraintCore getOr(String type) {
         if (MVLFAMILIES.LUKAS.value().equals(type))
            return org.drools.chance.constraints.core.connectives.impl.lukas.Or.getInstance();
        else if (MVLFAMILIES.GODEL.value().equals(type))
            return org.drools.chance.constraints.core.connectives.impl.godel.Or.getInstance();
        else if (MVLFAMILIES.GODEL.value().equals(type))
            return org.drools.chance.constraints.core.connectives.impl.product.Or.getInstance();
        else
            return org.drools.chance.constraints.core.connectives.impl.product.Or.getInstance();
    }

    public IConstraintCore getOr(String type, Object... params) {
        return getOr(type);
    }

    public IConstraintCore getNot() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public IConstraintCore getNot(String type) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public IConstraintCore getNot(String type, Object... params) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public IConstraintCore getXor() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public IConstraintCore getXor(String type) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public IConstraintCore getXor(String type, Object... params) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public IConstraintCore getEquiv() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public IConstraintCore getEquiv(String type) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public IConstraintCore getEquiv(String type, Object... params) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public IConstraintCore getImplies() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public IConstraintCore getImplies(String type) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public IConstraintCore getImplies(String type, Object... params) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
